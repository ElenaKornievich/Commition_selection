package com.kornievich.selectionCommition.command.impl.entrant;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.command.impl.admin.ChangeEntrantCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.dao.impl.EntrantDAO;
import com.kornievich.selectionCommition.dao.impl.SpecialityDAO;
import com.kornievich.selectionCommition.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeEntrantSpeciality implements BaseCommand {
    static final Logger LOGGER = LogManager.getLogger(ChangeEntrantSpeciality.class);

    private static ChangeEntrantSpeciality instance = new ChangeEntrantSpeciality();

    private ChangeEntrantSpeciality() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
        int specialityId=Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SPECIALITY_ID));
        EntrantDAO entrantDAO=new EntrantDAO();
        int entrantId=(Integer) request.getSession().getAttribute(ParameterConstant.PARAMETER_ID);
        try {
            entrantDAO.changeEntrantSpeciality(entrantId, specialityId);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return PageConstant.PAGE_PERSONAL_AREA;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        SpecialityDAO specialityDAO=new SpecialityDAO();
        try {
            request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_SPECIALITIES,specialityDAO.readAllSpecialities());
        } catch (DAOException e) {
            e.printStackTrace();
        }

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


