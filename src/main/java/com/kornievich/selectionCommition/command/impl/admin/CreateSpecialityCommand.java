package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.dao.impl.FacultyDAO;
import com.kornievich.selectionCommition.exception.DAOException;
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
        try {
            if(SpecialityService.getInstance().findSpecialityByName(nameSpeciality)!=null){
                return PageConstant.PAGE_ERROR;
            }
        SpecialityService.getInstance().createSpeciality(nameSpeciality, facultyId, numberOfBudgetPlaces,numberOfPainPlaces);
        } catch (DAOException e) {
            e.printStackTrace();
        }
         return PageConstant.PAGE_ADMIN_PANEL;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        FacultyDAO facultyDAO=new FacultyDAO();
        try {
            request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_FACULTIES,facultyDAO.readAllFaculties());
        } catch (DAOException e) {
            e.printStackTrace();
        }
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

