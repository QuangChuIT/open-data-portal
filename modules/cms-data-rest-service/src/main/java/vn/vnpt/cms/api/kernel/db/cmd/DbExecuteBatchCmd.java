// 
// Decompiled by Procyon v0.5.36
// 

package vn.vnpt.cms.api.kernel.db.cmd;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class DbExecuteBatchCmd extends DbCallableCmd {
    protected ArrayList<Object> lsObject;
    protected int[] arrResult;

    public DbExecuteBatchCmd(final String transId, final String channel, final ArrayList<Object> lsObject) {
        super(transId, channel);
        this.lsObject = lsObject;
    }

    @Override
    public void invoke(final Connection conn) throws Exception {
        if (this.lsObject == null || this.lsObject.isEmpty()) {
            this.logger.info(String.format("[%s] transId: %s, channel: %s, LIST is null or empty, return",
                    Thread.currentThread().getId(), this.transId, this.channel));
            return;
        }
        this.logger.info(String.format("[%s] transId: %s, channel: %s, Execute batch, sqlCommand: %s, lsSyncResponse size: %s",
                Thread.currentThread().getId(), this.transId, this.channel, this.sqlCommand, this.lsObject.size()));
        try {
            this.setSqlCommand();
            String params = "?";
            if (this.numberParameter > 1) {
                for (int i = 1; i < this.numberParameter; ++i) {
                    params = String.valueOf(params) + ",?";
                }
            }
            this.sqlCommand = "{call " + this.procName + "(" + params + ")}";
            this.logger.debug(String.format("[%s] transId: %s, channel: %s, sqlCommand: %s",
                    Thread.currentThread().getId(), this.transId, this.channel, this.sqlCommand.toUpperCase()));
            this.cst = conn.prepareCall(this.sqlCommand);
            conn.setAutoCommit(false);
            for (final Object obj : this.lsObject) {
                if (obj != null) {
                    this.idx = 1;
                    this.setSqlParameter(obj);
                    this.cst.addBatch();
                } else {
                    this.logger.error(String.format("[%s] transId: %s, channel: %s, sqlCommand: %s, ERROR obj == null, can not add batch",
                            Thread.currentThread().getId(), this.transId, this.channel, this.sqlCommand.toUpperCase()));
                }
            }
            this.arrResult = this.cst.executeBatch();
            this.setCode(0);
            this.setMessage("SUCCESS");
            this.checkUpdateCounts();
            conn.commit();
            this.getOutputResult();
        } catch (Exception e) {
            this.logger.error(String.format("[%s] transId: %s, channel: %s, sqlCommand: %s, Exception when executeBatch into database, arrResult: %s",
                    Thread.currentThread().getId(), this.transId, this.channel, this.sqlCommand.toUpperCase(), (this.arrResult == null) ? "" :
                            Arrays.toString(this.arrResult)), (Throwable) e);
            this.setCode(999);
            this.setMessage(e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e2) {
                    this.logger.error(String.format("[%s] transId: %s, channel: %s, sqlCommand: %s, Exception when rollback into database",
                            Thread.currentThread().getId(), this.transId, this.channel, this.sqlCommand.toUpperCase()), e2);
                }
            }
            return;
        } finally {
            this.closeItem(this.cst);
        }
        this.closeItem(this.cst);
    }

    public void checkUpdateCounts() {
        for (int i = 0; i < this.arrResult.length; ++i) {
            if (this.arrResult[i] >= 0) {
                this.logger.debug(String.format("[%s] transId: %s, channel: %s, Batch at index: %s SUCCESS, execute result value: %s",
                        Thread.currentThread().getId(), this.transId, this.channel, i, this.arrResult[i]));
            } else if (this.arrResult[i] == -2) {
                this.logger.debug(String.format("[%s] transId: %s, channel: %s, Batch at index: %s SUCCESS_NO_INFO, execute result value: %s",
                        Thread.currentThread().getId(), this.transId, this.channel, i, this.arrResult[i]));
            } else if (this.arrResult[i] == -3) {
                this.logger.debug(String.format("[%s] transId: %s, channel: %s, Batch at index: %s EXECUTE_FAILED, execute result value: %s",
                        Thread.currentThread().getId(), this.transId, this.channel, i, this.arrResult[i]));
                this.setCode(999);
                this.setMessage(String.format("%d EXECUTE_FAILED", this.arrResult[i]));
                return;
            }
        }
    }

    protected abstract void setSqlParameter(final Object p0) throws Exception;
}
