package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.entity.Admin;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.service.AdminService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeAdminCommand implements BaseCommand {

    static final Logger LOGGER = LogManager.getLogger(ChangeAdminCommand.class);

    private static ChangeAdminCommand instance = new ChangeAdminCommand();

    private ChangeAdminCommand() {
    }

    public static ChangeAdminCommand getInstance() {
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
        String surname = request.getParameter(ParameterConstant.PARAMETER_SURNAME);
        String firstName = request.getParameter(ParameterConstant.PARAMETER_FIRST_NAME);
        String lastName = request.getParameter(ParameterConstant.PARAMETER_LAST_NAME);
        int id = Integer.parseInt(request.getParameter(ParameterConstant.PARAMETER_ID_ADMIN));
        Admin admin = new Admin(id, surname, firstName, lastName);
        try {
            AdminService.getInstance().updateAdmin(admin);
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't update admin with such input value. " + e);
        }

        request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_ADMIN, admin);
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION, PageConstant.PAGE_ADMIN_PANEL_COMMON);
        request.setAttribute(AttributeConstant.ATTRIBUTE_EXECUTE, PageConstant.PAGE_ADMIN_PANEL_CHANGE_SUBJECT);
        return PageConstant.PAGE_ADMIN_PANEL;
    }

    @Override
    public String getPage(HttpServletRequest request) {
        LOGGER.info("The getPage() method is called");
        int id = (int) request.getSession().getAttribute(AttributeConstant.ATTRIBUTE_ID);
        try {
            Admin admin = AdminService.getInstance().findAdminById(id);
            request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_ADMIN, admin);
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't update admin with such input id. " + e);
        }
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION, PageConstant.PAGE_ADMIN_PANEL_CHANGE_ADMIN_INFORMATION);
        return PageConstant.PAGE_ADMIN_PANEL;
    }
}

