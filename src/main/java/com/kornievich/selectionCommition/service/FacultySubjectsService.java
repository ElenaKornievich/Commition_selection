package com.kornievich.selectionCommition.service;

import com.kornievich.selectionCommition.dao.impl.EntrantDAO;
import com.kornievich.selectionCommition.dao.impl.FacultySubjectDAO;
import com.kornievich.selectionCommition.dao.impl.UserDAO;
import com.kornievich.selectionCommition.entity.Entrant;
import com.kornievich.selectionCommition.entity.FacultySubject;
import com.kornievich.selectionCommition.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class FacultySubjectsService {
    // private static Logger logger = Logger.getLogger(UserService.class);

    //  private IUserDAO dao;
    private static FacultySubjectsService instance = new FacultySubjectsService();
    FacultySubjectDAO facultySubjectDAO;

    private FacultySubjectsService() {
        facultySubjectDAO = new FacultySubjectDAO();
    }

    public static FacultySubjectsService getInstance() {
        return instance;
    }

    public boolean create(FacultySubject facultySubject) {
        return facultySubjectDAO.create(facultySubject);
    }

    public ArrayList<FacultySubject> readAll() {
        return facultySubjectDAO.readAll();
    }

    public FacultySubject delete(FacultySubject facultySubject) {
        return facultySubjectDAO.delete(facultySubject);
    }

    public ArrayList<FacultySubject> findByFacultyId(int id) {
        return facultySubjectDAO.findByFacultyId(id);
    }

    public ArrayList<FacultySubject> findBySubjectId(int id) {
        return facultySubjectDAO.findBySubjectId(id);
    }

    public boolean update(FacultySubject facultySubject) {
        return facultySubjectDAO.update(facultySubject);
    }

}
