package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.dao.impl.RequestsDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class MMFCommand implements BaseCommand { //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static MMFCommand instance = new MMFCommand();

    public MMFCommand() {
    }

    ;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        RequestsDAO requestsDAO = new RequestsDAO();
        ArrayList<Integer> entrant;
        ArrayList<Integer> allIdSpesiality = requestsDAO.allIdSpesialty();
       // entrant= requestsDAO.allScoreBySpesialty(1);
       // request.setAttribute("entrant", entrant);
      //  request.setAttribute("spesiality", allIdSpesiality);
        return null;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static MMFCommand getInstance() {
        return instance;
    }

}
