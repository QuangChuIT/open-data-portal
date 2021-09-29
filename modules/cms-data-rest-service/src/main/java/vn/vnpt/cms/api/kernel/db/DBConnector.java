package vn.vnpt.cms.api.kernel.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector implements Connector {

    public DBConnector() {
        this.setupDataSource();
    }

    @Override
    public synchronized Connection getConn() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DbConfiguration.CONNECTION_URL, DbConfiguration.USER_NAME, DbConfiguration.PASSWORD);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

    public void setupDataSource() {

    }

    public void shutdownDataSource() {
    }

    @Override
    protected void finalize() throws Throwable {
        this.shutdownDataSource();
        super.finalize();
    }
}
