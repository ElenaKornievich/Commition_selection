package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.service.FacultyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteFacultyCommand implements BaseCommand{
    static final Logger LOGGER = LogManager.getLogger(DeleteFacultyCommand.class);

    private static DeleteFacultyCommand instance = new DeleteFacultyCommand();

    private DeleteFacultyCommand() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
        int idFaculty = Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_FACULTY_ID));
        try {
            FacultyService.getInstance().deleteFaculty(idFaculty);
        request.setAttribute(AttributeConstant.ATTRIBUTE_LIST_FACULTIES,FacultyService.getInstance().readAllFaculties());
        } catch (DAOException e) {
            e.printStackTrace();
        }
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION,12);
        return PageConstant.PAGE_ADMIN_PANEL;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        LOGGER.info("The getPage() method is called");
        try {
            request.setAttribute(AttributeConstant.ATTRIBUTE_LIST_FACULTIES,FacultyService.getInstance().readAllFaculties());
        } catch (DAOException e) {
            e.printStackTrace();
        }
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION,12);
        return PageConstant.PAGE_ADMIN_PANEL;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static DeleteFacultyCommand getInstance() {
        return instance;
    }

}
