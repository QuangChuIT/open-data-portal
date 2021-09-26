package vn.vnpt.cms.api.listener.request;

import vn.vnpt.cms.api.listener.entities.CmsColumnInfo;

import java.util.List;

public class CmsCategoryCreateReq extends BaseReq {
    private int categoryId;
    private String title;
    private String tableName;
    private int catType;
    private List<CmsColumnInfo> lstColumns;
    private String version;
    private boolean visibility;
    private String description;

    public CmsCategoryCreateReq() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getCatType() {
        return catType;
    }

    public void setCatType(int catType) {
        this.catType = catType;
    }

    public List<CmsColumnInfo> getLstColumns() {
        return lstColumns;
    }

    public void setLstColumns(List<CmsColumnInfo> lstColumns) {
        this.lstColumns = lstColumns;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
