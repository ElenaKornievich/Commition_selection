package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminPanelCommand implements BaseCommand{

    static final Logger LOGGER = LogManager.getLogger(AdminPanelCommand.class);

    private static AdminPanelCommand instance = new AdminPanelCommand();

    private AdminPanelCommand() {}

    public static AdminPanelCommand getInstance() {
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
        return PageConstant.PAGE_ADMIN_PANEL;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        LOGGER.info("The getPage() method is called");
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION, PageConstant.PAGE_ADMIN_PANEL_COMMON);
        return PageConstant.PAGE_ADMIN_PANEL;
    }
}

