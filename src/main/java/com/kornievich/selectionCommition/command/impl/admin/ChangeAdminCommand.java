package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.PageConstant;
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
        String surname = request.getParameter("surname");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        System.out.println("id "+ request.getParameter("firstName")+ request.getParameter("idAdmin"));
        int id =Integer.parseInt(request.getParameter("idAdmin"));
        System.out.println("id " + id);
        AdminDAO adminDAO=new AdminDAO();
        Admin admin = new Admin(id, surname, firstName, lastName);
        adminDAO.update(admin);

        request.getSession().setAttribute("admin", admin);
        request.setAttribute("nav", 2);
        request.setAttribute("execute", 10);
        return PageConstant.PAGE_ADMIN_PANEL;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        request.setAttribute("nav", 2);
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

