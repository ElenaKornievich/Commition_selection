package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.command.Roles;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.dao.impl.RequestsDAO;
import com.kornievich.selectionCommition.dao.impl.UserDAO;
import com.kornievich.selectionCommition.entity.User;
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
        ArrayList<User> users = userDAO.readUsers();
        request.setAttribute("users", users);
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        try {
            User user = UserService.getInstance().findUser(login, password);
            // request.getSession().setAttribute("users", user.getLogin());
            if (user != null) {
                if(user.getRole()== Roles.ADMIN){
                    page = "jsp/admin/personalArea.jsp";
                }
                else page= "jsp/entrant/personalArea.jsp";
                // page = (String) request.getSession().getAttribute("previousPage");
                //page = PageConst.PAGE_SINGLE_MOVIE;

                //page = "WEB-INF/jsp/main.jsp";
                return page;
            } else {
                page = "error/error.jsp";
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
        //ArrayList<Integer> allIdSpesiality = requestsDAO.allIdSpesialty();
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
