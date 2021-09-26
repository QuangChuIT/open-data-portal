// 
// Decompiled by Procyon v0.5.36
// 

package vn.vnpt.cms.api.kernel.db.spi;


import vn.vnpt.cms.api.kernel.db.cmd.DBCommandBase;

public class DBJobTask {

    private final DBCommandBase command;
    private boolean done;
    private Exception cause;

    public DBJobTask(final DBCommandBase command) {
        this.command = command;
    }

    public synchronized DBCommandBase getCommand() {
        return this.command;
    }

    public synchronized boolean isDone() {
        return this.done;
    }

    final synchronized void setDone() {
        this.done = true;
        this.notify();
    }

    final synchronized Throwable getCause() {
        return this.cause;
    }

    final synchronized void setCause(final Exception cause) {
        this.cause = cause;
    }

    public final synchronized void get() throws Exception {
        while (!this.done) {
            this.wait();
        }
        if (this.cause != null) {
            throw this.cause;
        }
    }

    public final synchronized void get(long miliseconds) throws Exception {
        final long due = System.currentTimeMillis() + miliseconds;
        while (System.currentTimeMillis() < due && !this.done) {
            this.wait(due - System.currentTimeMillis());
        }
        if (this.cause != null) {
            throw this.cause;
        }
    }

    @Override
    public String toString() {
        String s = this.getClass().getSimpleName() + ": isDone = " + this.done;
        if (this.cause != null) {
            s = s + ", cause = " + this.cause;
        }
        return s;
    }
}
