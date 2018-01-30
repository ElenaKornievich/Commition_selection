package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeSpesiality implements BaseCommand {
    //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static ChangeSpesiality instance = new ChangeSpesiality();

    public ChangeSpesiality() {
    }

    ;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        request.getSession().setAttribute("nav", 2);
        return "WEB-INF/jsp/entrant/personalArea.jsp";

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static ChangeSpesiality getInstance() {
        return instance;
    }

}


