package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.command.impl.common.FacultyCommand;
import com.kornievich.selectionCommition.dao.impl.EntrantDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteEntrantCommand implements BaseCommand {
    //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static DeleteEntrantCommand instance = new DeleteEntrantCommand();

    public DeleteEntrantCommand() {
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        EntrantDAO entrantDAO=new EntrantDAO();
        int idEntrant =Integer.parseInt(request.getParameter("idEntrant"));
        System.out.println(idEntrant);
        entrantDAO.delete(idEntrant);
        return "WEB-INF/jsp/admin/adminPanel.jsp";
    }
    @Override
    public String getPage(HttpServletRequest request) {
        return "WEB-INF/jsp/changeFaculty.jsp";

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static DeleteEntrantCommand getInstance() {
        return instance;
    }

}

