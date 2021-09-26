// 
// Decompiled by Procyon v0.5.36
// 

package vn.vnpt.cms.api.kernel.concurrent;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class ThreadBase extends Thread {
    protected Log logger;
    protected boolean isRun;

    public ThreadBase() {
        this.logger = LogFactoryUtil.getLog(this.getClass());
        this.isRun = true;
    }

    public ThreadBase(final boolean isRun) {
        this.logger = LogFactoryUtil.getLog(this.getClass());
        this.isRun = true;
        this.isRun = isRun;
    }

    public ThreadBase(final boolean isRun, final String name) {
        this.logger = LogFactoryUtil.getLog(this.getClass());
        this.isRun = true;
        this.isRun = isRun;
        this.setName(name);
    }

    public ThreadBase(final boolean isRun, final String name, final int priority) {
        this.logger = LogFactoryUtil.getLog(this.getClass());
        this.isRun = true;
        this.isRun = isRun;
        this.setName(name);
        this.setPriority(priority);
    }

    public void setRun(final boolean isRun) {
        this.isRun = isRun;
    }

    public void finish() {
        this.setRun(false);
    }
}
