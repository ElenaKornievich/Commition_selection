package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.entity.Faculty;
import com.kornievich.selectionCommition.entity.FacultySubject;
import com.kornievich.selectionCommition.entity.Subject;
import com.kornievich.selectionCommition.service.FacultyService;
import com.kornievich.selectionCommition.service.FacultySubjectsService;
import com.kornievich.selectionCommition.service.SubjectService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeSubjectCommand implements BaseCommand {
    //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static ChangeSubjectCommand instance = new ChangeSubjectCommand();

    public ChangeSubjectCommand() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int subjectId =Integer.parseInt(request.getParameter(ParameterConstant.PARAMETER_SUBJECT_ID));
        String subjectName = request.getParameter(ParameterConstant.PARAMETER_SUBJECT_NAME);
        System.out.println(subjectId+subjectName);
        SubjectService.getInstance().updateSubjectName(new Subject(subjectId, subjectName));

        return PageConstant.PAGE_ADMIN_PANEL;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        int subjectId =Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SUBJECT_ID));
        System.out.println(subjectId);
        request.setAttribute(AttributeConstant.ATTRIBUTE_SUBJECT, SubjectService.getInstance().findSubjectById(subjectId));
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

