package com.kornievich.selectionCommition.controller.test;

import com.kornievich.selectionCommition.dao.Database;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/addUser")
public class AddUser extends HttpServlet {
    public AddUser() {
        super();
    }

    public void init() throws ServletException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        ServletContext context = request.getServletContext();
        request.getRequestDispatcher("/WEB-INF/jsp/registration.jsp").forward(request, response);


        // response.setContentType("text/html");
        // response.getWriter().print("This is " + this.getClass().getName()
        //         + ", using the GET method");
        // response.getWriter().print("Alena kakashka");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //request.getRequestDispatcher("/WEB-INF/jsp/registration.jsp").forward(request, response);
        //response.get
        response.setContentType("text/html");
        response.getWriter().print("This is " + this.getClass().getName()
                + ", using the POST method");

        try {
            addUser("name","12322","entrant");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    protected void addUser(String login, String password, String role) throws SQLException {
        Database.getInstance().getConnection().createStatement().execute("INSERT `user` VALUE (10, login, password, role);");
        Database.getInstance().getConnection().close();
    }

    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
    }
}

