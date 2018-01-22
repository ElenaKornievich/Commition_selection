package com.kornievich.selectionCommition.controller.test;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;

@WebServlet("/registration")
public class Registration extends HttpServlet {
    public Registration() {
        super();
    }

    public void init() throws ServletException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = request.getServletContext();
        request.getRequestDispatcher("/WEB-INF/jsp/registration.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        response.setContentType("text/html");
        response.getWriter().print("This is " + this.getClass().getName()
                + ", using the POST method" +login + " " + pass);

        response.getWriter().print("This is ");


    }

    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
    }
}