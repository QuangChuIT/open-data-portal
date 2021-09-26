// 
// Decompiled by Procyon v0.5.36
// 

package vn.vnpt.cms.api.kernel.db.cmd;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.sql.Connection;

public class DbCommand extends DBCommandBase {
    protected Log logger;
    protected String transId;
    protected String channel;
    protected String sqlCommand;
    protected int code;
    protected String message;

    public DbCommand(final String transId, final String channel) {
        this.logger = LogFactoryUtil.getLog(this.getClass());
        this.code = -1;
        this.message = "unknown";
        this.transId = transId;
        this.channel = channel;
    }

    @Override
    public void invoke(final Connection conn) throws Exception {
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(final int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public String getTransId() {
        return this.transId;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getSqlCommand() {
        return this.sqlCommand;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getClass().getName()) + " [transId=" + this.transId +
                ", channel=" + this.channel + ", sqlCommand=" + this.sqlCommand + ", code="
                + this.code + ", message=" + this.message + "]";
    }
}
