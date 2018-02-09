package com.kornievich.selectionCommition.service;

import com.kornievich.selectionCommition.command.Roles;
import com.kornievich.selectionCommition.dao.impl.EntrantDAO;
import com.kornievich.selectionCommition.dao.impl.UserDAO;
import com.kornievich.selectionCommition.entity.Entrant;
import com.kornievich.selectionCommition.entity.User;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.util.SHA256Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrationService {

    // private static Logger logger = Logger.getLogger(UserService.class);

    private static RegistrationService instance;
    private UserDAO userDAO;
    private EntrantDAO entrantDAO;
    private RegistrationService() {
        userDAO =new UserDAO();
        entrantDAO=new EntrantDAO();

    }
    public static RegistrationService getInstance() {
        if(instance==null){
            instance = new RegistrationService();
        }
        return instance;
    }

    public User registrationEntrant(String login, String password, String pasportSeria,
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
        System.out.println(entrant.toString());
        entrantDAO.createEntrant(entrant);
        return user;
    }

}
