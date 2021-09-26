// 
// Decompiled by Procyon v0.5.36
// 

package vn.vnpt.cms.api.kernel.db.cmd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class DBCommandBase {

    public abstract void invoke(final Connection connection) throws Exception;

    public final void closeItem(final ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public final void closeItem(final CallableStatement callable) {
        try {
            if (callable != null) {
                callable.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public final void closeItem(final Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
