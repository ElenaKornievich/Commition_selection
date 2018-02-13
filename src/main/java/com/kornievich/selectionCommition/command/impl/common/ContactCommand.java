package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.service.AdminService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContactCommand implements BaseCommand {

    static final Logger LOGGER = LogManager.getLogger(ContactCommand.class);

    private static ContactCommand instance = new ContactCommand();

    private ContactCommand() {
    }

    public static ContactCommand getInstance() {
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
        return null;
    }

    @Override
    public String getPage(HttpServletRequest request) {
        LOGGER.info("The getPage() method is called");
        try {
            request.setAttribute(AttributeConstant.ATTRIBUTE_LIST_ADMIN,
                    AdminService.getInstance().readAllAdmins());
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't read all admins. " + e);
        }
        return PageConstant.PAGE_CONTACT;
    }
}