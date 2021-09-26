package vn.vnpt.cms.api.listener.entities;

import java.util.List;

public class CmsCategoryGetListInfo {
    private List<CmsCategoryInfo> categoryInfos;

    public CmsCategoryGetListInfo(List<CmsCategoryInfo> categoryInfos) {
        this.categoryInfos = categoryInfos;
    }

    public List<CmsCategoryInfo> getCategoryInfos() {
        return this.categoryInfos;
    }

    public void setCategoryInfos(List<CmsCategoryInfo> categoryInfos) {
        this.categoryInfos = categoryInfos;
    }
}
