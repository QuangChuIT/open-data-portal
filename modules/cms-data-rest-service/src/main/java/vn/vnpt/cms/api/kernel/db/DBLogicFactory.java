// 
// Decompiled by Procyon v0.5.36
// 

package vn.vnpt.cms.api.kernel.db;

import vn.vnpt.cms.api.kernel.db.spi.DBLogicImpl;

import java.util.concurrent.ExecutorService;

public class DBLogicFactory {

    public DBLogic createInstance(final ExecutorService executor, final Connector connector) throws Exception {
        return new DBLogicImpl(executor, connector);
    }
}
