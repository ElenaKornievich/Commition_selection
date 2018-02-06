package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.entity.Faculty;
import com.kornievich.selectionCommition.entity.FacultySubject;
import com.kornievich.selectionCommition.service.FacultyService;
import com.kornievich.selectionCommition.service.FacultySubjectsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteFacultyCommand implements BaseCommand{
//  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static DeleteFacultyCommand instance = new DeleteFacultyCommand();

    public DeleteFacultyCommand() {
    }

    ;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int idFaculty = Integer.valueOf(request.getParameter("facultyId"));
        FacultyService.getInstance().delete(idFaculty);
        request.setAttribute("listFaculties",FacultyService.getInstance().readAll());
        request.setAttribute("nav",12);
        return PageConstant.PAGE_ADMIN_PANEL;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        request.setAttribute("listFaculties",FacultyService.getInstance().readAll());
        request.setAttribute("nav",12);
        return PageConstant.PAGE_ADMIN_PANEL;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static DeleteFacultyCommand getInstance() {
        return instance;
    }

}
