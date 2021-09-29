package vn.vnpt.cms.api.kernel.db;

import vn.vnpt.cms.api.kernel.concurrent.DirectExecutorService;

public class DbModule {
    protected DBLogic dbLogic;
    protected DBConnector dbConnector;

    public DbModule() {
    }

    public void startUp() throws Exception {
        this.shutdown();
        this.dbConnector = new DBConnector();
        (this.dbLogic = new DBLogicFactory().createInstance(new DirectExecutorService(), this.dbConnector)).init();
    }

    public void shutdown() {
        if (this.dbLogic != null) {
            this.dbLogic.exit();
            this.dbLogic = null;
        }
    }

    public DBLogic getDbCtrl() {
        if (this.dbLogic == null) {
            throw new RuntimeException("Not Initialize");
        }
        return this.dbLogic;
    }
}
