package com.kornievich.selectionCommition.pool;

import com.kornievich.selectionCommition.exception.ConnectionUnavailException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPool {
    private static ConnectionPool instance;

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }
    private BlockingQueue<Connection> pool = new ArrayBlockingQueue<Connection>(10);
    private AtomicInteger connCount = new AtomicInteger();

    public Connection getConnection() throws InterruptedException, SQLException, ConnectionUnavailException {
        Connection conn = pool.poll(1, TimeUnit.SECONDS);
        if (conn == null) {
            synchronized (connCount) {
                if (connCount.get() < 10) {
                    conn = newConnection();
                    pool.offer(conn);
                    connCount.incrementAndGet();
                }
            }
        }
            if (conn == null) {
                throw new ConnectionUnavailException();
            } else {
                return conn;
            }

    }
    private Connection newConnection() throws SQLException {
        DriverManager.registerDriver(new Driver());
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");
        //DriverManager.registerDriver(new Driver());

        return (Connection) DriverManager.getConnection(url, user, pass);
    }
}
