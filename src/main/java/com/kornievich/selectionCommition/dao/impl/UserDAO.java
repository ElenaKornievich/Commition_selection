package com.kornievich.selectionCommition.dao.impl;


import com.kornievich.selectionCommition.command.Roles;
import com.kornievich.selectionCommition.dao.IUserDAO;
import com.kornievich.selectionCommition.entity.User;
import com.kornievich.selectionCommition.exception.ConnectionUnavailException;
import com.kornievich.selectionCommition.pool.impl.ConnectionPool;
import com.kornievich.selectionCommition.poolMy.ConnectionPool2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;

public class UserDAO implements IUserDAO {

    private static final String CHANGE_ROLE = "UPDATE selection_commition.users SET " +
            "selection_commition.users.Role=? WHERE UserID=?;";
    private static final String READ_USERS = "SELECT * FROM selection_commition.users";
    private static final String FINE_USER_BY_ID = "SELECT * FROM selection_commition.users WHERE UserID=?";
    private static final String FIND_USER_BY_LOGIN = "SELECT * FROM selection_commition.users WHERE Login=?";
    private static final String CREATE_USER = "INSERT INTO selection_commition.users (Login, Password, Role) VALUES (?, ?, ?)";

    private static final String READ_USER = "SELECT * FROM selection_commition.users WHERE users.Login=? AND users.Password=?";
    private static final String UPDATE_USER = "UPDATE selection_commition.users SET selection_commition.users.Login = ?, " +
            "selection_commition.users.Password = ?, " +
            "selection_commition.users.Role=? WHERE UserID=?;";
    private static final String DELETE_USER = "DELETE FROM selection_commition.users WHERE selection_commition.users.UserID=?";

    public boolean changeRole(User user, String role) {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {

            PreparedStatement preparedStatement = cn.prepareStatement(CHANGE_ROLE);
            preparedStatement.setString(1, role);
            preparedStatement.setInt(2, user.getId());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);

        }
        return false;

    }

    public ArrayList<User> readUsers() {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        ArrayList<User> users = new ArrayList<>();
        try {

            if (cn != null) {
                Statement statement = cn.createStatement();

                ResultSet resultSet = statement.executeQuery(READ_USERS);

                while (resultSet.next()) {
                    //System.out.println(resultSet.getString(4));
                    User user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), Roles.valueOf(resultSet.getString(4).toUpperCase()));
                    users.add(user);
                }
                return users;
            } else System.out.println("Всё плохо, здесь ошибка в коннесшне");

        } catch (SQLException e) {
            System.err.println("DB connection error: " + e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);

        }
        return null;
    }

    private User createUser(ResultSet resultSet) throws SQLException {
     if(resultSet.next()) {

         User user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), Roles.valueOf(resultSet.getString(4).toUpperCase()));
         return user;
     }
        return null;
    }

    public User findUserById(int id) {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            //cn = ConnectionPool2.getInstance().getConnection();

            PreparedStatement preparedStatement = cn.prepareStatement(FINE_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return createUser(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
          /*  if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.err.println("Сonnection close error: " + e);
                }
            }*/

        }
        return null;
    }

    public User findUserByLogin(String login) throws InterruptedException, ConnectionUnavailException, SQLException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        PreparedStatement preparedStatement = cn.prepareStatement(FIND_USER_BY_LOGIN);
        preparedStatement.setString(1, login);
        ResultSet resultSet = preparedStatement.executeQuery();
        ConnectionPool.getInstance().returnConnection(cn);
        if(resultSet!=null){
        return createUser(resultSet);}
        return null;
    }

    public User create(String login, String password, String role) throws SQLException, ClassNotFoundException {
        // DriverManager.registerDriver(DRIVER);
        Connection cn = ConnectionPool.getInstance().takeConnection();
        //Statement st = null;
        try {
            // cn = ConnectionPool2.getInstance().getConnection();
            if (cn != null) {
                PreparedStatement preparedStatement =
                        cn.prepareStatement(CREATE_USER);
                preparedStatement.setString(1, login);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, role);
                preparedStatement.executeUpdate();
                return findUserByLogin(login);
            } else System.out.println("Всё плохо, здесь ошибка в коннесшне");

        } catch (SQLException e) {
            System.err.println("DB connection error: " + e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ConnectionUnavailException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }

        return null;
    }

    public User read(String login, String password) {
        User user = null;
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            if (cn != null) {
                PreparedStatement preparedStatement =
                        cn.prepareStatement(READ_USER);
                preparedStatement.setString(1, login);
                preparedStatement.setString(2, password);
                ResultSet resultSet = preparedStatement.executeQuery();
                // System.out.println("эт тип резалтсет"+ resultSet.getString(2));
                if (resultSet.next()) {
                    user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), Roles.valueOf(resultSet.getString(4).toUpperCase()));
                } else return null;
            } else System.out.println("Всё плохо 2, ошибка в коннекшне");
        } catch (SQLException e) {
            System.err.println("DB connection error: " + e);
        } finally {

          ConnectionPool.getInstance().returnConnection(cn);
        }
        return user;
    }

    public void update(User user) {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            if (cn != null) {
                PreparedStatement preparedStatement =
                        cn.prepareStatement(UPDATE_USER);
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getRole().toString());
                preparedStatement.setInt(4, user.getId());
                preparedStatement.executeQuery();
            } else System.out.println("Всё плохо 2, ошибка в коннекшне");
        } catch (SQLException e) {
            System.err.println("DB connection error: " + e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);


        }
    }

    public boolean delete(int id) {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {

            if (cn != null) {
                PreparedStatement preparedStatement =
                        cn.prepareStatement(DELETE_USER);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                return true;
            } else System.out.println("Всё плохо 2, ошибка в коннекшне");
        } catch (SQLException e) {
            System.err.println("DB connection error: " + e);
        } finally {

           ConnectionPool.getInstance().returnConnection(cn);
        }
        return false;
    }
}
