package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.dao.impl.EntrantDAO;
import com.kornievich.selectionCommition.dao.impl.SpecialityDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeEntrantSpeciality implements BaseCommand {
    //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static ChangeEntrantSpeciality instance = new ChangeEntrantSpeciality();

    public ChangeEntrantSpeciality() {
    }

    ;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int specialityId=Integer.valueOf(request.getParameter("specialityId"));
        EntrantDAO entrantDAO=new EntrantDAO();
        int entrantId=(Integer) request.getSession().getAttribute("id");
        entrantDAO.changeSpeciality(entrantId, specialityId);
        return "jsp/entrant/personalArea.jsp";
    }
    @Override
    public String getPage(HttpServletRequest request) {
        SpecialityDAO specialityDAO=new SpecialityDAO();
        request.getSession().setAttribute("specialities",specialityDAO.readAll());

        request.setAttribute("nav", 2);
        return "jsp/entrant/personalArea.jsp";

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static ChangeEntrantSpeciality getInstance() {
        return instance;
    }

}


