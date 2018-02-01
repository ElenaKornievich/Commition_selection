package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.command.impl.common.FacultyCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeButtonCommand implements BaseCommand {
    //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static ChangeButtonCommand instance = new ChangeButtonCommand();

    public ChangeButtonCommand() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        request.setAttribute("nav", 1);
        return "WEB-INF/jsp/admin/adminPanel.jsp";

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static ChangeButtonCommand getInstance() {
        return instance;
    }
}
