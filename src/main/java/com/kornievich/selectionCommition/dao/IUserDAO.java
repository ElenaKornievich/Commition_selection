package com.kornievich.selectionCommition.dao;

import com.kornievich.selectionCommition.entity.User;

import java.util.ArrayList;
import java.util.HashMap;

public interface IUserDAO {
    void addUser(User user);
    User findUser(String userLogin);
    User findUserById(long userId);
    void updateUserInfo(User user);
    void deleteProfilePicture(long userId, String defaultImage);
    void assignRoleToUser(long userId, String role);
    ArrayList<HashMap<User, ArrayList<Integer>>> showUserTable();

}