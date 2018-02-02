package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.dao.impl.FacultyDAO;
import com.kornievich.selectionCommition.dao.impl.SubjectDAO;
import com.kornievich.selectionCommition.entity.Faculty;
import com.kornievich.selectionCommition.entity.FacultySubject;
import com.kornievich.selectionCommition.service.FacultyService;
import com.kornievich.selectionCommition.service.FacultySubjectsService;
import com.kornievich.selectionCommition.service.SpecialityService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateSpecialityCommand  implements BaseCommand{
    //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static CreateSpecialityCommand instance = new CreateSpecialityCommand();

    public CreateSpecialityCommand() {
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int numberOfBudgetPlaces =Integer.parseInt(request.getParameter("numberOfBudgetPlaces"));
        int numberOfPainPlaces = Integer.parseInt(request.getParameter("numberOfPainPlaces"));
        int facultyId = Integer.valueOf(request.getParameter("facultyId"));
        String nameSpeciality= request.getParameter("nameSpeciality");
        SpecialityService.getInstance().create(nameSpeciality, facultyId, numberOfBudgetPlaces,numberOfPainPlaces);

         return "WEB-INF/jsp/admin/adminPanel.jsp";
    }
    @Override
    public String getPage(HttpServletRequest request) {
        FacultyDAO facultyDAO=new FacultyDAO();
        request.getSession().setAttribute("faculties",facultyDAO.readAll());
        request.setAttribute("nav", 8);
        return "WEB-INF/jsp/admin/adminPanel.jsp";

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static CreateSpecialityCommand getInstance() {
        return instance;
    }

}

