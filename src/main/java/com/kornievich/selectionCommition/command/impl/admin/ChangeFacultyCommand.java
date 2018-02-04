package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.command.impl.common.FacultyCommand;
import com.kornievich.selectionCommition.entity.Faculty;
import com.kornievich.selectionCommition.entity.FacultySubject;
import com.kornievich.selectionCommition.service.FacultyService;
import com.kornievich.selectionCommition.service.FacultySubjectsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeFacultyCommand implements BaseCommand {

    //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static ChangeFacultyCommand instance = new ChangeFacultyCommand();

    public ChangeFacultyCommand() {
    }

    ;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int subjectOneId =Integer.valueOf(request.getParameter("subjectOneId"));
        int subjectTwoId = Integer.valueOf(request.getParameter("subjectTwoId"));
        int subjectThreeId = Integer.valueOf(request.getParameter("subjectThreeId"));
        String name= request.getParameter("nameFaculty");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        int idFaculty = Integer.valueOf(request.getParameter("idFaculty"));
        FacultyService.getInstance().update(new Faculty(idFaculty, name,startDate,endDate));
        FacultySubjectsService.getInstance().update(new FacultySubject(idFaculty,subjectOneId));
        FacultySubjectsService.getInstance().update(new FacultySubject(idFaculty, subjectTwoId));
        FacultySubjectsService.getInstance().update(new FacultySubject(idFaculty, subjectThreeId));
        return "WEB-INF/jsp/admin/adminPanel.jsp";
    }
    @Override
    public String getPage(HttpServletRequest request) {
        request.setAttribute("nav",9);
        return "WEB-INF/jsp/admin/adminPanel.jsp";

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static ChangeFacultyCommand getInstance() {
        return instance;
    }

}
