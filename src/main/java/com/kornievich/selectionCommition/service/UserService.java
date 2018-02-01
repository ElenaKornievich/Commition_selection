package com.kornievich.selectionCommition.service;

import com.kornievich.selectionCommition.dao.impl.EntrantDAO;
import com.kornievich.selectionCommition.dao.impl.SpecialityDAO;
import com.kornievich.selectionCommition.dao.impl.UserDAO;
import com.kornievich.selectionCommition.entity.Entrant;
import com.kornievich.selectionCommition.entity.User;

import java.sql.SQLException;
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
          User user=userDAO.create(login, password);
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
        EntrantDAO entrantDAO = new EntrantDAO();
        UserDAO userDAO =new UserDAO();
        return userDAO.read(login, password);
    }




}
