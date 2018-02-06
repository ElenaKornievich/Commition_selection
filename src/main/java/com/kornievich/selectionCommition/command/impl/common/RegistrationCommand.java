package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.dao.impl.CTPointDAO;
import com.kornievich.selectionCommition.dao.impl.EntrantDAO;
import com.kornievich.selectionCommition.dao.impl.SpecialityDAO;
import com.kornievich.selectionCommition.dao.impl.SubjectDAO;
import com.kornievich.selectionCommition.entity.CTPoint;
import com.kornievich.selectionCommition.entity.Entrant;
import com.kornievich.selectionCommition.entity.User;
import com.kornievich.selectionCommition.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationCommand implements BaseCommand {
    private static RegistrationCommand instance = new RegistrationCommand();

    private RegistrationCommand() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
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
        int subjectOne =Integer.valueOf(request.getParameter("subjectOneId"));
        int subjectTwo = Integer.valueOf(request.getParameter("subjectTwoId"));
        int subjectThree = Integer.valueOf(request.getParameter("subjectThreeId"));
        int subjectOneValue =Integer.valueOf(request.getParameter("subjectOneValue"));
        int subjectTwoValue = Integer.valueOf(request.getParameter("subjectTwoValue"));
        int subjectThreeValue = Integer.valueOf(request.getParameter("subjectThreeValue"));
        try {
           // User user = new User(login, password, Roles.ENTRANT);
            User user = UserService.getInstance().addUser(login, password, pasportSeria,
                    pasportNumber, surname, firstName, lastName, dataOfIssue, identificationNumber,
                    dataOfBirth, nationality, telephoneNumber, residenceAddress, scope, goldMedal, email);

            request.getSession().setAttribute("user", user.getLogin());
            request.getSession().setAttribute("id", user.getId());
            request.getSession().setAttribute("role", "entrant");

            SpecialityDAO specialityDAO=new SpecialityDAO();
            request.getSession().setAttribute("specialities",specialityDAO.readAll());
            EntrantDAO entrantDAO = new EntrantDAO();
            Entrant entrant=entrantDAO.findEntrantById(user.getId());
            CTPointDAO ctPointDao=new CTPointDAO();
            ctPointDao.create(new CTPoint(entrant.getId(),subjectOne, subjectOneValue));
            ctPointDao.create(new CTPoint(entrant.getId(), subjectTwo, subjectTwoValue));
            ctPointDao.create(new CTPoint(entrant.getId(), subjectThree, subjectThreeValue));
            if (user!=null) {
                page = "jsp/entrant/selectSpeciality.jsp";
            }
            //  request.getSession().setAttribute("", user);
            else {
                page = "error/error.jsp";
            }
        } catch (Exception e) {
            System.out.println("что-то не так");
        }return page;
    }

    @Override
    public String getPage(HttpServletRequest request) {
        SubjectDAO subjectDAO=new SubjectDAO();
        request.getSession().setAttribute("subjects",subjectDAO.readAll());
        return "jsp/registration.jsp";
    }

    public static RegistrationCommand getInstance() {
        return instance;
    }
}

