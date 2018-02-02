package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.command.impl.common.FacultyCommand;
import com.kornievich.selectionCommition.dao.impl.SubjectDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateFacultyCommand implements BaseCommand {
    //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static CreateFacultyCommand instance = new CreateFacultyCommand();

    public CreateFacultyCommand() {
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int subjectOne =Integer.valueOf(request.getParameter("subjectOneId"));
        int subjectTwo = Integer.valueOf(request.getParameter("subjectTwoId"));
        int subjectThree = Integer.valueOf(request.getParameter("subjectThreeId"));
        String name= request.getParameter("nameFaculty");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        return null;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        SubjectDAO subjectDAO=new SubjectDAO();
        request.getSession().setAttribute("subjects",subjectDAO.readAll());
        request.setAttribute("nav", 6);
        return "WEB-INF/jsp/faculty.jsp";

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static CreateFacultyCommand getInstance() {
        return instance;
    }

}

