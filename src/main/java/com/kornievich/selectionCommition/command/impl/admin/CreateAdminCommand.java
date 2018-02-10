package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.command.Roles;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.entity.Admin;
import com.kornievich.selectionCommition.entity.User;
import com.kornievich.selectionCommition.exception.ConnectionUnavailException;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.service.AdminService;
import com.kornievich.selectionCommition.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CreateAdminCommand implements BaseCommand {
    static final Logger LOGGER = LogManager.getLogger(CreateAdminCommand.class);

    private static CreateAdminCommand instance = new CreateAdminCommand();

    private CreateAdminCommand() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
        String login = request.getParameter(ParameterConstant.PARAMETER_LOGIN);
        String password = request.getParameter(ParameterConstant.PARAMETER_PASSWORD);
        String surname = request.getParameter(ParameterConstant.PARAMETER_SURNAME);
        String firstName = request.getParameter(ParameterConstant.PARAMETER_FIRST_NAME);
        String lastName = request.getParameter(ParameterConstant.PARAMETER_LAST_NAME);
        System.out.println(surname + firstName + lastName);


        try {
            if(UserService.getInstance().findUserByLogin(login)!=null)
                return PageConstant.PAGE_ERROR;
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't find user with such input login. "+e);
        }
        User user= null;
        try {
            user = UserService.getInstance().createUser(login, password, Roles.ADMIN.getText());
        Admin admin = new Admin(user.getId(), surname, firstName, lastName);
            AdminService.getInstance().createAdmin(admin);
        } catch (DAOException e) {
        e.printStackTrace();
        LOGGER.error("Can't create admin with such input value. "+e);
    }
        return PageConstant.PAGE_ADMIN_PANEL;

    }
    @Override
    public String getPage(HttpServletRequest request) {
        LOGGER.info("The getPage() method is called");
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION, 5);

        return PageConstant.PAGE_ADMIN_PANEL;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static CreateAdminCommand getInstance() {
        return instance;
    }

}

