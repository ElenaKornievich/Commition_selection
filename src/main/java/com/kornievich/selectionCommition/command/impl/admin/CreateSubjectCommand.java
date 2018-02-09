package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.dao.impl.SubjectDAO;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.service.SubjectService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateSubjectCommand implements BaseCommand {
    //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static CreateSubjectCommand instance = new CreateSubjectCommand();

    private CreateSubjectCommand() {
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String nameSubject= request.getParameter(ParameterConstant.PARAMETER_SUBJECT_NAME);
        try {
            if(SubjectService.getInstance().findSubjectByName(nameSubject)!=null){
                return PageConstant.PAGE_ERROR;
            }
        SubjectService.getInstance().createSubject(nameSubject);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return PageConstant.PAGE_ADMIN_PANEL;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        SubjectDAO subjectDAO=new SubjectDAO();
        try {
            request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_SUBJECTS,subjectDAO.readAllSubjects());
        } catch (DAOException e) {
            e.printStackTrace();
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
