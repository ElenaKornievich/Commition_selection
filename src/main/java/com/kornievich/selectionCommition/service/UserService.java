package com.kornievich.selectionCommition.service;

import com.kornievich.selectionCommition.dao.impl.EntrantDAO;
import com.kornievich.selectionCommition.dao.impl.SpecialityDAO;
import com.kornievich.selectionCommition.dao.impl.UserDAO;
import com.kornievich.selectionCommition.entity.Entrant;
import com.kornievich.selectionCommition.entity.User;
import com.kornievich.selectionCommition.exception.ConnectionUnavailException;
import com.kornievich.selectionCommition.util.SHA256Util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

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


    public User addUser(String login, String password, String pasportSeria,
                           int pasportNumber, String surname, String firstName, String lastName, String dataOfIssue, String identificationNumber,
                           String dataOfBirth, String nationality, String telephoneNumber, String residenceAddress, double scope, boolean goldMedal, String email){

        try {
           // SpecialityDAO specialityDAO=new SpecialityDAO();
           // int specialityId = specialityDAO.findSpecialityByName(specialityName).getId();
          User user=userDAO.create(login, SHA256Util.encrypt(password));
            Entrant entrant = new Entrant(user.getId(), "2018-12-12" , pasportSeria, pasportNumber, surname, firstName, lastName, dataOfIssue,
                    identificationNumber, dataOfBirth, nationality, telephoneNumber, residenceAddress, scope, goldMedal, email);
            EntrantDAO entrantDAO=new EntrantDAO();
            System.out.println(entrant.toString());
            entrantDAO.create(entrant);
            return user;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("ошибка в сервисе");
            return null;
        }
    }

    public User findUser(String login, String password){


        try {
           User user = userDAO.findUserByLogin(login);
            if(user!=null){
                if (user.getPassword().equals(SHA256Util.encrypt(password))) {
                    return user;
                }
                else {return null;}
            }
            else  { return null;}
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (ConnectionUnavailException | SQLException e) {
            e.printStackTrace(); return null;
        }
    }
    public boolean changeRole(User user, String role){
        return userDAO.changeRole(user, role);
    }
    public ArrayList<User> readUsers(){
        return userDAO.readUsers();
    }
    public User findUserById(int id) throws InterruptedException, ConnectionUnavailException, SQLException{
        return userDAO.findUserById(id);
    }
    public User findUserByLogin(String login) throws InterruptedException, ConnectionUnavailException, SQLException{
        return userDAO.findUserByLogin(login);
    }

    public void update(User user){
         userDAO.update(user);
    }
    public User delete(User user){
        return userDAO.delete(user);
    }




}
