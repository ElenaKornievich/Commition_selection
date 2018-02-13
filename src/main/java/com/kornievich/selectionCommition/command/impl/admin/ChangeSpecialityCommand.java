package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.entity.Speciality;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.service.SpecialityService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeSpecialityCommand implements BaseCommand {

    static final Logger LOGGER = LogManager.getLogger(ChangeSpecialityCommand.class);

    private static ChangeSpecialityCommand instance = new ChangeSpecialityCommand();

    private ChangeSpecialityCommand() {
    }

    public static ChangeSpecialityCommand getInstance() {
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
        int specialityId = Integer.parseInt(request.getParameter(ParameterConstant.PARAMETER_SPECIALITY_ID));
        String specialityName = request.getParameter(ParameterConstant.PARAMETER_SPECIALITY_NAME);
        int facultyId = Integer.parseInt(request.getParameter(ParameterConstant.PARAMETER_FACULTY_ID));
        int numberOfBudgetPlaces = Integer.parseInt(request.getParameter(ParameterConstant.PARAMETER_NUMBER_BUDGET_PLACE));
        int numberOfPaidPlaces = Integer.parseInt(request.getParameter(ParameterConstant.PARAMETER_NUMBER_PAIN_PLACE));
        try {
            SpecialityService.getInstance().updateSpeciality(new Speciality(specialityId,
                    specialityName, facultyId, numberOfBudgetPlaces, numberOfPaidPlaces));
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't find faculty with such input id. " + e);
        }
        return PageConstant.PAGE_ADMIN_PANEL;
    }

    @Override
    public String getPage(HttpServletRequest request) {
        LOGGER.info("The getPage() method is called");
        int specialityId = Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SPECIALITY_ID));
        System.out.println(specialityId);
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION, PageConstant.PAGE_ADMIN_PANEL_CHANGE_SPECIALITY);
        Speciality speciality = null;
        try {
            speciality = SpecialityService.getInstance().findSpecialityById(specialityId);
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't find speciality with such input id. " + e);
        }
        request.setAttribute(AttributeConstant.ATTRIBUTE_SPECIALITY, speciality);
        return PageConstant.PAGE_ADMIN_PANEL;
    }
}
