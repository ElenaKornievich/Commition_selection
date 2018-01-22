package com.kornievich.selectionCommition.entity;

import com.kornievich.selectionCommition.dao.UserDAO;

import java.sql.SQLException;

public class User {
    private String login;
    private String password;
    private Enum role;

    public User( String login, String password, Enum role) {

        this.login = login;
        this.password = password;
        this.role = role;
    }
    public void create() throws SQLException, ClassNotFoundException {
        UserDAO userDAO =new UserDAO();
        userDAO.create(login, password);
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Enum getRole() {
        return role;
    }

    public void setRole(Enum role) {
        this.role = role;
    }
}
