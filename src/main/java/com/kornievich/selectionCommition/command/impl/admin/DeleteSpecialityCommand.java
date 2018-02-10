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

public class DeleteSpecialityCommand implements BaseCommand {
    static final Logger LOGGER = LogManager.getLogger(DeleteSpecialityCommand.class);

    private static DeleteSpecialityCommand instance = new DeleteSpecialityCommand();

    private DeleteSpecialityCommand() {
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
        int specialityId = Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SPECIALITY_ID));
        try {
            SpecialityService.getInstance().deleteSpeciality(specialityId);
            request.setAttribute(AttributeConstant.ATTRIBUTE_LIST_SPECIALITY, SpecialityService.getInstance().readAllSpecialities());
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't delete speciality with such input id. "+e);
        }
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION, 13);
        return PageConstant.PAGE_ADMIN_PANEL;
    }

    @Override
    public String getPage(HttpServletRequest request) {
        LOGGER.info("The getPage() method is called");
        try {
            request.setAttribute(AttributeConstant.ATTRIBUTE_LIST_SPECIALITY, SpecialityService.getInstance().readAllSpecialities());
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't read all specialities. "+e);
        }
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION, 13);
        return PageConstant.PAGE_ADMIN_PANEL;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static DeleteSpecialityCommand getInstance() {
        return instance;
    }

}

