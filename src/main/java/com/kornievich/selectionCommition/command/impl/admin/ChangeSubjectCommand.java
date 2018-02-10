package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.entity.Subject;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.service.SubjectService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeSubjectCommand implements BaseCommand {
    static final Logger LOGGER = LogManager.getLogger(ChangeSubjectCommand.class);

    private static ChangeSubjectCommand instance = new ChangeSubjectCommand();

    private ChangeSubjectCommand() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
        int subjectId =Integer.parseInt(request.getParameter(ParameterConstant.PARAMETER_SUBJECT_ID));
        String subjectName = request.getParameter(ParameterConstant.PARAMETER_SUBJECT_NAME);
        System.out.println(subjectId+subjectName);
        try {
            SubjectService.getInstance().updateSubjectName(new Subject(subjectId, subjectName));
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't update subject name. "+e);
        }

        return PageConstant.PAGE_ADMIN_PANEL;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        LOGGER.info("The getPage() method is called");
        int subjectId =Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SUBJECT_ID));
        System.out.println(subjectId);
        try {
            request.setAttribute(AttributeConstant.ATTRIBUTE_SUBJECT, SubjectService.getInstance().findSubjectById(subjectId));
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't find subject with such input id. "+e);
        }
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION,10);
        return PageConstant.PAGE_ADMIN_PANEL;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static ChangeSubjectCommand getInstance() {
        return instance;
    }

}

