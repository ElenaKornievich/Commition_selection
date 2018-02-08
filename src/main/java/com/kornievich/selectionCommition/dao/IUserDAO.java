package com.kornievich.selectionCommition.dao;

import com.kornievich.selectionCommition.command.Roles;
import com.kornievich.selectionCommition.entity.User;
import com.kornievich.selectionCommition.exception.ConnectionUnavailException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public interface IUserDAO {

    public boolean changeRole(User user, String role);
    public ArrayList<User> readUsers();
    public User findUserById(int id) throws InterruptedException, ConnectionUnavailException, SQLException;
    public User findUserByLogin(String login) throws InterruptedException, ConnectionUnavailException, SQLException;
    public User create(String login, String password, String role) throws SQLException, ClassNotFoundException;
    public User read(String login, String password);
    public void update(User user);
    public boolean delete(int id);

}