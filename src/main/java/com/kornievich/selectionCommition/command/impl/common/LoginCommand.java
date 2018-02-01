package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.command.Roles;
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
        request.getSession().setAttribute("users", users);
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        try {
            User user = UserService.getInstance().findUser(login, password);
            request.getSession().setAttribute("user", user.getLogin());
            request.getSession().setAttribute("id", user.getId());
            if (user != null) {
                if (user.getRole() == Roles.ADMIN) {
                    request.getSession().setAttribute("entrants", entrants);
                    request.getSession().setAttribute("role", "admin");
                    AdminDAO adminDAO = new AdminDAO();
                    Admin admin = adminDAO.findAdminById(user.getId());
                    request.getSession().setAttribute("admin", admin);
                    page = "WEB-INF/jsp/admin/adminPanel.jsp";
                } else {
                    Entrant entrant = entrantDAO.findEntrantById(user.getId());
                    request.getSession().setAttribute("surname", entrant.getSurname());
                    request.getSession().setAttribute("firstName", entrant.getFirstName());
                    request.getSession().setAttribute("lastName", entrant.getLastName());
                    request.getSession().setAttribute("pasportSeria", entrant.getPasportSeries());
                    request.getSession().setAttribute("pasportNomer", entrant.getPassportNumber());
                    request.getSession().setAttribute("dataOfIssue", entrant.getDateOfIssue());
                    request.getSession().setAttribute("identificationNumber", entrant.getIdentificationNumber());
                    request.getSession().setAttribute("dataOfBirth", entrant.getDateOfBirth());
                    request.getSession().setAttribute("nationality", entrant.getNationality());
                    request.getSession().setAttribute("residenceAddress", entrant.getResidenceAddress());
                    request.getSession().setAttribute("scope", entrant.getScore());
                    request.getSession().setAttribute("goldMedal", entrant.isGoldMedal());
                    request.getSession().setAttribute("email", entrant.getEmail());
                    request.getSession().setAttribute("telephoneNumber", entrant.getTelephoneNumber());
                    SpecialityDAO specialityDAO = new SpecialityDAO();
                    request.getSession().setAttribute("specialityName", specialityDAO.findSpecialityById(entrant.getSpecialityId()));

                    request.getSession().setAttribute("role", "entrant");
                    page = "WEB-INF/jsp/entrant/personalArea.jsp";
                }
                // page = (String) request.getSession().getAttribute("previousPage");
                //page = PageConst.PAGE_SINGLE_MOVIE;

                //page = "WEB-INF/jsp/main.jsp";
                return page;
            } else {
                page = "WEB-INF/error/error.jsp";
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
        request.setAttribute("users", users);
        String login = "logon";
        request.getSession().setAttribute("login", login);
        String page = "WEB-INF/jsp/authorization.jsp";
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