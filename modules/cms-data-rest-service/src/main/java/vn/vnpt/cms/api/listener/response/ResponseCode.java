package vn.vnpt.cms.api.listener.response;

public class ResponseCode {
    protected int code;
    protected String message;

    public ResponseCode() {
    }

    public ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return "ResponseInfo [code=" + this.code + ", message=" + this.message + "]";
    }
}
