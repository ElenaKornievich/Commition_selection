package com.kornievich.selectionCommition.entity;

import java.io.Serializable;

public class User implements Serializable, Cloneable{
    private int id;
    private String login;
    private String password;
    private Enum role;

    public User(int id, String login, String password, Enum role) {
        this.id=id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
