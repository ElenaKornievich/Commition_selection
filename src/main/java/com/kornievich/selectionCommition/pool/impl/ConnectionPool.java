package com.kornievich.selectionCommition.pool.impl;


import com.kornievich.selectionCommition.pool.ConnectionPoolException;
import com.kornievich.selectionCommition.pool.constant.DBConst;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ConnectionPool {
    static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

    private static Lock lock = new ReentrantLock();

    private BlockingQueue<Connection> availableConnectionsQueue;
    private BlockingQueue<Connection> usedConnectionsQueue;

    private String url;
    private String user;
    private String password;
    private String locationOfDriver;
    private int connectionAmount;


    private static ConnectionPool instance;
    private static AtomicBoolean instanceCreated = new AtomicBoolean(false);


    public static ConnectionPool getInstance() {
        LOGGER.info("The getInstance() method is called");

        if (!instanceCreated.get()) {
            lock.lock();
            try {
                if (instance == null) {
                    instance = new ConnectionPool();
                    instanceCreated.getAndSet(true);
                }
            } finally {
                lock.unlock();
            }

        }
        return instance;
    }

    private ConnectionPool() {

        try {
            ResourceBundle bundle = ResourceBundle.getBundle(DBConst.BUNDLE);
            this.url = bundle.getString(DBConst.URL);
            this.user = bundle.getString(DBConst.USER);
            this.password = bundle.getString(DBConst.PASSWORD);
            this.locationOfDriver = bundle.getString(DBConst.DRIVER_LOCATION);
            this.connectionAmount = 5;
            this.availableConnectionsQueue = new ArrayBlockingQueue<>(connectionAmount);
            this.usedConnectionsQueue = new ArrayBlockingQueue<>(connectionAmount);
            initPool();
        } catch (NumberFormatException e) {
            this.connectionAmount = DBConst.DEFAULT_AMOUNT;
        } catch (MissingResourceException e) {
            //logger.fatal("JDBC: Can't find resource bundle ", e);
            throw new RuntimeException("JDBC: Can't find resource bundle", e);
        } catch (ConnectionPoolException e) {
            throw new RuntimeException("JDBC: Incorrect initialization of the class");
        }
    }

    @PostConstruct
    private void initPool() throws ConnectionPoolException {
       LOGGER.info("Creating pool pool");
        try {
            Class.forName(locationOfDriver);
            Locale.setDefault(Locale.ENGLISH);
            for (int i = 0; i < connectionAmount; i++) {
                Connection connection = DriverManager.getConnection(url, user, password);
                availableConnectionsQueue.put(connection);
               LOGGER.info("Connection " + i + " is created and put into the queue.");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("JDBC: Can't find driver class ", e);
        } catch (SQLException | InterruptedException e) {
         LOGGER.error("SQLException or InterruptedException occurred" +
                   "while initializing pool pool");
        }
    }

    public Connection takeConnection() {
        Connection connection = null;
        try {
            connection = availableConnectionsQueue.take();
            usedConnectionsQueue.put(connection);
        } catch (InterruptedException e) {
          LOGGER.error("Interrupted exception occurred while taking connection from the pool ", e);
        }
     LOGGER.info("Connection is taken.");
        return connection;
    }


    public void returnConnection(Connection connection) {
        try {
          LOGGER.info("Trying to return connection to the connection pool...");
            availableConnectionsQueue.put(connection);
            usedConnectionsQueue.remove(connection);
          LOGGER.info("Connection is successfully returned.");
        } catch (InterruptedException e) {
          LOGGER.error("InterruptedException occurred while returning a connection");
        }

    }


    public void destroyPool() throws ConnectionPoolException {
      LOGGER.info("Destroying connection pool.");
        try {
            for (int i = 0; i < connectionAmount; i++) {
                Connection connection = ConnectionPool.getInstance().takeConnection();
                connection.close();
             LOGGER.info("Connection " + i + " is destroyed.");
            }
        } catch (SQLException e) {
            LOGGER.warn("Can't destroy connection pool.");
            throw new ConnectionPoolException("Can't destroy connection pool.", e);
        }
    }
}



