package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.dao.impl.EntrantDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeSpeciality implements BaseCommand {
    //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static ChangeSpeciality instance = new ChangeSpeciality();

    public ChangeSpeciality() {
    }

    ;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int specialityId=Integer.valueOf(request.getParameter("specialityId"));
        EntrantDAO entrantDAO=new EntrantDAO();
        int entrantId=(Integer) request.getSession().getAttribute("id");
        entrantDAO.changeSpeciality(entrantId, specialityId);
        return "WEB-INF/jsp/entrant/personalArea.jsp";
    }
    @Override
    public String getPage(HttpServletRequest request) {
        request.setAttribute("nav", 2);
        return "WEB-INF/jsp/entrant/personalArea.jsp";

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static ChangeSpeciality getInstance() {
        return instance;
    }

}


