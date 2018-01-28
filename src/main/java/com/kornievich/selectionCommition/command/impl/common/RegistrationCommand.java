package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.entity.User;
import com.kornievich.selectionCommition.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationCommand implements BaseCommand {
    private static RegistrationCommand instance = new RegistrationCommand();

    private RegistrationCommand() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String surname=request.getParameter("surname");
        String firstName=request.getParameter("firstName");
        String lastName=request.getParameter("lastName");
        String pasportSeria=request.getParameter("pasportSeria");
        int pasportNumber=Integer.valueOf(request.getParameter("pasportNomer"));
        String dataOfIssue=request.getParameter("dataOfIssue");
        String identificationNumber = request.getParameter("identificationNumber");
        String dataOfBirth = request.getParameter("dataOfBirth");
        String nationality = request.getParameter("nationality");
        String residenceAddress = request.getParameter("residenceAddress");
        double scope =Double.valueOf(request.getParameter("scope"));
        boolean goldMedal =Boolean.valueOf(request.getParameter("goldMedal"));
        String email = request.getParameter("email");
        String telephoneNumber = request.getParameter("telephoneNumber");
        String specialityName = request.getParameter("specialityName");
        try {
           // User user = new User(login, password, Roles.ENTRANT);
            User add = UserService.getInstance().addUser(login, password, specialityName, pasportSeria,
                    pasportNumber, surname, firstName, lastName, dataOfIssue, identificationNumber,
                    dataOfBirth, nationality, telephoneNumber, residenceAddress, scope, goldMedal, email);
            if (add!=null) {
                page = "WEB-INF/jsp/main.jsp";
            }
            //  request.getSession().setAttribute("", user);
            else {
                page = "WEB-INF/error/error.jsp";
            }
        } catch (Exception e) {
            System.out.println("что-то не так");
        }return page;
    }

    @Override
    public String getPage(HttpServletRequest request) {
        return null;
    }

    public static RegistrationCommand getInstance() {
        return instance;
    }
}

