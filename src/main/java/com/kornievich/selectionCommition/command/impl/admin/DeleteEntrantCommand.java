package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.dao.impl.EntrantDAO;
import com.kornievich.selectionCommition.service.EntrantService;
import com.kornievich.selectionCommition.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument;

public class DeleteEntrantCommand implements BaseCommand {
    //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static DeleteEntrantCommand instance = new DeleteEntrantCommand();

    public DeleteEntrantCommand() {
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
       // EntrantDAO entrantDAO=new EntrantDAO();
        int idEntrant =Integer.parseInt(request.getParameter(ParameterConstant.PARAMETER_ID_ENTRANT));
        System.out.println(idEntrant);

       // entrantDAO.delete(idEntrant);
        UserService.getInstance().delete(idEntrant);
        EntrantService.getInstance().delete(idEntrant);
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION, 1);
        return PageConstant.PAGE_ADMIN_PANEL;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        // EntrantDAO entrantDAO=new EntrantDAO();
        int idEntrant =Integer.parseInt(request.getParameter(ParameterConstant.PARAMETER_ID_ENTRANT));
        System.out.println(idEntrant);

        // entrantDAO.delete(idEntrant);
        UserService.getInstance().delete(idEntrant);
        EntrantService.getInstance().delete(idEntrant);
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION, 1);
        return PageConstant.PAGE_ADMIN_PANEL;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static DeleteEntrantCommand getInstance() {
        return instance;
    }

}

