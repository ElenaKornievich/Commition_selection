package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.service.SpecialityService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpecialityCommand implements BaseCommand {

    static final Logger LOGGER = LogManager.getLogger(SpecialityCommand.class);

    private static SpecialityCommand instance = new SpecialityCommand();

    private SpecialityCommand() {
    }

    public static SpecialityCommand getInstance() {
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
        int specialityId = Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SPECIALITY_ID));
        try {
            SpecialityService.getInstance().deleteSpeciality(specialityId);
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't delete speciality with such input id. " + e);
        }
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION,
                PageConstant.PAGE_ADMIN_PANEL_CHANGE_SPECIALITY);
        return PageConstant.PAGE_ADMIN_PANEL;
    }

    @Override
    public String getPage(HttpServletRequest request) {
        LOGGER.info("The getPage() method is called");
        try {
            request.setAttribute(AttributeConstant.ATTRIBUTE_LIST_SPECIALITY,
                    SpecialityService.getInstance().readAllSpecialities());
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't read all specialities. " + e);
        }
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION,
                PageConstant.PAGE_ADMIN_PANEL_SPECIALITIES);
        return PageConstant.PAGE_ADMIN_PANEL;
    }
}


