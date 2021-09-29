package vn.vnpt.cms.api.kernel.db.spi;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import vn.vnpt.cms.api.kernel.concurrent.DirectExecutorService;
import vn.vnpt.cms.api.kernel.db.Connector;
import vn.vnpt.cms.api.kernel.db.DBLogic;
import vn.vnpt.cms.api.kernel.db.cmd.DBCommandBase;

import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class DBLogicImpl implements DBLogic {
    private final Log logger;
    private final ExecutorService executor;
    private Connector connector;
    private static DBLogicImpl INSTANCE;

    static public DBLogicImpl getInstance() throws Exception {
        if (INSTANCE == null) {
            INSTANCE = new DBLogicImpl();
        }
        return INSTANCE;
    }

    @Override
    public synchronized void init() {
        this.logger.info("Start DBLogic ...");
    }

    @Override
    public synchronized void exit() {
        if (this.executor != null) {
            this.executor.shutdown();
            try {
                this.executor.awaitTermination(10000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException ex) {
                logger.error(ex);
            }
        }
    }

    @Override
    public DBJobTask executeCommand(DBCommandBase command) throws Exception {
        final DBJobTaskImp task = new DBJobTaskImp(command);
        this.executor.execute(task);
        return task;
    }

    public DBLogicImpl() {
        this.logger = LogFactoryUtil.getLog(DBLogicImpl.class);
        this.executor = new DirectExecutorService();
    }

    public DBLogicImpl(final ExecutorService executor, Connector connector) {
        this.logger = LogFactoryUtil.getLog(DBLogicImpl.class);
        this.connector = connector;
        this.executor = executor;
    }

    private class DBJobTaskImp extends DBJobTask implements Runnable {
        @Override
        public void run() {
            Connection connection = null;
            try {
                connection = DataAccess.getConnection();
                this.getCommand().invoke(connection);
            } catch (Exception e) {
                this.setCause(e);
                if (DBLogicImpl.this.logger.isWarnEnabled()) {
                    DBLogicImpl.this.logger.warn(("DBJob.run():Caught '" + e + "'"));
                }
            } finally {
                this.setDone();
                if (DBLogicImpl.this.logger.isDebugEnabled()) {
                    DBLogicImpl.this.logger.debug(("DBJob.run(): command invoked: " + this.getCommand()));
                }
            }
        }

        DBJobTaskImp(final DBCommandBase command) {
            super(command);
        }
    }
}
