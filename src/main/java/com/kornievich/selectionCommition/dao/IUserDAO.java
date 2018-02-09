package com.kornievich.selectionCommition.dao;


import com.kornievich.selectionCommition.entity.User;
import com.kornievich.selectionCommition.exception.ConnectionUnavailException;
import com.kornievich.selectionCommition.exception.DAOException;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IUserDAO {

    boolean changeUserRole(User user, String role) throws DAOException;
    ArrayList<User> readAllUsers() throws DAOException;
    User findUserById(int id) throws InterruptedException, ConnectionUnavailException, SQLException, DAOException;
    User findUserByLogin(String login) throws InterruptedException, ConnectionUnavailException, SQLException, DAOException;
    User createUser(String login, String password, String role) throws SQLException, ClassNotFoundException, DAOException;
    User findUserByLoginAndPassword(String login, String password) throws DAOException;
    void updateUser(User user) throws DAOException;
    boolean deleteUser(int id) throws DAOException;

}