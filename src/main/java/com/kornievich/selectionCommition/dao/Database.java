package com.kornievich.selectionCommition.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class Database {
 
    private Connection connection;
    private static Database instance;
 
    public static Database getInstance() {
        if (null == instance) {
            instance = new Database();
        }
        return instance;
    }
 
    public Connection getConnection() throws SQLException {
        if (null == connection) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/selection_commition", "root", "admin");
        }
        return connection;
    }
}