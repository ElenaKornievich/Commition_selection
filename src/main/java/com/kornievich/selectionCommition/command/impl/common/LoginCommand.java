package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.entity.User;
import com.kornievich.selectionCommition.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements BaseCommand {


  //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static LoginCommand instance = new LoginCommand();

    public LoginCommand(){};

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        String page = null;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        try {
            User user = UserService.getInstance().findUser(login, password);
            request.getSession().setAttribute("user", user.getLogin());
            if(user!=null) {
               // page = (String) request.getSession().getAttribute("previousPage");
                //page = PageConst.PAGE_SINGLE_MOVIE;
                page="WEB-INF/jsp/main.jsp";
                return page;
            }
            else {
                page="WEB-INF/error/error.jsp";
            }
        }
        catch (Exception e){
            System.out.println("ppp");
        }
        return page;
    }

    public static LoginCommand getInstance(){
        return instance;
    }
}