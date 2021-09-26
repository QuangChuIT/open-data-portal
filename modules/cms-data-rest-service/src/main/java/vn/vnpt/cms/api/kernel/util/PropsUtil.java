package vn.vnpt.cms.api.kernel.util;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropsUtil {

    private static final Log LOGGER = LogFactoryUtil.getLog(PropsUtil.class);
    private static Properties prop = new Properties();

    public static Properties readPropertyFile() throws Exception {
        if (prop.isEmpty()) {
            try (InputStream input = PropsUtil.class.getClassLoader().getResourceAsStream("config.properties")) {
                prop.load(input);
            } catch (IOException ex) {
                LOGGER.error(ex);
                throw ex;
            }
        }
        return prop;
    }

    public static String get(String key) {
        if (prop.isEmpty()) {
            try {
                prop = readPropertyFile();
            } catch (Exception e) {
                LOGGER.error(e);
            }
        }
        return prop.getProperty(key);
    }
}
