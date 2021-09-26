package vn.vnpt.cms.api.cmd;


import vn.vnpt.cms.api.kernel.db.cmd.DbCallableCmd;

public class DbCmsCatalogCreateCmd extends DbCallableCmd {
    private final String sql_query;
    private final String tableName;


    public DbCmsCatalogCreateCmd(String transId, String channel, String sql_query,
                                 String tableName) {
        super(transId, channel);
        this.sql_query = sql_query;
        this.tableName = tableName;
    }

    protected void getOutputResult() throws Exception {
        this.code = this.cst.getInt(1);
        this.message = this.cst.getString(2);
    }

    protected void setSqlCommand() throws Exception {
        this.setProc("catalog_create", 4);
    }

    protected void setSqlParameter() throws Exception {
        this.cst.registerOutParameter(this.idx++, 4);
        this.cst.registerOutParameter(this.idx++, 12);
        this.cst.setString(this.idx++, this.sql_query);
        this.cst.setString(this.idx++, this.tableName);
    }
}
