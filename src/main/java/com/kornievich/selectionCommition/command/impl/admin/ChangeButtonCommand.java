package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.entity.Entrant;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.service.EntrantService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ChangeButtonCommand implements BaseCommand {

    static final Logger LOGGER = LogManager.getLogger(ChangeButtonCommand.class);

    private static ChangeButtonCommand instance = new ChangeButtonCommand();

    private ChangeButtonCommand() {
    }

    public static ChangeButtonCommand getInstance() {
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
        return null;
    }

    @Override
    public String getPage(HttpServletRequest request) {
        LOGGER.info("The getPage() method is called");
        ArrayList<Entrant> entrants = null;
        try {
            entrants = EntrantService.getInstance().readAllEntrants();
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't read all entrants. " + e);
        }
        request.setAttribute(AttributeConstant.ATTRIBUTE_ENTRANTS, entrants);

        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION, PageConstant.PAGE_ADMIN_PANEL_CHANGE_ENTRANT);
        return PageConstant.PAGE_ADMIN_PANEL;
    }
}
