package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainFacultyCommand implements BaseCommand {
    //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static MainFacultyCommand instance = new MainFacultyCommand();

    public MainFacultyCommand() {
    }



    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
       return null;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        return "WEB-INF/jsp/changeFaculty.jsp";

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static MainFacultyCommand getInstance() {
        return instance;
    }

}
