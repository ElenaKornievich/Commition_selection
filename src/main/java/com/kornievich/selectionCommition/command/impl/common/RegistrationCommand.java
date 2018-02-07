package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
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
        String login = request.getParameter(ParameterConstant.PARAMETER_LOGIN);
        String password = request.getParameter(ParameterConstant.PARAMETER_PASSWORD);
        String surname=request.getParameter(ParameterConstant.PARAMETER_SURNAME);
        String firstName=request.getParameter(ParameterConstant.PARAMETER_FIRST_NAME);
        String lastName=request.getParameter(ParameterConstant.PARAMETER_LAST_NAME);
        String pasportSeria=request.getParameter(ParameterConstant.PARAMETER_PASPORT_SERIA);
        int pasportNumber=Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_PASPORT_NOMER));
        String dataOfIssue=request.getParameter(ParameterConstant.PARAMETER_DATA_OF_ISSUE);
        String identificationNumber = request.getParameter(ParameterConstant.PARAMETER_IDENTIFICATION_NUMBER);
        String dataOfBirth = request.getParameter(ParameterConstant.PARAMETER_DATA_OF_BIRTH);
        String nationality = request.getParameter(ParameterConstant.PARAMETER_NATIONALITY);
        String residenceAddress = request.getParameter(ParameterConstant.PARAMETER_RESIDENCE_ADDRESS);
        double scope =Double.valueOf(request.getParameter(ParameterConstant.PARAMETER_SCOPE));
        boolean goldMedal =Boolean.valueOf(request.getParameter(ParameterConstant.PARAMETER_GOLD_MEDAL));
        String email = request.getParameter(ParameterConstant.PARAMETER_EMAIL);
        String telephoneNumber = request.getParameter(ParameterConstant.PARAMETER_TELEPHONE_NUMBER);
        int subjectOne =Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SUBJECT_ONE_ID));
        int subjectTwo = Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SUBJECT_TWO_ID));
        int subjectThree = Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SUBJECT_THREE_ID));
        int subjectOneValue =Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SUBJECT_ONE_VALUE));
        int subjectTwoValue = Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SUBJECT_TWO_VALUE));
        int subjectThreeValue = Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SUBJECT_THREE_VALUE));
        try {
           // User user = new User(login, password, Roles.ENTRANT);
            User user = UserService.getInstance().addUser(login, password, pasportSeria,
                    pasportNumber, surname, firstName, lastName, dataOfIssue, identificationNumber,
                    dataOfBirth, nationality, telephoneNumber, residenceAddress, scope, goldMedal, email);
            if (user!=null) {
            request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_USER, user.getLogin());
            request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_ID, user.getId());
            request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_ROLE, AttributeConstant.ATTRIBUTE_ENTRANT);

            SpecialityDAO specialityDAO=new SpecialityDAO();
            request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_SPECIALITIES,specialityDAO.readAll());
            EntrantDAO entrantDAO = new EntrantDAO();
            Entrant entrant=entrantDAO.findEntrantById(user.getId());
            CTPointDAO ctPointDao=new CTPointDAO();
            ctPointDao.create(new CTPoint(entrant.getId(),subjectOne, subjectOneValue));
            ctPointDao.create(new CTPoint(entrant.getId(), subjectTwo, subjectTwoValue));
            ctPointDao.create(new CTPoint(entrant.getId(), subjectThree, subjectThreeValue));

                page = PageConstant.PAGE_SELECT_SPECIALITY;
            }
            //  request.getSession().setAttribute("", user);
            else {
                page = PageConstant.PAGE_ERROR;
            }
        } catch (Exception e) {
            System.out.println("что-то не так");
        }return page;
    }

    @Override
    public String getPage(HttpServletRequest request) {
        SubjectDAO subjectDAO=new SubjectDAO();
        request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_SUBJECTS,subjectDAO.readAll());
        return PageConstant.PAGE_REGISTRATION;
    }

    public static RegistrationCommand getInstance() {
        return instance;
    }
}

