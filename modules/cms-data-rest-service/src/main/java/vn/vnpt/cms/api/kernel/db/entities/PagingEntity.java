// 
// Decompiled by Procyon v0.5.36
// 

package vn.vnpt.cms.api.kernel.db.entities;

public class PagingEntity
{
    private int page_idx;
    private int page_size;
    private int total_record;
    private int total_page;
    private int begin_idx;
    private int end_idx;
    
    public PagingEntity(final int page_idx, final int page_size, final int total_record, final int total_page, final int begin_idx, final int end_idx) {
        this.page_idx = page_idx;
        this.page_size = page_size;
        this.total_record = total_record;
        this.total_page = total_page;
        this.begin_idx = begin_idx;
        this.end_idx = end_idx;
    }
    
    public int getPage_idx() {
        return this.page_idx;
    }
    
    public void setPage_idx(final int page_idx) {
        this.page_idx = page_idx;
    }
    
    public int getPage_size() {
        return this.page_size;
    }
    
    public void setPage_size(final int page_size) {
        this.page_size = page_size;
    }
    
    public int getTotal_record() {
        return this.total_record;
    }
    
    public void setTotal_record(final int total_record) {
        this.total_record = total_record;
    }
    
    public int getTotal_page() {
        return this.total_page;
    }
    
    public void setTotal_page(final int total_page) {
        this.total_page = total_page;
    }
    
    public int getBegin_idx() {
        return this.begin_idx;
    }
    
    public void setBegin_idx(final int begin_idx) {
        this.begin_idx = begin_idx;
    }
    
    public int getEnd_idx() {
        return this.end_idx;
    }
    
    public void setEnd_idx(final int end_idx) {
        this.end_idx = end_idx;
    }
    
    @Override
    public String toString() {
        return "PagingEntity [page_idx=" + this.page_idx + ", page_size="
                + this.page_size + ", total_record=" + this.total_record
                + ", total_page=" + this.total_page + ", begin_idx="
                + this.begin_idx + ", end_idx=" + this.end_idx + "]";
    }
}
