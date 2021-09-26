package vn.vnpt.cms.api.cmd;

import vn.vnpt.cms.api.kernel.db.cmd.DbCallableCmd;
import vn.vnpt.cms.api.listener.entities.CategoryFieldInfo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DbGetNumberColumnCmd extends DbCallableCmd {
    private final long categoryId;
    private List<CategoryFieldInfo> categoryFieldInfos;
    private String tblName;
    private int createdHierarchy;

    public DbGetNumberColumnCmd(String transId, String channel, long categoryId) {
        super(transId, channel);
        this.categoryId = categoryId;
    }

    protected void setSqlCommand() throws Exception {
        this.setProc("get_column_number_from_catalog_id", 5);
    }

    protected void setSqlParameter() throws Exception {
        this.cst.registerOutParameter(this.idx++, 4);
        this.cst.registerOutParameter(this.idx++, 12);
        this.cst.setLong(this.idx++, this.categoryId);
        this.cst.registerOutParameter(this.idx++, 12);
        this.cst.registerOutParameter(this.idx++, 4);
    }

    protected void getOutputResult() throws Exception {
        this.code = this.cst.getInt(1);
        this.message = this.cst.getString(2);
        this.tblName = this.cst.getString(4);
        this.createdHierarchy = this.cst.getInt(5);
        if (this.code == 0) {
            ResultSet rs = this.cst.getResultSet();
            if (rs != null) {
                this.categoryFieldInfos = new ArrayList<>();

                try {
                    while (rs.next()) {
                        CategoryFieldInfo categoryFieldInfo = new CategoryFieldInfo();
                        categoryFieldInfo.setEntryId(rs.getLong("entryId"));
                        categoryFieldInfo.setCode(rs.getString("code_"));
                        categoryFieldInfo.setName(rs.getString("name"));
                        categoryFieldInfo.setDataType(rs.getString("dataType"));
                        categoryFieldInfo.setFormat(rs.getString("format"));
                        categoryFieldInfo.setDefaultValue(rs.getString("defaultValue"));
                        categoryFieldInfo.setNotNull(rs.getBoolean("notNull"));
                        this.categoryFieldInfos.add(categoryFieldInfo);
                    }
                } finally {
                    rs.close();
                }
            }

        }
    }

    public List<CategoryFieldInfo> getCategoryFieldInfoList() {
        return this.categoryFieldInfos;
    }

    public String getTblName() {
        return this.tblName;
    }

    public int getIsHierarchy() {
        return this.createdHierarchy;
    }
}
