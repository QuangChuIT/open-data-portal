// 
// Decompiled by Procyon v0.5.36
// 

package vn.vnpt.cms.api.kernel.db.cmd;


import vn.vnpt.cms.api.kernel.db.entities.PagingEntity;

public abstract class DbPagingCmd extends DbCallableCmd
{
    protected final int pageIdx;
    protected final int pageSize;
    protected int totalRecord;
    protected int totalPage;
    protected int beginIdx;
    protected int endIdx;
    protected PagingEntity pageInfo;
    
    public DbPagingCmd(final String transId, final String channel) {
        super(transId, channel);
        this.pageInfo = null;
        this.pageIdx = 1;
        this.pageSize = 10;
    }
    
    public DbPagingCmd(final String transId, final String channel, final int pageIdx, final int pageSize) {
        super(transId, channel);
        this.pageInfo = null;
        this.pageIdx = pageIdx;
        this.pageSize = pageSize;
    }
    
    public PagingEntity getPageInfo() {
        return this.pageInfo;
    }
    
    @Override
    public String toString() {
        return this.getClass().getName() + " [transId=" + this.transId +
                ", channel=" + this.channel + ", sqlCommand=" + this.sqlCommand +
                ", code=" + this.code + ", message=" + this.message + "]";
    }
}
