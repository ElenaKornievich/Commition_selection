package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.dao.impl.SubjectDAO;
import com.kornievich.selectionCommition.entity.Faculty;
import com.kornievich.selectionCommition.entity.FacultySubject;
import com.kornievich.selectionCommition.service.FacultyService;
import com.kornievich.selectionCommition.service.FacultySubjectsService;
import com.kornievich.selectionCommition.service.SubjectService;
import sun.nio.cs.ext.PCK;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateSubjectCommand implements BaseCommand {
    //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static CreateSubjectCommand instance = new CreateSubjectCommand();

    public CreateSubjectCommand() {
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String nameSubject= request.getParameter(ParameterConstant.PARAMETER_SUBJECT_NAME);
        if(SubjectService.getInstance().findSubjectByName(nameSubject)!=null){
            return PageConstant.PAGE_ERROR;
        }
        SubjectService.getInstance().create(nameSubject);
        return PageConstant.PAGE_ADMIN_PANEL;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        SubjectDAO subjectDAO=new SubjectDAO();
        request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_SUBJECTS,subjectDAO.readAll());
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
