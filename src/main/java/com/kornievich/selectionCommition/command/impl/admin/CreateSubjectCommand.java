package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.ErrorMassageConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.dao.impl.SubjectDAO;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.service.SubjectService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateSubjectCommand implements BaseCommand {
    static final Logger LOGGER = LogManager.getLogger(CreateSubjectCommand.class);

    private static CreateSubjectCommand instance = new CreateSubjectCommand();

    private CreateSubjectCommand() {
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
        String nameSubject= request.getParameter(ParameterConstant.PARAMETER_SUBJECT_NAME);
        try {
            if(SubjectService.getInstance().findSubjectByName(nameSubject)!=null){
                request.setAttribute(AttributeConstant.ATTRIBUTE_ERROR_MASSAGE, ErrorMassageConstant.CREATE_SUBJECT_ERROR);
                return PageConstant.PAGE_ERROR;
            }
        SubjectService.getInstance().createSubject(nameSubject);
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't create subject with such input value. "+e);
        }
        return PageConstant.PAGE_ADMIN_PANEL;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        LOGGER.info("The getPage() method is called");
        try {
            request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_SUBJECTS,SubjectService.getInstance().readAllSubjects());
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't read all subjects. "+e);
        }
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION, 7);
        return PageConstant.PAGE_ADMIN_PANEL;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static CreateSubjectCommand getInstance() {
        return instance;
    }

}
