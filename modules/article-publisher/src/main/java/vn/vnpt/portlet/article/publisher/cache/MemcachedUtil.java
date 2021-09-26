package vn.vnpt.portlet.article.publisher.cache;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PropsUtil;
import net.spy.memcached.AddrUtil;
import net.spy.memcached.ConnectionFactoryBuilder;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.OperationFuture;

import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MemcachedUtil {
    private static MemcachedClient memcachedClient = null;

    private static final Log _log = LogFactoryUtil.getLog(MemcachedUtil.class);

    private static MemcachedUtil INSTANCE;

    private static final String KEY_NAMESPACE_PREFIX = "portal_cached_";

    private static String _prefix = StringPool.BLANK;

    static public MemcachedUtil getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MemcachedUtil();
        }
        return INSTANCE;
    }

    public MemcachedUtil() {
        try {
            List<InetSocketAddress> serverAddress = Collections
                    .singletonList(new InetSocketAddress("127.0.0.1", 11211));

            String address = PropsUtil.get(MemcachedKey.SERVER_KEY);
            if (address != null) {
                String[] temp = address.split(StringPool.COMMA);
                serverAddress = AddrUtil.getAddresses(Arrays
                        .asList(temp));

            }

            ConnectionFactoryBuilder builder = new ConnectionFactoryBuilder();

            memcachedClient = new MemcachedClient(builder.build(),
                    serverAddress);
            _prefix = PropsUtil.get(MemcachedKey.CACHED_PREFIX);
        } catch (Exception e) {
            _log.error(e);
        }
    }

    public boolean create(String key, int timeLife, Object saveObject) {
        return add(key, timeLife, saveObject, false);
    }

    public Object update(String key, int timeLife, Object saveObject) {
        return add(key, timeLife, saveObject, true);
    }

    public Object read(String key) {

        Object result = null;
        try {
            if (memcachedClient != null) {

                String finalKey = buildKey(key);

                result = memcachedClient.get(finalKey);
            }
        } catch (Exception e) {
            _log.error(e);
        }

        return result;
    }

    public boolean delete(String key) {
        boolean iResult = false;
        try {
            if (memcachedClient != null) {

                String finalKey = buildKey(key);

                OperationFuture<Boolean> result = memcachedClient
                        .delete(finalKey);
                iResult = result.get(5L, TimeUnit.SECONDS);
            }
        } catch (Exception e) {
            _log.error(e);
        }

        return iResult;
    }

    private boolean add(String key, int timeLife, Object saveObject,
                        boolean isUpdate) {
        boolean iResult = false;
        try {

            if (memcachedClient != null) {

                String finalKey = buildKey(key);
                OperationFuture<Boolean> result = null;

                if (isUpdate) {
                    result = memcachedClient
                            .set(finalKey, timeLife, saveObject);
                } else {
                    result = memcachedClient
                            .add(finalKey, timeLife, saveObject);
                }
                if (result == null) {
                    return false;
                }

                try {

                    iResult = result.get(5L, TimeUnit.SECONDS);
                } catch (Exception ex) {
                    result.cancel();
                }
            }

        } catch (Exception e) {
            _log.error(e);
        }
        return iResult;
    }

    private static String buildKey(String key) {
        StringBuilder keyBuilder = new StringBuilder(_prefix);
        keyBuilder.append(StringPool.UNDERLINE);
        keyBuilder.append(KEY_NAMESPACE_PREFIX);
        keyBuilder.append(key);
        System.out.println(keyBuilder.toString());
        return keyBuilder.toString();
    }

    public static void main(String[] args) {
        MemcachedUtil.getInstance().add(buildKey("name"), 60000, "QuangCV",false);
    }
}
