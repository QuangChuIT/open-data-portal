// 
// Decompiled by Procyon v0.5.36
// 

package vn.vnpt.cms.api.kernel.concurrent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

public class DirectExecutorService extends AbstractExecutorService {
    private volatile boolean shutdown;

    public DirectExecutorService() {
        this.shutdown = false;
    }

    @Override
    public void execute(final Runnable r) {
        r.run();
    }

    @Override
    public void shutdown() {
        this.shutdown = true;
    }

    @Override
    public List<Runnable> shutdownNow() {
        this.shutdown = true;
        return Collections.emptyList();
    }

    @Override
    public boolean isShutdown() {
        return this.shutdown;
    }

    @Override
    public boolean isTerminated() {
        return this.isShutdown();
    }

    @Override
    public boolean awaitTermination(final long timeout, final TimeUnit unit) {
        return this.shutdown;
    }
}
