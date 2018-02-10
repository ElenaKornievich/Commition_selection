package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.entity.Admin;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.service.AdminService;
import com.kornievich.selectionCommition.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminInformationCommand implements BaseCommand {
    static final Logger LOGGER = LogManager.getLogger(AdminInformationCommand.class);

    private static AdminInformationCommand instance = new AdminInformationCommand();

    private AdminInformationCommand() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
        return PageConstant.PAGE_ADMIN_PANEL;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        LOGGER.info("The getPage() method is called");
        int id = (int) request.getSession().getAttribute("id");
        try {
            Admin admin = AdminService.getInstance().findAdminById(id);
            request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_ADMIN, admin);
        } catch (DAOException e) {
            e.printStackTrace();
           LOGGER.error("Can't search admin with such input id. "+e);
        }
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION, 3);
        return PageConstant.PAGE_ADMIN_PANEL;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static AdminInformationCommand getInstance() {
        return instance;
    }

}


