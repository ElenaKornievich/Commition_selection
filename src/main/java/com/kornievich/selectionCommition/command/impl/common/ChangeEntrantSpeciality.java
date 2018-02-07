package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.dao.impl.EntrantDAO;
import com.kornievich.selectionCommition.dao.impl.SpecialityDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeEntrantSpeciality implements BaseCommand {
    //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static ChangeEntrantSpeciality instance = new ChangeEntrantSpeciality();

    public ChangeEntrantSpeciality() {
    }

    ;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int specialityId=Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SPECIALITY_ID));
        EntrantDAO entrantDAO=new EntrantDAO();
        int entrantId=(Integer) request.getSession().getAttribute(ParameterConstant.PARAMETER_ID);
        entrantDAO.changeSpeciality(entrantId, specialityId);
        return PageConstant.PAGE_PERSONAL_AREA;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        SpecialityDAO specialityDAO=new SpecialityDAO();
        request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_SPECIALITIES,specialityDAO.readAll());

        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION, 2);
        return PageConstant.PAGE_PERSONAL_AREA;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static ChangeEntrantSpeciality getInstance() {
        return instance;
    }

}


