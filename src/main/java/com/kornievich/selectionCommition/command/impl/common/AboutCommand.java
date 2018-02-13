package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.service.EntrantService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AboutCommand implements BaseCommand {

    static final Logger LOGGER = LogManager.getLogger(AboutCommand.class);

    private static AboutCommand instance = new AboutCommand();

    private AboutCommand() {
    }

    public static AboutCommand getInstance() {
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
        int entrantId = (int) request.getSession().getAttribute(AttributeConstant.ATTRIBUTE_ID);
        try {
            request.setAttribute(AttributeConstant.ATTRIBUTE_ENTRANT,
                    EntrantService.getInstance().findEntrantById(entrantId));
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't find entrant with such input id. " + e);
        }
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION,
                PageConstant.PAGE_PERSONAL_AREA_ENTRANT_PERSONAL_INFORMATION);
        return PageConstant.PAGE_PERSONAL_AREA;
    }
}

