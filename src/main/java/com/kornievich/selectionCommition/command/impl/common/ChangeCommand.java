package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.dao.impl.EntrantDAO;
import com.kornievich.selectionCommition.dao.impl.SpecialityDAO;
import com.kornievich.selectionCommition.entity.Entrant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeCommand  implements BaseCommand{//  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static ChangeCommand instance = new ChangeCommand();

    public ChangeCommand() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String surname=request.getParameter(ParameterConstant.PARAMETER_SURNAME);
        String firstName=request.getParameter(ParameterConstant.PARAMETER_FIRST_NAME);
        String lastName=request.getParameter(ParameterConstant.PARAMETER_LAST_NAME);
        String pasportSeria=request.getParameter(ParameterConstant.PARAMETER_PASPORT_SERIA);
        int pasportNumber=Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_PASPORT_NOMER));
        String dataOfIssue=request.getParameter(ParameterConstant.PARAMETER_DATE_OF_ISSUE);
        String identificationNumber = request.getParameter(ParameterConstant.PARAMETER_IDENTIFICATION_NUMBER);
        String dataOfBirth = request.getParameter(ParameterConstant.PARAMETER_DATE_OF_BIRTH);
        String nationality = request.getParameter(ParameterConstant.PARAMETER_NATIONALITY);
        String residenceAddress = request.getParameter(ParameterConstant.PARAMETER_RESIDENCE_ADDRESS);
        double scope =Double.valueOf(request.getParameter(ParameterConstant.PARAMETER_SCOPE));
        boolean goldMedal =Boolean.valueOf(request.getParameter(ParameterConstant.PARAMETER_GOLD_MEDAL));
        String email = request.getParameter(ParameterConstant.PARAMETER_EMAIL);
        String telephoneNumber = request.getParameter(ParameterConstant.PARAMETER_TELEPHONE_NUMBER);
        int specialityId =Integer.parseInt(request.getParameter(ParameterConstant.PARAMETER_SPECIALITY_ID));
       // SpecialityDAO specialityDAO= new SpecialityDAO();
        //int specialityId = specialityDAO.findSpecialityByName(specialityName).getId();
        Entrant entrant = new Entrant((Integer)request.getSession().getAttribute(ParameterConstant.PARAMETER_ID), "2018-11-11", specialityId, pasportSeria, pasportNumber, surname, firstName, lastName, dataOfIssue, identificationNumber, dataOfBirth, nationality, telephoneNumber, residenceAddress, scope, goldMedal, email);
        EntrantDAO entrantDAO = new EntrantDAO();
        entrantDAO.update(entrant);

        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION, 0);
        return PageConstant.PAGE_PERSONAL_AREA;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        SpecialityDAO specialityDAO=new SpecialityDAO();
        request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_SPECIALITIES,specialityDAO.readAll());

        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION, 1);
        return PageConstant.PAGE_PERSONAL_AREA;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static ChangeCommand getInstance() {
        return instance;
    }

}
