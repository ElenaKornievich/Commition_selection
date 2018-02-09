package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.dao.impl.CTPointDAO;
import com.kornievich.selectionCommition.entity.Entrant;
import com.kornievich.selectionCommition.entity.User;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.service.CTPointService;
import com.kornievich.selectionCommition.service.EntrantService;
import com.kornievich.selectionCommition.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ChangeEntrantCommand implements BaseCommand{ //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static ChangeEntrantCommand instance = new ChangeEntrantCommand();

    public ChangeEntrantCommand() {
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION, 1);
        return PageConstant.PAGE_ADMIN_PANEL;
    }
    @Override
    public String getPage(HttpServletRequest request) {

        int idEntrant =Integer.parseInt(request.getParameter(ParameterConstant.PARAMETER_CHANGE_ENTRANT));
       // CTPointDAO ctPointDAO=new CTPointDAO();
        try {
            ArrayList<Entrant> entrants = EntrantService.getInstance().readAllEntrants();
            request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_ENTRANTS, entrants);

            request.setAttribute(AttributeConstant.ATTRIBUTE_CTPOINT_ENTRANT, CTPointService.getInstance().findCTPointByEntrantId(idEntrant));
        } catch (DAOException e) {
            e.printStackTrace();
        }
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION, 4);
        return PageConstant.PAGE_ADMIN_PANEL;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static ChangeEntrantCommand getInstance() {
        return instance;
    }

}
