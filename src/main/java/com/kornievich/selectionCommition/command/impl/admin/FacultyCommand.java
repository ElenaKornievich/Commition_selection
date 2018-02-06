package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.service.FacultyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FacultyCommand implements BaseCommand {
//  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static FacultyCommand instance = new FacultyCommand();

    public FacultyCommand() {
    }

    ;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int idFaculty = Integer.valueOf(request.getParameter("idFaculty"));
        FacultyService.getInstance().delete(idFaculty);
        request.setAttribute("nav",9);
        return "jsp/admin/adminPanel.jsp";
    }
    @Override
    public String getPage(HttpServletRequest request) {
        request.setAttribute("listFaculties",FacultyService.getInstance().readAll());
        request.setAttribute("nav",12);
        return "jsp/admin/adminPanel.jsp";

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static FacultyCommand getInstance() {
        return instance;
    }

}

