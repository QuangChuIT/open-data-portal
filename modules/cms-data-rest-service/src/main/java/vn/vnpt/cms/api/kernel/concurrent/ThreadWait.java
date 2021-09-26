// 
// Decompiled by Procyon v0.5.36
// 

package vn.vnpt.cms.api.kernel.concurrent;


import vn.vnpt.cms.api.kernel.textbase.StringGenerator;
import vn.vnpt.cms.api.kernel.textbase.TimeUtils;

public abstract class ThreadWait extends ThreadBase {
    protected Object objSync;
    protected String taskName;
    protected long waitTime;
    protected String transid;

    public ThreadWait() {
        this.objSync = new Object();
    }

    public ThreadWait(final boolean isRun) {
        super(isRun);
        this.objSync = new Object();
    }

    public ThreadWait(final boolean isRun, final String name, final String taskName, final long waitTime) {
        super(isRun, name);
        this.objSync = new Object();
        this.taskName = taskName;
        this.waitTime = waitTime;
    }

    public ThreadWait(final boolean isRun, final String name, final int priority, final String taskName, final long waitTime) {
        super(isRun, name, priority);
        this.objSync = new Object();
        this.taskName = taskName;
        this.waitTime = waitTime;
    }

    public void taskWait(final long timeout) {
        synchronized (this.objSync) {
            try {
                this.objSync.wait(timeout);
            } catch (Exception e) {
                this.logger.error("[" + currentThread().getId() + "] " + String.format("Exception: %s", e.getMessage()), e);
            }
        }
        // monitorexit(this.objSync)
    }

    @Override
    public void finish() {
        this.setRun(false);
        synchronized (this.objSync) {
            this.objSync.notifyAll();
        }
        // monitorexit(this.objSync)
    }

    @Override
    public void run() {
        while (this.isRun && this.isRun) {
            this.transid = StringGenerator.randomCharacters(10);
            this.logger.debug("------------------------------------------------");
            this.logger.debug(String.format("[%s] trans_id: %s, BEGIN %s ...", currentThread().getId(), this.transid, this.taskName));
            final long startTime = System.currentTimeMillis();
            try {
                this.action();
            } catch (Exception e) {
                this.logger.error("", e);
                continue;
            } finally {
                final long endTime = System.currentTimeMillis();
                this.logger.info(String.format("[%s] trans_id: %s, END %s, times: %s", currentThread().getId(), this.transid, this.taskName, TimeUtils.getDurations(endTime, startTime)));
                this.taskWait(this.waitTime);
            }
            final long endTime = System.currentTimeMillis();
            this.logger.info(String.format("[%s] trans_id: %s, END %s, times: %s", currentThread().getId(), this.transid, this.taskName, TimeUtils.getDurations(endTime, startTime)));
            this.taskWait(this.waitTime);
        }
        this.logger.info(String.format("%s IS STOP", this.getName()));
    }

    protected abstract void action();
}
