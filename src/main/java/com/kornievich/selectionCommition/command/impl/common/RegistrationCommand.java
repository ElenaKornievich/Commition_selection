package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
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
        try {
           // User user = new User(login, password, Roles.ENTRANT);
            boolean add = UserService.getInstance().addUser(login, password);
            if (add) {
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

    public static RegistrationCommand getInstance() {
        return instance;
    }
}

