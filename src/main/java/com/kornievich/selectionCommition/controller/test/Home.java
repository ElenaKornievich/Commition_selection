package com.kornievich.selectionCommition.controller.test;

import com.kornievich.selectionCommition.dao.impl.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "home", urlPatterns = "/home")
public class Home extends HttpServlet{
    public void init() throws ServletException {
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/authorization.jsp").forward(request, response);
        // ServletContext context = request.getServletContext();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.getWriter().print("");
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        response.setContentType("text/html");
        response.getWriter().print("This is " + this.getClass().getName()
                + ", using the POST method" +login + " " + pass);
        UserDAO userDAO =new UserDAO();
        if(userDAO.read(login, pass)!=null)
            request.getRequestDispatcher("WEB-INF/jsp/main.jsp").forward(request,response);
        else request.getRequestDispatcher("WEB-INF/jsp/authorization.jsp").forward(request,response);
        response.getWriter().print("This is ");

    }

    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
    }
}