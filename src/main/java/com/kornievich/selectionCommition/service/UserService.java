package com.kornievich.selectionCommition.service;

import com.kornievich.selectionCommition.dao.impl.UserDAO;
import com.kornievich.selectionCommition.entity.User;

import java.sql.SQLException;

public class UserService {

   // private static Logger logger = Logger.getLogger(UserService.class);

  //  private IUserDAO dao;
    private static UserService instance = new UserService();
    UserDAO userDAO;
    private UserService() {
       userDAO =new UserDAO();

    }


    public static UserService getInstance() {
        return instance;
    }


    public boolean addUser(String login, String password) {
        try {
            userDAO.create(login, password);
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("ошибка в сервисе");
            return false;
        }
    }
    public User findUser(String login, String password){
        UserDAO userDAO =new UserDAO();
        return userDAO.read(login, password);
    }




}
