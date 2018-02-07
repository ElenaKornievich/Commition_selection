package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.service.FacultyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FacultyCommand implements BaseCommand {
//  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static FacultyCommand instance = new FacultyCommand();

    public FacultyCommand() {
    }

    ;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int idFaculty = Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_ID_FACULTY));
        FacultyService.getInstance().delete(idFaculty);
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION,9);
        return PageConstant.PAGE_ADMIN_PANEL;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        request.setAttribute(AttributeConstant.ATTRIBUTE_LIST_FACULTIES,FacultyService.getInstance().readAll());
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION,12);
        return PageConstant.PAGE_ADMIN_PANEL;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static FacultyCommand getInstance() {
        return instance;
    }

}

