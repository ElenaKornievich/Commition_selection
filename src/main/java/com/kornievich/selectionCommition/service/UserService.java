package com.kornievich.selectionCommition.service;

import com.kornievich.selectionCommition.dao.impl.UserDAO;
import com.kornievich.selectionCommition.entity.User;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.util.SHA256Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.ArrayList;


public class UserService {
    static final Logger LOGGER = LogManager.getLogger(UserService.class);


    private static UserService instance;
    private UserDAO userDAO;
    private UserService() {
       userDAO =new UserDAO();

    }
    public static UserService getInstance() {
        LOGGER.info("The getInstance() method is called");
        if(instance==null){
            instance = new UserService();
        }
        return instance;
    }



  /*  public User addUser(String login, String password, String pasportSeria,
                           int pasportNumber, String surname, String firstName, String lastName, String dataOfIssue, String identificationNumber,
                           String dataOfBirth, String nationality, String telephoneNumber, String residenceAddress, double scope, boolean goldMedal, String email) throws DAOException {

            if(userDAO.findUserByLogin(login)!=null){
                return null;
            }
            Date date = new Date();
            SimpleDateFormat dateNow = new SimpleDateFormat("yyyy-MM-dd");
            User user=userDAO.createUser(login, SHA256Util.encrypt(password), Roles.ENTRANT.getText());
            Entrant entrant = new Entrant(user.getId(), dateNow.format(date), pasportSeria, pasportNumber, surname, firstName, lastName, dataOfIssue,
                    identificationNumber, dataOfBirth, nationality, telephoneNumber, residenceAddress, scope, goldMedal, email);
            EntrantDAO entrantDAO=new EntrantDAO();
            System.out.println(entrant.toString());
            entrantDAO.createEntrant(entrant);
            return user;
    }
*/
    public User findUser(String login, String password) throws DAOException {
        LOGGER.info("The findUser() method is called with the input data" + login + " " + password);
           User user = userDAO.findUserByLogin(login);
            if(user!=null){
                if (user.getPassword().equals(SHA256Util.encrypt(password))) {
                    return user;
                }
                else {return null;}
            }
            else  { return null;}

    }
    public boolean changeUserRole(User user, String role) throws DAOException {
        LOGGER.info("The changeUserRole() method is called");
        return userDAO.changeUserRole(user, role);
    }
    public ArrayList<User> readAllUsers() throws DAOException {
        LOGGER.info("The readAllUsers() method is called");
        return userDAO.readAllUsers();
    }
    public User findUserById(int id) throws DAOException {
        LOGGER.info("The findUserById() method is called");
        return userDAO.findUserById(id);
    }
    public User findUserByLogin(String login) throws DAOException {
        LOGGER.info("The findUserByLogin() method is called");
        return userDAO.findUserByLogin(login);
    }

    public void updateUser(User user) throws DAOException {
        LOGGER.info("The updateUser() method is called");
         userDAO.updateUser(user);
    }
    public boolean deleteUser(int id) throws DAOException {
        LOGGER.info("The deleteUser() method is called");
        return userDAO.deleteUser(id);
    }
    public User createUser(String login, String password, String role) throws DAOException{
        LOGGER.info("The createUser() method is called");
        userDAO.createUser(login, password, role);
        return userDAO.findUserByLogin(login);
    }




}
