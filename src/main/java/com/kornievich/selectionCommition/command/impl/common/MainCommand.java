package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.command.Roles;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.dao.impl.UserDAO;
import com.kornievich.selectionCommition.entity.User;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class MainCommand implements BaseCommand {
    private static MainCommand instance = new MainCommand();

    public MainCommand() {
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        UserDAO userDAO=new UserDAO();
        ArrayList<User> users = null;
        try {
            users = userDAO.readAllUsers();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        request.setAttribute(AttributeConstant.ATTRIBUTE_USERS, users);
        String login = request.getParameter(ParameterConstant.PARAMETER_LOGIN);
        String password = request.getParameter(ParameterConstant.PARAMETER_PASSWORD);
        try {
            User user = UserService.getInstance().findUser(login, password);
            // request.getSession().setAttribute("users", user.getLogin());
            if (user != null) {
                if(user.getRole()== Roles.ADMIN){
                    page = PageConstant.PAGE_ADMIN_PANEL;
                }
                else page= PageConstant.PAGE_PERSONAL_AREA;
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
       // RequestsDAO requestsDAO = new RequestsDAO();
       // ArrayList<Integer> entrant;
        //ArrayList<Integer> allIdSpesiality = requestsDAO.readAllIdSpecialties();
       // entrant= requestsDAO.allScoreBySpesialty(1);
       // request.setAttribute("entrant", entrant);
       // request.setAttribute("spesiality", allIdSpesiality);
        return PageConstant.PAGE_MAIN;

    }
    @Override
    public String toString() {
        return super.toString();
    }

    public static MainCommand getInstance() {
        return instance;
    }
}
