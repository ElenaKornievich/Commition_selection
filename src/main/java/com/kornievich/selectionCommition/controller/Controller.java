package com.kornievich.selectionCommition.controller;

import com.kornievich.selectionCommition.command.BaseCommand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controller", urlPatterns = "/controller")
public class Controller extends HttpServlet {
    public Controller() {
        super();
    }

    public void init() throws ServletException {
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType( "text/html;charset=utf8" );
        CommandFactory commandFactory=new CommandFactory();
        BaseCommand baseCommand= commandFactory.defineCommand(request);
        String page=baseCommand.getPage(request);
        request.getRequestDispatcher(page).forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        HttpSession session;

        CommandFactory commandFactory=new CommandFactory();
        //commandFactory.defineCommand(request);
        BaseCommand baseCommand= commandFactory.defineCommand(request);
        String page= baseCommand.execute(request,response);

        request.getRequestDispatcher(page).forward(request,response);

    }

    public void destroy() {
        super.destroy();
    }
}

