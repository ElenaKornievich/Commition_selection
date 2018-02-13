package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.service.FacultyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainFacultyCommand implements BaseCommand {

    private static final Logger LOGGER = LogManager.getLogger(MainFacultyCommand.class);

    private static MainFacultyCommand instance = new MainFacultyCommand();

    private MainFacultyCommand() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
       return null;
    }

    @Override
    public String getPage(HttpServletRequest request) {
        LOGGER.info("The getPage() method is called");
        try {
            request.setAttribute(AttributeConstant.ATTRIBUTE_LIST_FACULTY,
                    FacultyService.getInstance().readAllFaculties());
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't read all faculties. "+e);
        }
        return PageConstant.PAGE_MAIN_FACULTY;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static MainFacultyCommand getInstance() {
        return instance;
    }

}
