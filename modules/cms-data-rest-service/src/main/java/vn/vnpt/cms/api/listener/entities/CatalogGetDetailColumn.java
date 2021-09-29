package vn.vnpt.cms.api.listener.entities;

import java.util.List;

public class CatalogGetDetailColumn {
    private CmsCatalogInfo cateInfo;
    private List<Column> lsColumn;

    public CatalogGetDetailColumn(CmsCatalogInfo cateInfo, List<Column> lsColumn) {
        this.cateInfo = cateInfo;
        this.lsColumn = lsColumn;
    }

    public CatalogGetDetailColumn() {
    }

    public CmsCatalogInfo getCateInfo() {
        return this.cateInfo;
    }

    public void setCateInfo(CmsCatalogInfo cateInfo) {
        this.cateInfo = cateInfo;
    }

    public List<Column> getLsColumn() {
        return this.lsColumn;
    }

    public void setLsColumn(List<Column> lsColumn) {
        this.lsColumn = lsColumn;
    }
}
