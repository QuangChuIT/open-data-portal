package vn.vnpt.cms.api.listener.request;

public class CmsCateInsertDataReq extends BaseReq {
    private int category_id;
    private String lsColumn;
    private String lsData;
    private String tableNameNew;

    public CmsCateInsertDataReq() {
    }

    public int getCategory_id() {
        return this.category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getLsColumn() {
        return this.lsColumn;
    }

    public void setLsColumn(String lsColumn) {
        this.lsColumn = lsColumn;
    }

    public String getLsData() {
        return this.lsData;
    }

    public void setLsData(String lsData) {
        this.lsData = lsData;
    }

    public String getTableNameNew() {
        return this.tableNameNew;
    }

    public void setTableNameNew(String tableNameNew) {
        this.tableNameNew = tableNameNew;
    }
}
