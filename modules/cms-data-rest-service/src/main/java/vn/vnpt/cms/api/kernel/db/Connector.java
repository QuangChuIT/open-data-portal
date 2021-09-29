// 
// Decompiled by Procyon v0.5.36
// 

package vn.vnpt.cms.api.kernel.db;

import java.sql.SQLException;
import java.sql.Connection;

public interface Connector
{
    Connection getConn() throws SQLException;
}
