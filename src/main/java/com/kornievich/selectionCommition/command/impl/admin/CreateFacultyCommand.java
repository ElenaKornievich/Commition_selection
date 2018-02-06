package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.dao.impl.SubjectDAO;
import com.kornievich.selectionCommition.entity.Faculty;
import com.kornievich.selectionCommition.entity.FacultySubject;
import com.kornievich.selectionCommition.service.FacultyService;
import com.kornievich.selectionCommition.service.FacultySubjectsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateFacultyCommand implements BaseCommand {
    //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static CreateFacultyCommand instance = new CreateFacultyCommand();

    public CreateFacultyCommand() {
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int subjectOneId =Integer.valueOf(request.getParameter("subjectOneId"));
        int subjectTwoId = Integer.valueOf(request.getParameter("subjectTwoId"));
        int subjectThreeId = Integer.valueOf(request.getParameter("subjectThreeId"));
        String name= request.getParameter("nameFaculty");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        Faculty faculty= FacultyService.getInstance().create(name, startDate, endDate);
        FacultySubjectsService.getInstance().create(new FacultySubject(faculty.getId(), subjectOneId));
        FacultySubjectsService.getInstance().create(new FacultySubject(faculty.getId(), subjectTwoId));
        FacultySubjectsService.getInstance().create(new FacultySubject(faculty.getId(), subjectThreeId));
        return "jsp/admin/adminPanel.jsp";
    }
    @Override
    public String getPage(HttpServletRequest request) {
        SubjectDAO subjectDAO=new SubjectDAO();
        request.getSession().setAttribute("subjects",subjectDAO.readAll());
        request.setAttribute("nav", 6);
        return "jsp/admin/adminPanel.jsp";

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static CreateFacultyCommand getInstance() {
        return instance;
    }

}

