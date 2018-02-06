package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.dao.impl.AdminDAO;
import com.kornievich.selectionCommition.entity.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class AdminPanelCommand implements BaseCommand{ //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static AdminPanelCommand instance = new AdminPanelCommand();

    public AdminPanelCommand() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        return PageConstant.PAGE_ADMIN_PANEL;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        request.setAttribute("nav", 0);
        return PageConstant.PAGE_ADMIN_PANEL;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static AdminPanelCommand getInstance() {
        return instance;
    }

}

