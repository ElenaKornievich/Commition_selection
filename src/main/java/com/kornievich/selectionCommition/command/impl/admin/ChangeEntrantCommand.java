package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.dao.impl.CTPointDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeEntrantCommand implements BaseCommand{ //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static ChangeEntrantCommand instance = new ChangeEntrantCommand();

    public ChangeEntrantCommand() {
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("nav", 1);
        return "jsp/admin/adminPanel.jsp";
    }
    @Override
    public String getPage(HttpServletRequest request) {

        int idEntrant =Integer.parseInt(request.getParameter("changeEntrantParam"));
        CTPointDAO ctPointDAO=new CTPointDAO();
        request.setAttribute("ctpointEntrant", ctPointDAO.findCTPointByEntrantId(idEntrant));
        request.setAttribute("nav", 4);
        return "jsp/admin/adminPanel.jsp";

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static ChangeEntrantCommand getInstance() {
        return instance;
    }

}
