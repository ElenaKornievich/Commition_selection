package com.kornievich.selectionCommition.dao;


import com.kornievich.selectionCommition.command.Roles;
import com.kornievich.selectionCommition.entity.User;
import com.kornievich.selectionCommition.exception.ConnectionUnavailException;
import com.kornievich.selectionCommition.pool.ConnectionPool;
import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UserDAO {

    private static final Driver DRIVER;

    static {
        try {
            DRIVER = new Driver();
        } catch (SQLException e) {
            throw new ExceptionInInitializerError(e);
        }
    }


    public static Connection getConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        DriverManager.registerDriver(new Driver());
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");
        //DriverManager.registerDriver(new Driver());

        return DriverManager.getConnection(url, user, pass);
    }

    public ArrayList<User> readUser(){
        Connection cn=null;
        ArrayList<User> users=new ArrayList<>();
        try {

            try {
                cn = ConnectionPool.getInstance().getConnection();
            } catch (InterruptedException | ConnectionUnavailException e) {
                e.printStackTrace();
            }
            if (cn != null) {
                Statement statement=cn.createStatement();

               ResultSet resultSet=statement.executeQuery("SELECT * FROM selection_commition.users");

               while (resultSet.next()){
                   //System.out.println(resultSet.getString(4));
                   User user=new User(resultSet.getString(2), resultSet.getString(3), Roles.valueOf(resultSet.getString(4).toUpperCase()) );
               users.add(user);
               }
               return users;
            } else System.out.println("Всё плохо, здесь ошибка в коннесшне");

        } catch (SQLException e) {
            System.err.println("DB connection error: " + e);
        } finally {

            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.err.println("Сonnection close error: " + e);
                }
            }

        }
        return null;
    }

    public User create(String login, String password) throws SQLException, ClassNotFoundException {
        // DriverManager.registerDriver(DRIVER);
        Connection cn = null;
        //Statement st = null;
        try {

            try {
                cn = ConnectionPool.getInstance().getConnection();
            } catch (InterruptedException | ConnectionUnavailException e) {
                e.printStackTrace();
            }
            if (cn != null) {
                PreparedStatement preparedStatement =
                        cn.prepareStatement("INSERT INTO selection_commition.users (Login, Password, Role) VALUES (?, ?,'entrant')");
                preparedStatement.setString(1, login);
                preparedStatement.setString(2, password);
                preparedStatement.executeUpdate();
            } else System.out.println("Всё плохо, здесь ошибка в коннесшне");

        } catch (SQLException e) {
            System.err.println("DB connection error: " + e);
        } finally {

            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.err.println("Сonnection close error: " + e);
                }
            }

        }
        return new User(login, password, Roles.ENTRANT);
    }

    public User read(String login, String password) {
        User user = null;
        Connection cn = null;
        try {
            try {
                cn = ConnectionPool.getInstance().getConnection();
            } catch (InterruptedException | ConnectionUnavailException e) {
                e.printStackTrace();
            }
            if (cn != null) {
                PreparedStatement preparedStatement =
                        cn.prepareStatement("SELECT * FROM selection_commition.users WHERE users.Login=? AND users.Password=?");
                preparedStatement.setString(1, login);
                preparedStatement.setString(2, password);
                ResultSet resultSet = preparedStatement.executeQuery();
                // System.out.println("эт тип резалтсет"+ resultSet.getString(2));
                if (resultSet.next()) {
                    System.out.println(resultSet.getString(2));

                    user = new User(resultSet.getString(2), resultSet.getString(3), Roles.valueOf(resultSet.getString(4).toUpperCase()));
                } else return null;
            } else System.out.println("Всё плохо 2, ошибка в коннекшне");
        } catch (SQLException e) {
            System.err.println("DB connection error: " + e);
        } finally {

            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.err.println("Сonnection close error: " + e);
                }
            }

        }
        return user;
    }

    public void update(User user) {
        Connection cn = null;
        try {
            try {
                cn = ConnectionPool.getInstance().getConnection();
            } catch (InterruptedException | ConnectionUnavailException e) {
                e.printStackTrace();
            }
            if (cn != null) {
                PreparedStatement preparedStatement =
                        cn.prepareStatement("UPDATE selection_commition.users SET selection_commition.users.Login = ?, " +
                                "selection_commition.users.Password = ?, " +
                                "selection_commition.users.Role=?;");
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getRole().toString());
                preparedStatement.executeQuery();
            } else System.out.println("Всё плохо 2, ошибка в коннекшне");
        } catch (SQLException e) {
            System.err.println("DB connection error: " + e);
        } finally {

            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.err.println("Сonnection close error: " + e);
                }
            }


        }
    }

    public void delete(User user) {
        Connection cn = null;
        try {
            try {
                cn = ConnectionPool.getInstance().getConnection();
            } catch (InterruptedException | ConnectionUnavailException e) {
                e.printStackTrace();
            }
            if (cn != null) {
                PreparedStatement preparedStatement =
                        cn.prepareStatement("DELETE FROM selection_commition.users WHERE selection_commition.users.Login=?");
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.executeQuery();
            } else System.out.println("Всё плохо 2, ошибка в коннекшне");
        } catch (SQLException e) {
            System.err.println("DB connection error: " + e);
        } finally {

            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.err.println("Сonnection close error: " + e);
                }
            }


        }
    }
}
