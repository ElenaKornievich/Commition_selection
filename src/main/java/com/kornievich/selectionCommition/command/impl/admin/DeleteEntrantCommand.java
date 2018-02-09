package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.service.EntrantService;
import com.kornievich.selectionCommition.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteEntrantCommand implements BaseCommand {
    static final Logger LOGGER = LogManager.getLogger(DeleteEntrantCommand.class);

    private static DeleteEntrantCommand instance = new DeleteEntrantCommand();

    private DeleteEntrantCommand() {
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
        int idEntrant =Integer.parseInt(request.getParameter(ParameterConstant.PARAMETER_ID_ENTRANT));
        System.out.println(idEntrant);
        try {
            UserService.getInstance().deleteUser(idEntrant);
        EntrantService.getInstance().deleteEntrant(idEntrant);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION, 1);
        return PageConstant.PAGE_ADMIN_PANEL;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        LOGGER.info("The getPage() method is called");
        int idEntrant =Integer.parseInt(request.getParameter(ParameterConstant.PARAMETER_ID_ENTRANT));
        System.out.println(idEntrant);
        try {
            UserService.getInstance().deleteUser(idEntrant);
        EntrantService.getInstance().deleteEntrant(idEntrant);
        } catch (DAOException e) {
            e.printStackTrace();
        }
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

