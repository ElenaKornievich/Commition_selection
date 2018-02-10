package com.kornievich.selectionCommition.dao.impl;


import com.kornievich.selectionCommition.command.Roles;
import com.kornievich.selectionCommition.dao.IUserDAO;
import com.kornievich.selectionCommition.entity.User;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.pool.impl.ConnectionPool;

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

    public boolean changeUserRole(User user, String role) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement = cn.prepareStatement(CHANGE_ROLE);
            preparedStatement.setString(1, role);
            preparedStatement.setInt(2, user.getId());
            return true;
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while changing user role in a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    public ArrayList<User> readAllUsers() throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        ArrayList<User> users = new ArrayList<>();
        try {
            Statement statement = cn.createStatement();
            ResultSet resultSet = statement.executeQuery(READ_USERS);
            while (resultSet.next()) {
                //System.out.println(resultSet.getString(4));
                User user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), Roles.valueOf(resultSet.getString(4).toUpperCase()));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while reading users from a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    private User initUser(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            User user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), Roles.valueOf(resultSet.getString(4).toUpperCase()));
            return user;
        }
        return null;
    }

    public User findUserById(int id) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement = cn.prepareStatement(FINE_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return initUser(resultSet);
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while finding user with such id", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    public User findUserByLogin(String login) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement = cn.prepareStatement(FIND_USER_BY_LOGIN);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            return initUser(resultSet);
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while finding user with such login", e);
        } finally {
            if(cn!=null) {
                ConnectionPool.getInstance().returnConnection(cn);
            }
        }
    }

    public boolean createUser(String login, String password, String role) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement =
                    cn.prepareStatement(CREATE_USER);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, role);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while creating user from a database", e);
        } finally {
            if (cn != null) {
                ConnectionPool.getInstance().returnConnection(cn);
            }
        }
    }

    public User findUserByLoginAndPassword(String login, String password) throws DAOException {
        User user = null;
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement =
                    cn.prepareStatement(READ_USER);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return initUser(resultSet);
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while finding user with such login and password", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    public void updateUser(User user) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement =
                    cn.prepareStatement(UPDATE_USER);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole().toString());
            preparedStatement.setInt(4, user.getId());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while updating user in a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    public boolean deleteUser(int id) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement =
                    cn.prepareStatement(DELETE_USER);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while deleting user from a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }
}
