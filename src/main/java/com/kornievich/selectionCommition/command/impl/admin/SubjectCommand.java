package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.service.SubjectService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubjectCommand implements BaseCommand {

    static final Logger LOGGER = LogManager.getLogger(SubjectCommand.class);

    private static SubjectCommand instance = new SubjectCommand();

    private SubjectCommand() {
    }

    public static SubjectCommand getInstance() {
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
        int subjectId = Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SUBJECT_ID));
        try {
            SubjectService.getInstance().deleteSubject(subjectId);
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't delete subject with such input id. " + e);
        }
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION,
                PageConstant.PAGE_ADMIN_PANEL_CHANGE_SUBJECT);
        return PageConstant.PAGE_ADMIN_PANEL;
    }

    @Override
    public String getPage(HttpServletRequest request) {
        LOGGER.info("The getPage() method is called");
        try {
            request.setAttribute(AttributeConstant.ATTRIBUTE_LIST_SUBJECT,
                    SubjectService.getInstance().readAllSubjects());
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't read all subjects. " + e);
        }
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION,
                PageConstant.PAGE_ADMIN_PANEL_SUBJECTS);
        return PageConstant.PAGE_ADMIN_PANEL;
    }
}

