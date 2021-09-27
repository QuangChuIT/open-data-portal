package vn.vnpt.cms.api.config;

import java.util.LinkedHashMap;

public class CoreConfig {
    public static final String GOOGLE_SECRET_KEY = "6LcJVAAVAAAAAA1dCk6LOvo97mdCzM6RLWg89ZV7";
    public static final String GOOGLE_API_ENDPOINT = "https://www.google.com/recaptcha/api/siteverify";
    public static CoreConfig instance;
    public static String FILE_DIR = "uploaded";
    public static int API_PORT = 10400;
    public static String CONTEXT_PATH = "/api";
    public static String API_DAY_INPUT_FORMAT = "dd-MM-yyyy";
    public static String API_DATE_TIME_INPUT_FORMAT = "dd-MM-yyyy_HH_mm_ss";
    public static String API_DATE_TIME_OUTPUT_FORMAT = "dd/MM/yyyy HH:mm:ss";
    public static String API_DATE_TIME_OUTPUT_ACCOUNT_GET_LIST = "HH:mm - dd/MM/yyyy ";
    public static String BACKUP_FOLDER = "/opt/bkav/bin/cms_api/backup_db/";
    public static String DEFAULT_REPLACE_NULL_STRING_VALUE = "all";
    public static String BASE_FONTS_FOLDER = "/opt/bkav/bin/cms_api/resource/fonts/arial.ttf";
    public static float STT_LENGTH = 50.0F;
    public static float COLUMN_LENGTH = 150.0F;
    public static int PAGE_SIZE = 20;
    public static String DEFAULT_PASS_WORD = "bkav123!@";
    public static int TOKEN_LOG_MAX_LENGTH = 50;
    public static int RESPONSE_LOG_MAX_LENGTH = 500;
    public static String URL_IMAGE = "";
    public static LinkedHashMap<Integer, Double> mapConfigResizeFile = new LinkedHashMap();
    public static String UPLOAD_DIR = "";
    public static String PUBLIC_DIR = "";
    public static String LOAD_DIR = "";
    public static String TEMP_DIR = "D:/";

    public CoreConfig(String configFile, boolean autoReload, long reload_delay_ms) {

    }

    public static synchronized CoreConfig createInstance(String configFile, boolean autoReload, long reload_delay_ms) {
        if (instance == null) {
            instance = new CoreConfig(configFile, autoReload, reload_delay_ms);
        }

        return instance;
    }

    public void reloadProcess() throws Exception {
    }
}
