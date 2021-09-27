// 
// Decompiled by Procyon v0.5.36
// 

package vn.vnpt.cms.api.kernel.db.entities;

public class PagingEntity
{
    private int pageIdx;
    private int pageSize;
    private int totalRecord;
    private int totalPage;
    private int beginIdx;
    private int endIdx;

    public PagingEntity(int pageIdx, int pageSize, int totalRecord, int totalPage, int beginIdx, int endIdx) {
        this.pageIdx = pageIdx;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        this.totalPage = totalPage;
        this.beginIdx = beginIdx;
        this.endIdx = endIdx;
    }

    public int getPageIdx() {
        return pageIdx;
    }

    public void setPageIdx(int pageIdx) {
        this.pageIdx = pageIdx;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getBeginIdx() {
        return beginIdx;
    }

    public void setBeginIdx(int beginIdx) {
        this.beginIdx = beginIdx;
    }

    public int getEndIdx() {
        return endIdx;
    }

    public void setEndIdx(int endIdx) {
        this.endIdx = endIdx;
    }

    @Override
    public String toString() {
        return "PagingEntity [page_idx=" + this.pageIdx + ", page_size="
                + this.pageSize + ", total_record=" + this.totalRecord
                + ", total_page=" + this.totalPage + ", begin_idx="
                + this.beginIdx + ", end_idx=" + this.endIdx + "]";
    }
}
