package com.kornievich.selectionCommition.command.impl.entrant;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.dao.impl.EntrantDAO;
import com.kornievich.selectionCommition.entity.Entrant;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.service.EntrantService;
import com.kornievich.selectionCommition.service.SpecialityService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeCommand implements BaseCommand {

    private static final Logger LOGGER = LogManager.getLogger(ChangeCommand.class);

    private static ChangeCommand instance = new ChangeCommand();

    private ChangeCommand() {}

    public static ChangeCommand getInstance() {
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
        String surname = request.getParameter(ParameterConstant.PARAMETER_SURNAME);
        String firstName = request.getParameter(ParameterConstant.PARAMETER_FIRST_NAME);
        String lastName = request.getParameter(ParameterConstant.PARAMETER_LAST_NAME);
        String pasportSeria = request.getParameter(ParameterConstant.PARAMETER_PASPORT_SERIA);
        int pasportNumber = Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_PASPORT_NOMER));
        String dataOfIssue = request.getParameter(ParameterConstant.PARAMETER_DATE_OF_ISSUE);
        String identificationNumber = request.getParameter(ParameterConstant.PARAMETER_IDENTIFICATION_NUMBER);
        String dataOfBirth = request.getParameter(ParameterConstant.PARAMETER_DATE_OF_BIRTH);
        String nationality = request.getParameter(ParameterConstant.PARAMETER_NATIONALITY);
        String residenceAddress = request.getParameter(ParameterConstant.PARAMETER_RESIDENCE_ADDRESS);
        double scope = Double.valueOf(request.getParameter(ParameterConstant.PARAMETER_SCOPE));
        boolean goldMedal = Boolean.valueOf(request.getParameter(ParameterConstant.PARAMETER_GOLD_MEDAL));
        String email = request.getParameter(ParameterConstant.PARAMETER_EMAIL);
        String telephoneNumber = request.getParameter(ParameterConstant.PARAMETER_TELEPHONE_NUMBER);
        int specialityId = Integer.parseInt(request.getParameter(ParameterConstant.PARAMETER_SPECIALITY_ID));
        Entrant entrant = new Entrant((Integer) request.getSession().getAttribute(ParameterConstant.PARAMETER_ID), "2018-11-11", specialityId, pasportSeria, pasportNumber, surname, firstName, lastName, dataOfIssue, identificationNumber, dataOfBirth, nationality, telephoneNumber, residenceAddress, scope, goldMedal, email);
        EntrantDAO entrantDAO = new EntrantDAO();
        try {
            entrantDAO.updateEntrant(entrant);
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't update entrant with such input value. " + e);
        }
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION,
                PageConstant.PAGE_PERSONAL_ARER_COMMON);
        return PageConstant.PAGE_PERSONAL_AREA;
    }

    @Override
    public String getPage(HttpServletRequest request) {
        LOGGER.info("The getPage() method is called");
        int entrantId = (int) request.getSession().getAttribute(AttributeConstant.ATTRIBUTE_ID);
        System.out.println(entrantId + "jjjjj");
        try {
            request.setAttribute(AttributeConstant.ATTRIBUTE_ENTRANT,
                    EntrantService.getInstance().findEntrantById(entrantId));
        } catch (DAOException e) {
            e.printStackTrace();
        }
        try {
            request.setAttribute(AttributeConstant.ATTRIBUTE_SPECIALITIES,
                    SpecialityService.getInstance().readAllSpecialities());
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't read all specialities. " + e);
        }
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION,
                PageConstant.PAGE_PERSONAL_AREA_CHANGE_PERSONAL_INFORMATION);
        return PageConstant.PAGE_PERSONAL_AREA;
    }
}
