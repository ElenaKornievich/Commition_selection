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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateFacultyCommand implements BaseCommand {
    //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static CreateFacultyCommand instance = new CreateFacultyCommand();

    public CreateFacultyCommand() {
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int subjectOneId =Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SUBJECT_ONE_ID));
        int subjectTwoId = Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SUBJECT_TWO_ID));
        int subjectThreeId = Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SUBJECT_THREE_ID));
        String name= request.getParameter(ParameterConstant.PARAMETER_NAME_FACULTY);
        String startDate = request.getParameter(ParameterConstant.PARAMETER_START_DATE_FOR_SUBMISSION_OF_DOCUMENTS);
        String endDate = request.getParameter(ParameterConstant.PARAMETER_END_DATE_FOR_SUBMISSION_OF_DOCUMENTS);
        if(FacultyService.getInstance().findFacultyByName(name)!=null) { return PageConstant.PAGE_ERROR;}
            Faculty faculty = FacultyService.getInstance().create(name, startDate, endDate);
            FacultySubjectsService.getInstance().create(new FacultySubject(faculty.getId(), subjectOneId));
            FacultySubjectsService.getInstance().create(new FacultySubject(faculty.getId(), subjectTwoId));
            FacultySubjectsService.getInstance().create(new FacultySubject(faculty.getId(), subjectThreeId));
            return PageConstant.PAGE_ADMIN_PANEL;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        SubjectDAO subjectDAO=new SubjectDAO();
        request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_SUBJECTS,subjectDAO.readAll());
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION, 6);
        return PageConstant.PAGE_ADMIN_PANEL;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static CreateFacultyCommand getInstance() {
        return instance;
    }

}

