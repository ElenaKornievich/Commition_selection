package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
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

    ;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int subjectId =Integer.valueOf(request.getParameter("subjectId"));
        String subjectName = request.getParameter("subjectName");
        SubjectService.getInstance().updateSubjectName(new Subject(subjectId, subjectName));

        return "WEB-INF/jsp/admin/adminPanel.jsp";
    }
    @Override
    public String getPage(HttpServletRequest request) {
        request.setAttribute("nav",10);
        return "WEB-INF/jsp/jsp/adminPanel.jsp";

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static ChangeSubjectCommand getInstance() {
        return instance;
    }

}
