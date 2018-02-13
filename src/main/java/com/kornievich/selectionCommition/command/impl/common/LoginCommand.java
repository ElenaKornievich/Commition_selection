package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.command.Roles;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.ErrorMassageConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.entity.User;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class LoginCommand implements BaseCommand {

    static final Logger LOGGER = LogManager.getLogger(LoginCommand.class);

    private static LoginCommand instance = new LoginCommand();

    private LoginCommand() {
    }

    public static LoginCommand getInstance() {
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
        String page = null;
        try {
            String login = request.getParameter(ParameterConstant.PARAMETER_LOGIN);
            String password = request.getParameter(ParameterConstant.PARAMETER_PASSWORD);
            User user = UserService.getInstance().findUser(login, password);
            if (user != null) {
                request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_USER, user.getLogin());
                request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_ID, user.getId());
                if (user.getRole() == Roles.ADMIN) {
                    request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_ROLE,
                            AttributeConstant.ATTRIBUTE_ADMIN);
                    page = PageConstant.PAGE_ADMIN_PANEL;
                } else {
                    request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_ROLE,
                            AttributeConstant.ATTRIBUTE_ENTRANT);
                    page = PageConstant.PAGE_PERSONAL_AREA;
                }
                return page;
            } else {
                request.setAttribute(AttributeConstant.ATTRIBUTE_ERROR_MASSAGE,
                        ErrorMassageConstant.LOGIN_ERROR);
                page = PageConstant.PAGE_ERROR;
            }
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't login command with such value. " + e);
        }
        return page;
    }

    @Override
    public String getPage(HttpServletRequest request) {
        LOGGER.info("The getPage() method is called");
        ArrayList<User> users = null;
        try {
            users = UserService.getInstance().readAllUsers();
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't read all users. " + e);
        }
        request.setAttribute(AttributeConstant.ATTRIBUTE_USERS, users);
        request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_LOGIN, AttributeConstant.ATTRIBUTE_LOGON);
        return PageConstant.PAGE_AUTHORIZATION;
    }
}