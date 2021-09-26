package vn.vnpt.cms.api.listener.entities;

import java.util.List;

public class CategoryGetDetailColumn {
    private CmsCategoryInfo cateInfo;
    private List<Column> lsColumn;

    public CategoryGetDetailColumn(CmsCategoryInfo cateInfo, List<Column> lsColumn) {
        this.cateInfo = cateInfo;
        this.lsColumn = lsColumn;
    }

    public CategoryGetDetailColumn() {
    }

    public CmsCategoryInfo getCateInfo() {
        return this.cateInfo;
    }

    public void setCateInfo(CmsCategoryInfo cateInfo) {
        this.cateInfo = cateInfo;
    }

    public List<Column> getLsColumn() {
        return this.lsColumn;
    }

    public void setLsColumn(List<Column> lsColumn) {
        this.lsColumn = lsColumn;
    }
}
