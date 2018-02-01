package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.dao.impl.EntrantDAO;
import com.kornievich.selectionCommition.dao.impl.SpecialityDAO;
import com.kornievich.selectionCommition.entity.Entrant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeCommand  implements BaseCommand{//  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static ChangeCommand instance = new ChangeCommand();

    public ChangeCommand() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String surname=request.getParameter("surname");
        String firstName=request.getParameter("firstName");
        String lastName=request.getParameter("lastName");
        String pasportSeria=request.getParameter("pasportSeria");
        int pasportNumber=Integer.valueOf(request.getParameter("pasportNomer"));
        String dataOfIssue=request.getParameter("dataOfIssue");
        String identificationNumber = request.getParameter("identificationNumber");
        String dataOfBirth = request.getParameter("dataOfBirth");
        String nationality = request.getParameter("nationality");
        String residenceAddress = request.getParameter("residenceAddress");
        double scope =Double.valueOf(request.getParameter("scope"));
        boolean goldMedal =Boolean.valueOf(request.getParameter("goldMedal"));
        String email = request.getParameter("email");
        String telephoneNumber = request.getParameter("telephoneNumber");
        String specialityName = request.getParameter("specialityName");
        SpecialityDAO specialityDAO= new SpecialityDAO();
        int specialityId = specialityDAO.findSpecialityByName(specialityName).getId();
        Entrant entrant = new Entrant((Integer)request.getSession().getAttribute("id"), "2018-11-11", specialityId, pasportSeria, pasportNumber, surname, firstName, lastName, dataOfIssue, identificationNumber, dataOfBirth, nationality, telephoneNumber, residenceAddress, scope, goldMedal, email);
        EntrantDAO entrantDAO = new EntrantDAO();
        entrantDAO.update(entrant);

        request.setAttribute("nav", 0);
        return "WEB-INF/jsp/entrant/personalArea.jsp";
    }
    @Override
    public String getPage(HttpServletRequest request) {

        request.setAttribute("nav", 1);
        return "WEB-INF/jsp/entrant/personalArea.jsp";

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static ChangeCommand getInstance() {
        return instance;
    }

}
