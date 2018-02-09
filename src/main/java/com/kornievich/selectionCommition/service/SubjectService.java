package com.kornievich.selectionCommition.service;

import com.kornievich.selectionCommition.dao.impl.SubjectDAO;
import com.kornievich.selectionCommition.entity.Subject;
import com.kornievich.selectionCommition.exception.DAOException;

import java.util.ArrayList;

public class SubjectService {
    // private static Logger logger = Logger.getLogger(UserService.class);

    private static SubjectService instance;
    private SubjectDAO subjectDAO;
    private SubjectService() {
        subjectDAO =new SubjectDAO();

    }


    public static SubjectService getInstance() {
        if(instance==null){
            instance = new SubjectService();
        }
        return instance;
    }


    public Subject createSubject(String name) throws DAOException {
        return subjectDAO.createSubject(name);
    }
    public ArrayList<Subject> readAllSubjects() throws DAOException {
        return subjectDAO.readAllSubjects();
    }
    public boolean updateSubjectName(Subject subject) throws DAOException {
        return subjectDAO.updateSubjectName(subject);
    }
    public boolean updateSubjectId(Subject subject) throws DAOException {
        return subjectDAO.updateSubjectId(subject);
    }
    public boolean deleteSubject(int subjectId) throws DAOException {
        return subjectDAO.deleteSubject(subjectId);
    }
    public Subject findSubjectById(int id) throws DAOException {
        return subjectDAO.findSubjectById(id);
    }
    public Subject findSubjectByName(String name) throws DAOException {
        return subjectDAO.findSubjectByName(name);
    }


}
