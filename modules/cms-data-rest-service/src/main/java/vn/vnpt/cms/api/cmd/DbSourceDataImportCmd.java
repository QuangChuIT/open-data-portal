package vn.vnpt.cms.api.cmd;

import vn.vnpt.cms.api.kernel.db.cmd.DbCallableCmd;

public class DbSourceDataImportCmd extends DbCallableCmd {
    private final String queryArray;

    public DbSourceDataImportCmd(String transid, String channel, String data) {
        super(transid, channel);
        this.queryArray = data;
    }

    protected void setSqlCommand() throws Exception {
        this.setProc("source_data_import", 3);
    }

    protected void setSqlParameter() throws Exception {
        this.cst.registerOutParameter(this.idx++, 4);
        this.cst.registerOutParameter(this.idx++, 12);
        this.cst.setString(this.idx++, this.queryArray);
    }

    protected void getOutputResult() throws Exception {
        this.code = this.cst.getInt(1);
        this.message = this.cst.getString(2);
    }
}
