// 
// Decompiled by Procyon v0.5.36
// 

package vn.vnpt.cms.api.kernel.concurrent;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPool {
    private static final Log logger;
    List<WorkerThread> idle;
    private final String name;
    private boolean keepRunning;
    private WorkerThread[] threads;
    final Lock lock;
    final Condition notEmpty;

    static {
        logger = LogFactoryUtil.getLog(ThreadPool.class);
    }

    public ThreadPool(final String name, final int poolSize) {
        this.idle = new LinkedList<>();
        this.lock = new ReentrantLock();
        this.notEmpty = this.lock.newCondition();
        this.name = name;
        this.threads = new WorkerThread[poolSize];
        for (int i = 0; i < poolSize; ++i) {
            this.threads[i] = new WorkerThread(this, String.valueOf(name) + (i + 1));
        }
        this.lock.lock();
        this.notEmpty.signal();
        this.lock.unlock();
    }

    WorkerThread getWorker(final long milisecond) throws InterruptedException, TimeoutException {
        WorkerThread worker = null;
        this.lock.lock();
        try {
            if (this.idle.size() <= 0 && !this.notEmpty.await(milisecond, TimeUnit.MILLISECONDS)) {
                throw new TimeoutException("No Worker Available");
            }
            worker = this.idle.remove(0);
        } catch (InterruptedException e) {
            throw e;
        } finally {
            this.lock.unlock();
        }
        this.lock.unlock();
        return worker;
    }

    void returnWorker(final WorkerThread worker) {
        this.lock.lock();
        try {
            if (!this.idle.contains(worker)) {
                this.idle.add(worker);
                this.notEmpty.signal();
            }
        } catch (Exception ex) {
            return;
        } finally {
            this.lock.unlock();
        }
        this.lock.unlock();
    }

    void removeWorker(final WorkerThread worker) {
        this.lock.lock();
        try {
            this.idle.remove(worker);
        } catch (Exception ex) {
            return;
        } finally {
            this.lock.unlock();
        }
        this.lock.unlock();
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void serviceJob(final Runnable job, final long wait) throws InterruptedException, TimeoutException {
        if (!this.keepRunning) {
            throw new InterruptedException("ThreadPool is not ready");
        }
        final WorkerThread worker = this.getWorker(wait);
        worker.serviceJob(job);
    }

    public final void start() {
        if (!this.keepRunning) {
            this.keepRunning = true;
            WorkerThread[] threads;
            for (int length = (threads = this.threads).length, i = 0; i < length; ++i) {
                final WorkerThread thread = threads[i];
                new Thread(thread).start();
                this.idle.add(thread);
            }
        }
    }

    public final void stop() {
        this.keepRunning = false;
        WorkerThread[] threads;
        for (int length = (threads = this.threads).length, i = 0; i < length; ++i) {
            final WorkerThread thread = threads[i];
            synchronized (thread) {
                thread.notifyAll();
            }
            // monitorexit(thread)
        }
        synchronized (this.idle) {
            this.idle.clear();
        }
        // monitorexit(this.idle)
    }

    class WorkerThread implements Runnable {
        private final String name;
        private ThreadPool pool;
        private Runnable job;

        WorkerThread(final ThreadPool pool, final String name) {
            this.name = name;
            this.pool = pool;
        }

        @Override
        public synchronized void run() {
            if (ThreadPool.logger.isInfoEnabled()) {
                ThreadPool.logger.info((Object) ("WorkerThread.run():" + this.getName() + " is ready"));
            }
            while (ThreadPool.this.keepRunning) {
                try {
                    if (this.job == null) {
                        this.wait();
                    }
                } catch (InterruptedException e2) {
                    Thread.interrupted();
                }
                if (!ThreadPool.this.keepRunning) {
                    return;
                }
                if (this.job == null) {
                    continue;
                }
                try {
                    this.job.run();
                } catch (Exception e) {
                    if (!ThreadPool.logger.isWarnEnabled()) {
                        continue;
                    }
                    ThreadPool.logger.warn((Object) ("WorkerThread.run() Caught '" + e + "'"), (Throwable) e);
                    continue;
                } finally {
                    if (ThreadPool.logger.isDebugEnabled()) {
                        ThreadPool.logger.info((Object) ("WorkerThread.run(): command invoked:" + this.job));
                    }
                    this.job = null;
                    this.pool.returnWorker(this);
                }
                if (ThreadPool.logger.isDebugEnabled()) {
                    ThreadPool.logger.info((Object) ("WorkerThread.run(): command invoked:" + this.job));
                }
                this.job = null;
                this.pool.returnWorker(this);
            }
        }

        synchronized void serviceJob(final Runnable job) {
            this.job = job;
            this.notify();
        }

        public final String getName() {
            return this.name;
        }

        @Override
        public String toString() {
            return this.getName();
        }
    }
}
