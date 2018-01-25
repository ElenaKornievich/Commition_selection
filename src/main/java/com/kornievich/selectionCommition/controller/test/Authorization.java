package com.kornievich.selectionCommition.controller.test;

import com.kornievich.selectionCommition.dao.impl.UserDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

@WebServlet(name = "authorization", urlPatterns = "/authorization")
public class Authorization extends HttpServlet {
    public Authorization() {
        super();
    }

    public void init() throws ServletException {
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/authorization.jsp").forward(request, response);
        // ServletContext context = request.getServletContext();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();

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