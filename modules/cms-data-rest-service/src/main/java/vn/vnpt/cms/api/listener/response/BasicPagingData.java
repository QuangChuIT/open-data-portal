package vn.vnpt.cms.api.listener.response;

import vn.vnpt.cms.api.kernel.db.entities.PagingEntity;

public class BasicPagingData {
    protected PagingEntity page_info;
    protected Object items;

    public BasicPagingData(PagingEntity page_info, Object items) {
        this.page_info = page_info;
        this.items = items;
    }

    public PagingEntity getPage_info() {
        return this.page_info;
    }

    public void setPage_info(PagingEntity page_info) {
        this.page_info = page_info;
    }

    public Object getItems() {
        return this.items;
    }

    public void setItems(Object items) {
        this.items = items;
    }

    public String toString() {
        return "BasePagingData [page_info=" + this.page_info + ", items=" + this.items + "]";
    }
}
