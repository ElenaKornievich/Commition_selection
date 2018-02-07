package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.command.Roles;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.dao.impl.AdminDAO;
import com.kornievich.selectionCommition.dao.impl.EntrantDAO;
import com.kornievich.selectionCommition.dao.impl.SpecialityDAO;
import com.kornievich.selectionCommition.dao.impl.UserDAO;
import com.kornievich.selectionCommition.entity.Admin;
import com.kornievich.selectionCommition.entity.Entrant;
import com.kornievich.selectionCommition.entity.User;
import com.kornievich.selectionCommition.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class LoginCommand implements BaseCommand {


    //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static LoginCommand instance = new LoginCommand();

    public LoginCommand() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        UserDAO userDAO = new UserDAO();
        ArrayList<User> users = userDAO.readUsers();
        EntrantDAO entrantDAO = new EntrantDAO();
        ArrayList<Entrant> entrants = entrantDAO.readEntrant();
        request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_USERS, users);
        String login = request.getParameter(ParameterConstant.PARAMETER_LOGIN);
        String password = request.getParameter(ParameterConstant.PARAMETER_PASSWORD);
        try {
            User user = UserService.getInstance().findUser(login, password);
            if(user!=null){
            request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_USER, user.getLogin());
            request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_ID, user.getId());
                if (user.getRole() == Roles.ADMIN) {
                    request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_ENTRANTS, entrants);
                    request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_ROLE, AttributeConstant.ATTRIBUTE_ADMIN);
                    AdminDAO adminDAO = new AdminDAO();
                    Admin admin = adminDAO.findAdminById(user.getId());
                    request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_ADMIN, admin);
                    page = PageConstant.PAGE_ADMIN_PANEL;
                } else {
                    Entrant entrant = entrantDAO.findEntrantById(user.getId());
                    request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_ENTRANT, entrant);
                   // request.getSession().setAttribute("surname", entrant.getSurname());
                   // request.getSession().setAttribute("firstName", entrant.getFirstName());
                    //request.getSession().setAttribute("lastName", entrant.getLastName());
                    //request.getSession().setAttribute("pasportSeria", entrant.getPasportSeries());
                    //request.getSession().setAttribute("pasportNomer", entrant.getPassportNumber());
                    //request.getSession().setAttribute("dataOfIssue", entrant.getDateOfIssue());
                    //request.getSession().setAttribute("identificationNumber", entrant.getIdentificationNumber());
                    //request.getSession().setAttribute("dataOfBirth", entrant.getDateOfBirth());
                    //request.getSession().setAttribute("nationality", entrant.getNationality());
                    //request.getSession().setAttribute("residenceAddress", entrant.getResidenceAddress());
                    //request.getSession().setAttribute("scope", entrant.getScore());
                    //request.getSession().setAttribute("goldMedal", entrant.isGoldMedal());
                    //request.getSession().setAttribute("email", entrant.getEmail());
                    //request.getSession().setAttribute("telephoneNumber", entrant.getTelephoneNumber());
                    //SpecialityDAO specialityDAO = new SpecialityDAO();
                    //request.getSession().setAttribute("specialityId",entrant.getSpecialityId());

                    request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_ROLE, AttributeConstant.ATTRIBUTE_CTPOINT_ENTRANT);
                    page = PageConstant.PAGE_PERSONAL_AREA;
                }
                // page = (String) request.getSession().getAttribute("previousPage");
                //page = PageConst.PAGE_SINGLE_MOVIE;

                //page = "WEB-INF/jsp/main.jsp";
                return page;
            } else {
                page = PageConstant.PAGE_ERROR;
            }
        } catch (Exception e) {
            System.out.println("ppp");
        }
        return page;
    }

    @Override
    public String getPage(HttpServletRequest request) {
        UserDAO userDAO = new UserDAO();
        ArrayList<User> users = userDAO.readUsers();
        request.setAttribute(AttributeConstant.ATTRIBUTE_USERS, users);
        request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_LOGIN, AttributeConstant.ATTRIBUTE_LOGON);
        String page = PageConstant.PAGE_AUTHORIZATION;
        return page;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static LoginCommand getInstance() {
        return instance;
    }
}