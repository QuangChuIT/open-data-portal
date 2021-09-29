package vn.vnpt.cms.api.cmd;

import vn.vnpt.cms.api.kernel.db.cmd.DbCallableCmd;
import vn.vnpt.cms.api.listener.entities.CmsCatalogInfo;
import vn.vnpt.cms.api.listener.entities.Column;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DbCmsCatalogGetDetailColumnCmd extends DbCallableCmd {
    private final long catalogId;
    private final CmsCatalogInfo cateInfo = new CmsCatalogInfo();
    private final List<Column> lsColumn = new ArrayList<>();

    public DbCmsCatalogGetDetailColumnCmd(String transId, String channel, long catalogId) {
        super(transId, channel);
        this.catalogId = catalogId;
    }

    protected void getOutputResult() throws Exception {
        this.code = this.cst.getInt(1);
        this.message = this.cst.getString(2);

        try (ResultSet rsCate = this.cst.getResultSet()) {
            if (rsCate != null && rsCate.next()) {
                this.cateInfo.setCatalogId(rsCate.getLong("catalogId"));
                this.cateInfo.setTitle(rsCate.getString("title"));
                this.cateInfo.setTableName(rsCate.getString("tableName"));
                this.cateInfo.setCatType(rsCate.getInt("catType"));
                this.cateInfo.setStatus(rsCate.getInt("status"));
            }
        }

        if (this.cst.getMoreResults()) {
            try (ResultSet rsColumnInfos = this.cst.getResultSet()) {
                if (rsColumnInfos != null) {
                    while (rsColumnInfos.next()) {
                        long entryId = rsColumnInfos.getLong("entryId");
                        long catalogId = rsColumnInfos.getInt("catalogId");
                        String name = rsColumnInfos.getString("name");
                        String code = rsColumnInfos.getString("code_");
                        String dataType = rsColumnInfos.getString("dataType");
                        String format = rsColumnInfos.getString("format");
                        String defaultValue = rsColumnInfos.getString("defaultValue");
                        boolean notNull = rsColumnInfos.getBoolean("notNull");
                        boolean hiddenStatus = rsColumnInfos.getBoolean("hidden_status");
                        boolean isSearch = rsColumnInfos.getBoolean("isSearch");
                        Column obj = new Column();
                        obj.setEntryId(entryId);
                        obj.setName(name);
                        obj.setCode(code);
                        obj.setCatalogId(catalogId);
                        obj.setDataType(dataType);
                        obj.setFormat(format);
                        obj.setDefaultValue(defaultValue);
                        obj.setNotNull(notNull);
                        obj.setHiddenStatus(hiddenStatus);
                        obj.setSearch(isSearch);
                        this.lsColumn.add(obj);
                    }
                }
            }
        }

    }

    protected void setSqlCommand() throws Exception {
        this.setProc("catalog_get_detail_column", 3);
    }

    protected void setSqlParameter() throws Exception {
        this.cst.registerOutParameter(this.idx++, 4);
        this.cst.registerOutParameter(this.idx++, 12);
        this.cst.setLong(this.idx++, this.catalogId);
    }

    public CmsCatalogInfo getCateInfo() {
        return this.cateInfo;
    }

    public List<Column> getLsColumn() {
        return this.lsColumn;
    }
}
