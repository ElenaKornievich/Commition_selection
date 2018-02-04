package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.command.Roles;
import com.kornievich.selectionCommition.dao.impl.UserDAO;
import com.kornievich.selectionCommition.entity.User;
import com.kornievich.selectionCommition.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class FacultyCommand implements BaseCommand {
    //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static FacultyCommand instance = new FacultyCommand();

    public FacultyCommand() {
    }

    ;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
       return null;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        return "WEB-INF/jsp/changeFaculty.jsp";

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static FacultyCommand getInstance() {
        return instance;
    }

}
