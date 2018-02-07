package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
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
        int numberOfBudgetPlaces =Integer.parseInt(request.getParameter(ParameterConstant.PARAMETER_NUMBER_BUDGET_PLACE));
        int numberOfPainPlaces = Integer.parseInt(request.getParameter(ParameterConstant.PARAMETER_NUMBER_PAIN_PLACE));
        int facultyId = Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_FACULTY_ID));
        String nameSpeciality= request.getParameter(ParameterConstant.PARAMETER_SPECIALITY_NAME);
        if(SpecialityService.getInstance().findSpecialityByName(nameSpeciality)!=null){
            return PageConstant.PAGE_ERROR;
        }
        SpecialityService.getInstance().create(nameSpeciality, facultyId, numberOfBudgetPlaces,numberOfPainPlaces);

         return PageConstant.PAGE_ADMIN_PANEL;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        FacultyDAO facultyDAO=new FacultyDAO();
        request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_FACULTIES,facultyDAO.readAll());
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION, 8);
        return PageConstant.PAGE_ADMIN_PANEL;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static CreateSpecialityCommand getInstance() {
        return instance;
    }

}

