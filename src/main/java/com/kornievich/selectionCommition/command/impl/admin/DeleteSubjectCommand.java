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

public class DeleteSubjectCommand implements BaseCommand {

    static final Logger LOGGER = LogManager.getLogger(DeleteSubjectCommand.class);

    private static DeleteSubjectCommand instance = new DeleteSubjectCommand();

    private DeleteSubjectCommand() {
    }

    public static DeleteSubjectCommand getInstance() {
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
        int subjectId = Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SUBJECT_ID));
        try {
            SubjectService.getInstance().deleteSubject(subjectId);
            request.setAttribute(AttributeConstant.ATTRIBUTE_LIST_SUBJECT,
                    SubjectService.getInstance().readAllSubjects());
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't read all subjects. " + e);
        }
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION, PageConstant.PAGE_ADMIN_PANEL_SUBJECTS);
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
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION, PageConstant.PAGE_ADMIN_PANEL_SUBJECTS);
        return PageConstant.PAGE_ADMIN_PANEL;
    }
}

