package vn.vnpt.cms.api.listener.request;

import vn.vnpt.cms.api.listener.entities.CmsCatalogSearch;

import java.util.List;

public class CmsCatalogGetDataReq extends BaseReq{
    private long catalogId;
    private List<CmsCatalogSearch> searchColumns;
    private int pageIndex;
    private int status;
    private String orderBy;

    public CmsCatalogGetDataReq(String channel, String transId) {
        super(channel, transId);
    }

    public CmsCatalogGetDataReq(long catalogId, List<CmsCatalogSearch> searchColumns,
                                int pageIndex, int status, String orderBy) {
        this.catalogId = catalogId;
        this.searchColumns = searchColumns;
        this.pageIndex = pageIndex;
        this.status = status;
        this.orderBy = orderBy;
    }

    public long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(long catalogId) {
        this.catalogId = catalogId;
    }

    public List<CmsCatalogSearch> getSearchColumns() {
        return searchColumns;
    }

    public void setSearchColumns(List<CmsCatalogSearch> searchColumns) {
        this.searchColumns = searchColumns;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
