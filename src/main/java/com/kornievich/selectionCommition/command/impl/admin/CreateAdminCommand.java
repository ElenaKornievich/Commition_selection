package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.command.Roles;
import com.kornievich.selectionCommition.command.impl.common.FacultyCommand;
import com.kornievich.selectionCommition.dao.impl.AdminDAO;
import com.kornievich.selectionCommition.dao.impl.UserDAO;
import com.kornievich.selectionCommition.entity.Admin;
import com.kornievich.selectionCommition.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class CreateAdminCommand implements BaseCommand {
    //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static CreateAdminCommand instance = new CreateAdminCommand();

    public CreateAdminCommand() {
    }

    ;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String surname = request.getParameter("surname");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        UserDAO userDAO = new UserDAO();
        AdminDAO adminDAO=new AdminDAO();

        System.out.println(surname + firstName + lastName);

        try {
            User user=userDAO.create(login,password);
            userDAO.changeRole(user, "admin");
            user.setRole(Roles.ADMIN);
            Admin admin = new Admin(user.getId(), surname, firstName, lastName);
            adminDAO.create(admin);
            return "WEB-INF/jsp/admin/adminPanel.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public String getPage(HttpServletRequest request) {


        request.setAttribute("nav", 5);

        return "WEB-INF/jsp/admin/adminPanel.jsp";

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static CreateAdminCommand getInstance() {
        return instance;
    }

}

