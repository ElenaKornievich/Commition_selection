package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.entity.FacultySubject;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class FacultyInformationCommand implements BaseCommand {

    static final Logger LOGGER = LogManager.getLogger(FacultyInformationCommand.class);

    private static FacultyInformationCommand instance = new FacultyInformationCommand();

    private FacultyInformationCommand() {
    }

    public static FacultyInformationCommand getInstance() {
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
        return null;
    }

    @Override
    public String getPage(HttpServletRequest request) {
        LOGGER.info("The getPage() method is called");
        int facultyId = Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_FACULTY_ID));
        System.out.println(facultyId + " kfkf");
        try {
            ArrayList<FacultySubject> facultySubject =
                    FacultySubjectsService.getInstance().findFacultySubjectsByFacultyId(facultyId);
            ArrayList<String> facultySubjectName = new ArrayList<>();
            for (FacultySubject var : facultySubject) {
                facultySubjectName.add(SubjectService.getInstance()
                        .findSubjectById(var.getSubjectId()).getName());
            }
            request.setAttribute("facultySubjectName", facultySubjectName);
            request.setAttribute("listSubjects", SpecialityService.getInstance()
                    .findSpecialityByFacultyId(facultyId));
            request.setAttribute(AttributeConstant.ATTRIBUTE_FACULTY,
                    FacultyService.getInstance().findFacultyById(facultyId));
        } catch (DAOException e) {
            e.printStackTrace();
        }
        try {
            request.setAttribute(AttributeConstant.ATTRIBUTE_LIST_ADMIN,
                    AdminService.getInstance().readAllAdmins());
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't read all admins. " + e);
        }
        return "jsp/facultyInformation.jsp";
    }
}