package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.ErrorMassageConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.dao.impl.SubjectDAO;
import com.kornievich.selectionCommition.entity.Faculty;
import com.kornievich.selectionCommition.entity.FacultySubject;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.service.FacultyService;
import com.kornievich.selectionCommition.service.FacultySubjectsService;
import com.kornievich.selectionCommition.service.SubjectService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateFacultyCommand implements BaseCommand {
    static final Logger LOGGER = LogManager.getLogger(CreateFacultyCommand.class);

    private static CreateFacultyCommand instance = new CreateFacultyCommand();

    public CreateFacultyCommand() {
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
        int subjectOneId = Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SUBJECT_ONE_ID));
        int subjectTwoId = Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SUBJECT_TWO_ID));
        int subjectThreeId = Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SUBJECT_THREE_ID));
        String name = request.getParameter(ParameterConstant.PARAMETER_NAME_FACULTY);
        String startDate = request.getParameter(ParameterConstant.PARAMETER_START_DATE_FOR_SUBMISSION_OF_DOCUMENTS);
        String endDate = request.getParameter(ParameterConstant.PARAMETER_END_DATE_FOR_SUBMISSION_OF_DOCUMENTS);
        try {
            if (FacultyService.getInstance().findFacultyByName(name) != null) {
                request.setAttribute(AttributeConstant.ATTRIBUTE_ERROR_MASSAGE, ErrorMassageConstant.CREATE_FACULTY_ERROR);
                return PageConstant.PAGE_ERROR;
            }
            Faculty faculty = null;
            faculty = FacultyService.getInstance().createFaculty(name, startDate, endDate);
            FacultySubjectsService.getInstance().createFacultySubject(new FacultySubject(faculty.getId(), subjectOneId));
            FacultySubjectsService.getInstance().createFacultySubject(new FacultySubject(faculty.getId(), subjectTwoId));
            FacultySubjectsService.getInstance().createFacultySubject(new FacultySubject(faculty.getId(), subjectThreeId));
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't create faculty with such input value. " + e);
        }
        return PageConstant.PAGE_ADMIN_PANEL;
    }

    @Override
    public String getPage(HttpServletRequest request) {
        LOGGER.info("The getPage() method is called");
        try {
            request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_SUBJECTS, SubjectService.getInstance().readAllSubjects());
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't read all subjects. "+e);
        }
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION, 6);
        return PageConstant.PAGE_ADMIN_PANEL;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static CreateFacultyCommand getInstance() {
        return instance;
    }

}

