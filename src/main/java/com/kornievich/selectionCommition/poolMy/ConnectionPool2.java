package com.kornievich.selectionCommition.poolMy;

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

public class ConnectionPool2 {
    private static ConnectionPool2 instance;

    public static synchronized ConnectionPool2 getInstance() {
        if (instance == null) {
            instance = new ConnectionPool2();
        }
        return instance;
    }
    public ConnectionPool2(){};
    private BlockingQueue<Connection> pool = new ArrayBlockingQueue<Connection>(15);
    private final AtomicInteger connCount = new AtomicInteger();

    public Connection getConnection() throws InterruptedException, SQLException, ConnectionUnavailException {
        Connection conn = pool.poll(1, TimeUnit.SECONDS);
        if (conn == null) {
            synchronized (connCount) {
                if (connCount.get() < 15) {
                    conn = newConnection();
                    pool.offer(conn);
                    connCount.incrementAndGet();
                }
            }
        }
        else  {
            System.out.println("connection not NULL");
            return  newConnection();
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
