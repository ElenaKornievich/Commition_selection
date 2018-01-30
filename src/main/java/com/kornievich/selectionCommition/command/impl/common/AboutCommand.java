package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AboutCommand implements BaseCommand{
    //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static AboutCommand instance = new AboutCommand();

    public AboutCommand() {
    }

    ;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
    @Override
    public String getPage(HttpServletRequest request) {

        request.setAttribute("nav", 3);
        return "WEB-INF/jsp/entrant/personalArea.jsp";

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static AboutCommand getInstance() {
        return instance;
    }

}

