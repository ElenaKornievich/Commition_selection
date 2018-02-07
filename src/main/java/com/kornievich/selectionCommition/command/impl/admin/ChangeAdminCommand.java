package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.dao.impl.AdminDAO;
import com.kornievich.selectionCommition.entity.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class ChangeAdminCommand implements BaseCommand{
    //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static ChangeAdminCommand instance = new ChangeAdminCommand();

    public ChangeAdminCommand() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String surname = request.getParameter(ParameterConstant.PARAMETER_SURNAME);
        String firstName = request.getParameter(ParameterConstant.PARAMETER_FIRST_NAME);
        String lastName = request.getParameter(ParameterConstant.PARAMETER_LAST_NAME);
        int id =Integer.parseInt(request.getParameter(ParameterConstant.PARAMETER_ID_ADMIN));
        AdminDAO adminDAO=new AdminDAO();
        Admin admin = new Admin(id, surname, firstName, lastName);
        adminDAO.update(admin);

        request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_ADMIN, admin);
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION, 2);
        request.setAttribute(AttributeConstant.ATTRIBUTE_EXECUTE, 10);
        return PageConstant.PAGE_ADMIN_PANEL;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION, 2);
        return PageConstant.PAGE_ADMIN_PANEL;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static ChangeAdminCommand getInstance() {
        return instance;
    }

}

