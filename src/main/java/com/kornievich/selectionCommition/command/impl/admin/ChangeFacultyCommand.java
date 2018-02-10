package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
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
import java.util.ArrayList;

public class ChangeFacultyCommand implements BaseCommand {

    static final Logger LOGGER = LogManager.getLogger(ChangeFacultyCommand.class);

    private static ChangeFacultyCommand instance = new ChangeFacultyCommand();

    public ChangeFacultyCommand() {
    }

    ;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
        int subjectOneId =Integer.valueOf(request.getParameter("subjectOneId"));
        int subjectTwoId = Integer.valueOf(request.getParameter("subjectTwoId"));
        int subjectThreeId = Integer.valueOf(request.getParameter("subjectThreeId"));
        String name= request.getParameter("nameFaculty");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        int idFaculty = Integer.parseInt(request.getParameter("facultyId"));
        try {
            FacultyService.getInstance().updateFaculty(new Faculty(idFaculty, name, startDate, endDate));
        }catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't update faculty with such input values"+e);
        }
        try{
        FacultySubjectsService.getInstance().updateFacultySubjects(new FacultySubject(idFaculty,subjectOneId));
        FacultySubjectsService.getInstance().updateFacultySubjects(new FacultySubject(idFaculty, subjectTwoId));
        FacultySubjectsService.getInstance().updateFacultySubjects(new FacultySubject(idFaculty, subjectThreeId));
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't update faculty subjects with such input value. "+e);
        }
        return PageConstant.PAGE_ADMIN_PANEL;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        LOGGER.info("The getPage() method is called");
        int facultyId = Integer.parseInt(request.getParameter(ParameterConstant.PARAMETER_FACULTY_ID));

        Faculty faculty= null;
        try {
            faculty = FacultyService.getInstance().findFacultyById(facultyId);
        ArrayList<FacultySubject> subjects =  FacultySubjectsService.getInstance().findFacultySubjectsByFacultyId(facultyId);
        FacultyService.getInstance().updateFaculty(faculty);
        request.setAttribute(AttributeConstant.ATTRIBUTE_FACULTY, faculty);
        request.setAttribute(AttributeConstant.ATTRIBUTE_SUBJECT_ONE, SubjectService.getInstance().findSubjectById(subjects.get(0).getSubjectId()));
        request.setAttribute(AttributeConstant.ATTRIBUTE_SUBJECT_TWO, SubjectService.getInstance().findSubjectById(subjects.get(1).getSubjectId()));
        request.setAttribute(AttributeConstant.ATTRIBUTE_SUBJECT_THREE, SubjectService.getInstance().findSubjectById(subjects.get(2).getSubjectId()));
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION,9);
        SubjectDAO subjectDAO=new SubjectDAO();
        request.getSession().setAttribute(AttributeConstant.ATTRIBUTE_SUBJECTS,subjectDAO.readAllSubjects());
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't find faculty with such input id. "+e);
        }
        return PageConstant.PAGE_ADMIN_PANEL;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static ChangeFacultyCommand getInstance() {
        return instance;
    }

}
