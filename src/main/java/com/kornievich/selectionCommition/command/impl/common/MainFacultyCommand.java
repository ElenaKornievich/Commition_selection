package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.service.FacultyService;

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
        request.setAttribute("listFaculty", FacultyService.getInstance().readAll());
        return "jsp/mainFaculty.jsp";

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static MainFacultyCommand getInstance() {
        return instance;
    }

}
