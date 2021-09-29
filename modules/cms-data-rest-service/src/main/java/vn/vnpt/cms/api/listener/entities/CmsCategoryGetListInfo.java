package vn.vnpt.cms.api.listener.entities;

import java.util.List;

public class CmsCategoryGetListInfo {
    private List<CmsCatalogInfo> categoryInfos;

    public CmsCategoryGetListInfo(List<CmsCatalogInfo> categoryInfos) {
        this.categoryInfos = categoryInfos;
    }

    public List<CmsCatalogInfo> getCategoryInfos() {
        return this.categoryInfos;
    }

    public void setCategoryInfos(List<CmsCatalogInfo> categoryInfos) {
        this.categoryInfos = categoryInfos;
    }
}
