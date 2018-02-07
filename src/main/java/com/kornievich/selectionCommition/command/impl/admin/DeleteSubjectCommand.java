package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.entity.Subject;
import com.kornievich.selectionCommition.service.SubjectService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteSubjectCommand implements BaseCommand {
    //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static DeleteSubjectCommand instance = new DeleteSubjectCommand();

    public DeleteSubjectCommand() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int subjectId =Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SUBJECT_ID));
        SubjectService.getInstance().delete(subjectId);
        request.setAttribute(AttributeConstant.ATTRIBUTE_LIST_SUBJECT, SubjectService.getInstance().readAll());
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION,14);
        return PageConstant.PAGE_ADMIN_PANEL;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        request.setAttribute(AttributeConstant.ATTRIBUTE_LIST_SUBJECT, SubjectService.getInstance().readAll());
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION,14);
        return PageConstant.PAGE_ADMIN_PANEL;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static DeleteSubjectCommand getInstance() {
        return instance;
    }

}

