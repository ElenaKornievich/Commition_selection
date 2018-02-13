package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.ErrorMassageConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.entity.CTPoint;
import com.kornievich.selectionCommition.entity.Entrant;
import com.kornievich.selectionCommition.entity.User;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationCommand implements BaseCommand {
    static final Logger LOGGER = LogManager.getLogger(RegistrationCommand.class);
    private static RegistrationCommand instance = new RegistrationCommand();

    private RegistrationCommand() {
    }

    public static RegistrationCommand getInstance() {
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
        String page = null;
        String login = request.getParameter(ParameterConstant.PARAMETER_LOGIN);
        String password = request.getParameter(ParameterConstant.PARAMETER_PASSWORD);
        String surname = request.getParameter(ParameterConstant.PARAMETER_SURNAME);
        String firstName = request.getParameter(ParameterConstant.PARAMETER_FIRST_NAME);
        String lastName = request.getParameter(ParameterConstant.PARAMETER_LAST_NAME);
        String pasportSeria = request.getParameter(ParameterConstant.PARAMETER_PASPORT_SERIA);
        int pasportNumber = Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_PASPORT_NOMER));
        String dataOfIssue = request.getParameter(ParameterConstant.PARAMETER_DATA_OF_ISSUE);
        String identificationNumber = request.getParameter(ParameterConstant.PARAMETER_IDENTIFICATION_NUMBER);
        String dataOfBirth = request.getParameter(ParameterConstant.PARAMETER_DATA_OF_BIRTH);
        String nationality = request.getParameter(ParameterConstant.PARAMETER_NATIONALITY);
        String residenceAddress = request.getParameter(ParameterConstant.PARAMETER_RESIDENCE_ADDRESS);
        double score = Double.valueOf(request.getParameter(ParameterConstant.PARAMETER_SCORE));
        boolean goldMedal = Boolean.valueOf(request.getParameter(ParameterConstant.PARAMETER_GOLD_MEDAL));
        String email = request.getParameter(ParameterConstant.PARAMETER_EMAIL);
        String telephoneNumber = request.getParameter(ParameterConstant.PARAMETER_TELEPHONE_NUMBER);
        int subjectOne = Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SUBJECT_ONE_ID));
        int subjectTwo = Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SUBJECT_TWO_ID));
        int subjectThree = Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SUBJECT_THREE_ID));
        int subjectOneValue = Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SUBJECT_ONE_VALUE));
        int subjectTwoValue = Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SUBJECT_TWO_VALUE));
        int subjectThreeValue = Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SUBJECT_THREE_VALUE));
        try {
            User user = RegistrationService.getInstance().registrationEntrant(login, password, pasportSeria,
                    pasportNumber, surname, firstName, lastName, dataOfIssue, identificationNumber,
                    dataOfBirth, nationality, telephoneNumber, residenceAddress, score, goldMedal, email);
            if (user != null) {
                request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_USER, user.getLogin());
                request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_ID, user.getId());
                request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_ROLE,
                        AttributeConstant.ATTRIBUTE_ENTRANT);
                request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_SPECIALITIES,
                        SpecialityService.getInstance().readAllSpecialities());
                Entrant entrant = EntrantService.getInstance().findEntrantById(user.getId());
                CTPointService.getInstance().createCTPoint(new CTPoint(entrant.getId(), subjectOne, subjectOneValue));
                CTPointService.getInstance().createCTPoint(new CTPoint(entrant.getId(), subjectTwo, subjectTwoValue));
                CTPointService.getInstance().createCTPoint(new CTPoint(entrant.getId(), subjectThree, subjectThreeValue));
                request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION, PageConstant.PAGE_PERSONAL_AREA_CHANGE_SPECIALITY);
                page = PageConstant.PAGE_PERSONAL_AREA;
            } else {
                request.setAttribute(AttributeConstant.ATTRIBUTE_ERROR_MASSAGE,
                        ErrorMassageConstant.REGISTRATION_ERROR);
                page = PageConstant.PAGE_ERROR;
            }
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't registration entrant with such input value. " + e);
        }
        return page;
    }

    @Override
    public String getPage(HttpServletRequest request) {
        LOGGER.info("The getPage() method is called");
        try {
            request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_SUBJECTS,
                    SubjectService.getInstance().readAllSubjects());
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't read all subjects. " + e);
        }
        return PageConstant.PAGE_REGISTRATION;
    }
}

