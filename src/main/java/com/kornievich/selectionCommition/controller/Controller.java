package com.kornievich.selectionCommition.controller;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.command.impl.common.RegistrationCommand;
import com.kornievich.selectionCommition.exception.CommandException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controller", urlPatterns = "/controller")
public class Controller extends HttpServlet {
    static final Logger LOGGER = LogManager.getLogger(Controller.class);
    public Controller() {
        super();
    }

    public void init() throws ServletException {
        LOGGER.info("The init() method is called");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("The doGet() method is called");
        CommandFactory commandFactory=new CommandFactory();
        BaseCommand baseCommand= commandFactory.defineCommand(request);
        String page=baseCommand.getPage(request);
        request.getRequestDispatcher(page).forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("The doPost() method is called");
        CommandFactory commandFactory=new CommandFactory();
        BaseCommand baseCommand= commandFactory.defineCommand(request);
        String page= null;
        try {
            page = baseCommand.execute(request,response);
        } catch (CommandException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher(page).forward(request,response);

    }

    public void destroy() {
        LOGGER.info("The destroy() method is called");
        super.destroy();
    }
}

