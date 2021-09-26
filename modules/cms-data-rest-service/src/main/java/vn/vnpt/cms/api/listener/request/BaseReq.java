package vn.vnpt.cms.api.listener.request;

public class BaseReq {
    protected String channel;
    protected String transId;

    public BaseReq() {
    }

    public BaseReq(String channel, String transId) {
        this.channel = channel;
        this.transId = transId;
    }

    public String getChannel() {
        return this.channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getTransId() {
        return this.transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BaseReq [channel=");
        builder.append(this.channel);
        builder.append(", transId=");
        builder.append(this.transId);
        builder.append(", language=");
        builder.append("]");
        return builder.toString();
    }
}
