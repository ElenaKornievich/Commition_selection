package com.kornievich.selectionCommition.service;

import com.kornievich.selectionCommition.dao.impl.FacultySubjectDAO;
import com.kornievich.selectionCommition.entity.FacultySubject;
import com.kornievich.selectionCommition.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class FacultySubjectsService {
    static final Logger LOGGER = LogManager.getLogger(FacultySubjectsService.class);
    private static FacultySubjectsService instance;
    private FacultySubjectDAO facultySubjectDAO;

    private FacultySubjectsService() {
        facultySubjectDAO = new FacultySubjectDAO();
    }

    public static FacultySubjectsService getInstance(){
        LOGGER.info("The getInstance() method is called");
    if(instance==null){
        instance = new FacultySubjectsService();
    }
        return instance;
    }

    public boolean createFacultySubject(FacultySubject facultySubject) throws DAOException {
        LOGGER.info("The createFacultySubject() method is called");
        return facultySubjectDAO.createFacultySubject(facultySubject);
    }

    public ArrayList<FacultySubject> readAllFacultySubjects() throws DAOException {
        LOGGER.info("The readAllFacultySubjects() method is called");
        return facultySubjectDAO.readAllFacultySubject();
    }

    public FacultySubject deleteFacultySubject(FacultySubject facultySubject) throws DAOException {
        LOGGER.info("The deleteFacultySubject() method is called");
        return facultySubjectDAO.deleteFacultySubject(facultySubject);
    }

    public ArrayList<FacultySubject> findFacultySubjectsByFacultyId(int id) throws DAOException {
        LOGGER.info("The findFacultySubjectsByFacultyId() method is called");
        return facultySubjectDAO.findFacultySubjectsByFacultyId(id);
    }

    public ArrayList<FacultySubject> findFacultySubjectsBySubjectId(int id) throws DAOException {
        LOGGER.info("The findFacultySubjectsBySubjectId() method is called");
        return facultySubjectDAO.findFacultySubjectsBySubjectId(id);
    }

    public boolean updateFacultySubjects(FacultySubject facultySubject) throws DAOException {
        LOGGER.info("The updateFacultySubjects() method is called");
        return facultySubjectDAO.updateFacultySubject(facultySubject);
    }

}
