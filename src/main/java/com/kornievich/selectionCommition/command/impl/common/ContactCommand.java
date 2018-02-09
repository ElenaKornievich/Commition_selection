package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContactCommand implements BaseCommand {  //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static ContactCommand instance = new ContactCommand();

    private ContactCommand() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        return null;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        try {
            request.setAttribute(AttributeConstant.ATTRIBUTE_LIST_ADMIN, AdminService.getInstance().readAllAdmins());
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return PageConstant.PAGE_CONTACT;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static ContactCommand getInstance() {
        return instance;
    }
}