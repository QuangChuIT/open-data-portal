package vn.vnpt.portlet.article.publisher.cache;

public class MemcachedKey {

    public final static String[] DEFAULT_SERVER = new String[]{"127.0.0.1:11211"};

    public final static String SERVER_KEY = "portal.memcached.address";

    public final static String CACHED_PREFIX = "portal.memcached.prefix";

    public static String getKey(String finalKey, String methodPrefixKey) {

        return methodPrefixKey + finalKey;
    }
}
