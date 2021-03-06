package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.entity.Entrant;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.service.CTPointService;
import com.kornievich.selectionCommition.service.EntrantService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ChangeEntrantCommand implements BaseCommand {

    static final Logger LOGGER = LogManager.getLogger(ChangeEntrantCommand.class);

    private static ChangeEntrantCommand instance = new ChangeEntrantCommand();

    private ChangeEntrantCommand() {
    }

    public static ChangeEntrantCommand getInstance() {
        return instance;
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION, PageConstant.PAGE_ADMIN_PANEL_CHANGE_ENTRANT);
        return PageConstant.PAGE_ADMIN_PANEL;
    }

    @Override
    public String getPage(HttpServletRequest request) {
        LOGGER.info("The getPage() method is called");
        int idEntrant = Integer.parseInt(request.getParameter(ParameterConstant.PARAMETER_CHANGE_ENTRANT));
        try {
            ArrayList<Entrant> entrants = EntrantService.getInstance().readAllEntrants();
            request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_ENTRANTS, entrants);
            request.setAttribute(AttributeConstant.ATTRIBUTE_CTPOINT_ENTRANT, CTPointService.getInstance().findCTPointByEntrantId(idEntrant));
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't read all entrants. " + e);
        }
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION, PageConstant.PAGE_ADMIN_PANEL_POINT_CT_ENTRANT);
        return PageConstant.PAGE_ADMIN_PANEL;

    }
}
