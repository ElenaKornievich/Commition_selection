package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.entity.Speciality;
import com.kornievich.selectionCommition.entity.Subject;
import com.kornievich.selectionCommition.service.SpecialityService;
import com.kornievich.selectionCommition.service.SubjectService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeSpecialityCommand implements BaseCommand {
    //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static ChangeSpecialityCommand instance = new ChangeSpecialityCommand();

    public ChangeSpecialityCommand() {
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int specialityId =Integer.valueOf(request.getParameter("specialityId"));
        String specialityName = request.getParameter("specialityName");
        int facultyId =Integer.valueOf(request.getParameter("facultyId"));
        int numberOfBudgetPlaces =Integer.valueOf(request.getParameter("numberOfBudgetPlaces"));
        int numberOfPaidPlaces =Integer.valueOf(request.getParameter("numberOfPaidPlaces"));
        SpecialityService.getInstance().update(new Speciality(specialityId, specialityName, facultyId, numberOfBudgetPlaces,numberOfPaidPlaces));
        return "WEB-INF/jsp/admin/adminPanel.jsp";
    }
    @Override
    public String getPage(HttpServletRequest request) {
        int specialityId =Integer.valueOf(request.getParameter("specialityId"));
        System.out.println(specialityId);
        request.setAttribute("nav",11);
        Speciality speciality = SpecialityService.getInstance().findSpecialityById(specialityId);
        request.setAttribute("speciality", speciality);
        return "WEB-INF/jsp/admin/adminPanel.jsp";

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static ChangeSpecialityCommand getInstance() {
        return instance;
    }

}
