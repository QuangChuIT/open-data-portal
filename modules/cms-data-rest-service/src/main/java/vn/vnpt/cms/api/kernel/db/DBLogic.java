// 
// Decompiled by Procyon v0.5.36
// 

package vn.vnpt.cms.api.kernel.db;

import vn.vnpt.cms.api.kernel.db.cmd.DBCommandBase;
import vn.vnpt.cms.api.kernel.db.spi.DBJobTask;

public interface DBLogic {
    void init();

    void exit();

    DBJobTask executeCommand(DBCommandBase dbCommandBase) throws Exception;
}
