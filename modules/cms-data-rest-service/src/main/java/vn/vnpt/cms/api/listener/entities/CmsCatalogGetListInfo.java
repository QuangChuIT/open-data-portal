package vn.vnpt.cms.api.listener.entities;

import java.util.List;

public class CmsCatalogGetListInfo {
    private List<CmsCatalogInfo> catalogInfos;

    public CmsCatalogGetListInfo(List<CmsCatalogInfo> catalogInfos) {
        this.catalogInfos = catalogInfos;
    }

    public List<CmsCatalogInfo> getCatalogInfos() {
        return catalogInfos;
    }

    public void setCatalogInfos(List<CmsCatalogInfo> catalogInfos) {
        this.catalogInfos = catalogInfos;
    }
}
