package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.service.SpecialityService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpecialityCommand implements BaseCommand{
    //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static SpecialityCommand instance = new SpecialityCommand();

    public SpecialityCommand() {
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int specialityId =Integer.valueOf(request.getParameter("specialityId"));
        SpecialityService.getInstance().delete(specialityId);
        request.setAttribute("nav",11);
        return "WEB-INF/jsp/admin/adminPanel.jsp";
    }
    @Override
    public String getPage(HttpServletRequest request) {
        request.setAttribute("listSpeciality", SpecialityService.getInstance().readAll());
        request.setAttribute("nav",13);
        return "WEB-INF/jsp/admin/adminPanel.jsp";

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static SpecialityCommand getInstance() {
        return instance;
    }

}


