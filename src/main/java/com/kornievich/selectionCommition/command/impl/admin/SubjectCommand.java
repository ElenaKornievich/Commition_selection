package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.service.SubjectService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubjectCommand implements BaseCommand
{  //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static SubjectCommand instance = new SubjectCommand();

    public SubjectCommand() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int subjectId =Integer.valueOf(request.getParameter("subjectId"));
        SubjectService.getInstance().delete(subjectId);
        request.setAttribute("nav",10);
        return "jsp/admin/adminPanel.jsp";
    }
    @Override
    public String getPage(HttpServletRequest request) {
        request.setAttribute("listSubject", SubjectService.getInstance().readAll());
        request.setAttribute("nav",14);
        return "jsp/admin/adminPanel.jsp";

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static SubjectCommand getInstance() {
        return instance;
    }

}

