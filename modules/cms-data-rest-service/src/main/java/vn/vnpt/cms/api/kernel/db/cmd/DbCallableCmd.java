// 
// Decompiled by Procyon v0.5.36
// 

package vn.vnpt.cms.api.kernel.db.cmd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public abstract class DbCallableCmd extends DbCommand {
    protected CallableStatement cst;
    protected String procName;
    protected int numberParameter;
    protected int idx;

    public DbCallableCmd(final String transId, final String channel) {
        super(transId, channel);
        this.cst = null;
        this.idx = 1;
    }

    @Override
    public void invoke(final Connection conn) throws Exception {
        try {
            this.setSqlCommand();
            String params = "?";
            if (this.numberParameter > 1) {
                for (int i = 1; i < this.numberParameter; ++i) {
                    params = params + ",?";
                }
            }
            this.sqlCommand = "{call " + this.procName + "(" + params + ")}";
            this.logger.debug(String.format("transId: %s, channel: %s, sqlCommand: %s", this.transId,
                    this.channel, this.sqlCommand.toUpperCase()));
            this.cst = conn.prepareCall(this.sqlCommand);
            conn.setAutoCommit(false);
            this.setSqlParameter();
            this.cst.execute();
            conn.commit();
            this.getOutputResult();
        } catch (Exception e) {
            this.setCode(999);
            this.setMessage(e.getMessage());
            this.logger.error(String.format("[%s] transId: %s, channel: %s", Thread.currentThread().getName(),
                    this.transId, this.channel), e);
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    this.logger.error(String.format("[%s] transId: %s, channel: %s", Thread.currentThread().getName(),
                            this.transId, this.channel), ex);
                }
            }
            throw e;
        } finally {
            if (this.cst != null) {
                this.closeItem(this.cst);
            }
        }
        if (this.cst != null) {
            this.closeItem(this.cst);
        }
    }

    protected abstract void setSqlCommand() throws Exception;

    protected abstract void setSqlParameter() throws Exception;

    protected abstract void getOutputResult() throws Exception;

    public void setProc(final String procName, final int numberParameter) {
        this.procName = procName;
        this.numberParameter = numberParameter;
    }

    public void setDate(final Date objDate) throws SQLException {
        if (objDate != null) {
            this.cst.setDate(this.idx++, objDate);
        } else {
            this.cst.setNull(this.idx++, 91);
        }
    }

    public void setString(final String objString) throws SQLException {
        if (objString != null) {
            this.cst.setString(this.idx++, objString);
        } else {
            this.cst.setNull(this.idx++, 12);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.getClass().getName()) + " [transId=" + this.transId
                + ", channel=" + this.channel + ", sqlCommand="
                + this.sqlCommand + ", code=" + this.code + ", message=" + this.message + "]";
    }
}
