package vn.vnpt.cms.api.listener.response;

public class ResultCode {
    public static final ResultCodeObj SUCCESS = new ResultCodeObj(0, "SUCCESS");
    public static final ResultCodeObj TRANS_SUCCESS = new ResultCodeObj(0, "SUCCESS");
    public static final ResultCodeObj TRANS_FAIL = new ResultCodeObj(1, "FAIL");
    public static final ResultCodeObj TOKEN_INVALID = new ResultCodeObj(1, "TOKEN INVALID");
    public static final ResultCodeObj TOKEN_EXPIRE = new ResultCodeObj(2, "TOKEN EXPIRE");
    public static final ResultCodeObj REQUEST_INVALID = new ResultCodeObj(3, "REQUEST INVALID");
    public static final ResultCodeObj SYSTEM_BUSY = new ResultCodeObj(4, "SYSTEM BUSY");
    public static final ResultCodeObj UNKNOWN_ERROR = new ResultCodeObj(5, "UNKNOWN ERROR");
    public static final ResultCodeObj USERNAME_INVALID = new ResultCodeObj(6, "USERNAME INVALID");
    public static final ResultCodeObj PASSWORD_INVALID = new ResultCodeObj(7, "PASSWORD INVALID");
    public static final ResultCodeObj QUANTITY_INVALID = new ResultCodeObj(10, "QUANTITY INVALID");
    public static final ResultCodeObj PARTNER_NOT_EXIST = new ResultCodeObj(12, "PARTNER NOT EXIST");
    public static final ResultCodeObj PHONE_INVALID = new ResultCodeObj(13, "PHONE INVALID");
    public static final ResultCodeObj MAIL_INVALID = new ResultCodeObj(14, "MAIL INVALID");
    public static final ResultCodeObj AMOUNT_TOTAL_INVALID = new ResultCodeObj(8, "AMOUNT TOTAL INVALID");
    public static final ResultCodeObj FCM_TOKEN_INVALID = new ResultCodeObj(9, "FCM TOKEN INVALID");
    public static final ResultCodeObj ORDER_TIME_INVALID = new ResultCodeObj(10, "ORDER TIME INVALID");
    public static final ResultCodeObj DESIRED_DELIVERY_TIME_INVALID = new ResultCodeObj(11, "DESIRED DELIVERY TIME INVALID");
    public static final ResultCodeObj FOLDER_INVALID = new ResultCodeObj(12, "FOLDER INVALID");
    public static final ResultCodeObj SHOP_CODE_INVALID = new ResultCodeObj(12, "SHOP CODE INVALID");
    public static final ResultCodeObj CATEGORY_NOT_SELECTED = new ResultCodeObj(14, "CATEGORY NOT SELECTED");
    public static final ResultCodeObj PROVINCE_NOT_SELECTED = new ResultCodeObj(15, "PROVINCE NOT SELECTED");
    public static final ResultCodeObj DATE_INVALID = new ResultCodeObj(16, "DATE INVALID");
    public static final ResultCodeObj TIME_INVALID = new ResultCodeObj(17, "TIME INVALID");
    public static final ResultCodeObj PREFIX_PRODUCT_INVALID = new ResultCodeObj(18, "PREFIX PRODUCT INVALID");
    public static final ResultCodeObj IMAGE_SYNC_NOT_OK = new ResultCodeObj(18, "IMAGE SYNC NOT OK");
    public static final ResultCodeObj CAPTCHA_INVALID = new ResultCodeObj(19, "CAPTCHA INVALID");
    public static final ResultCodeObj IP_IS_LOCKED = new ResultCodeObj(20, "IP IS LOCKED");
    public static final ResultCodeObj COLUNM_NAME_INVALID = new ResultCodeObj(21, "COLUNM NAME INVALID");
    public static final ResultCodeObj CODE_IS_DUPLICATE = new ResultCodeObj(22, "CODE IS DUPLICATE");
    public static final ResultCodeObj FORMAT_INVALID = new ResultCodeObj(23, "DATA FORMAT INVALID");
    public static final ResultCodeObj COLUMN_NAME_DUPLICATE = new ResultCodeObj(24, "COLUMN NAME IS DUPLICATE");
    public static final ResultCodeObj NO_DATA = new ResultCodeObj(25, "NO DATA");

    public ResultCode() {
    }
}
