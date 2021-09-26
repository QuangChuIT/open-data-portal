package vn.vnpt.cms.api.listener.response;

public class BaseResp {
    protected ResponseCode error;
    protected Object data;
    public BaseResp() {
    }

    public BaseResp(int code, String message) {
        this.error = new ResponseCode(code, message);
    }

    public BaseResp(int code, String message, Object data) {
        this.error = new ResponseCode(code, message);
        this.data = data;
    }

    public BaseResp(ResponseCode error, Object data) {
        this.error = error;
        this.data = data;
    }

    public BaseResp(ResultCodeObj rsCode) {
        this.error = new ResponseCode(rsCode.getCode(), rsCode.getMessage());
    }

    public BaseResp(ResultCodeObj rsCode, Object data) {
        this.error = new ResponseCode(rsCode.getCode(), rsCode.getMessage());
        this.data = data;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseCode getError() {
        return this.error;
    }

    public void setError(ResponseCode error) {
        this.error = error;
    }

    public String toString() {
        return "BaseResp [error=" + this.error + ", data=" + this.data + "]";
    }
}
