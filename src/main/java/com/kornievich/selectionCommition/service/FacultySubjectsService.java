package com.kornievich.selectionCommition.service;

import com.kornievich.selectionCommition.dao.impl.FacultySubjectDAO;
import com.kornievich.selectionCommition.entity.FacultySubject;
import com.kornievich.selectionCommition.exception.DAOException;

import java.util.ArrayList;

public class FacultySubjectsService {
    // private static Logger logger = Logger.getLogger(UserService.class);

    private static FacultySubjectsService instance;
    private FacultySubjectDAO facultySubjectDAO;

    private FacultySubjectsService() {
        facultySubjectDAO = new FacultySubjectDAO();
    }

    public static FacultySubjectsService getInstance(){
    if(instance==null){
        instance = new FacultySubjectsService();
    }
        return instance;
    }

    public boolean createFacultySubject(FacultySubject facultySubject) throws DAOException {
        return facultySubjectDAO.createFacultySubject(facultySubject);
    }

    public ArrayList<FacultySubject> readAllFacultySubjects() throws DAOException {
        return facultySubjectDAO.readAllFacultySubject();
    }

    public FacultySubject deleteFacultySubject(FacultySubject facultySubject) throws DAOException {
        return facultySubjectDAO.deleteFacultySubject(facultySubject);
    }

    public ArrayList<FacultySubject> findFacultySubjectsByFacultyId(int id) throws DAOException {
        return facultySubjectDAO.findFacultySubjectsByFacultyId(id);
    }

    public ArrayList<FacultySubject> findFacultySubjectsBySubjectId(int id) throws DAOException {
        return facultySubjectDAO.findFacultySubjectsBySubjectId(id);
    }

    public boolean updateFacultySubjects(FacultySubject facultySubject) throws DAOException {
        return facultySubjectDAO.updateFacultySubject(facultySubject);
    }

}
