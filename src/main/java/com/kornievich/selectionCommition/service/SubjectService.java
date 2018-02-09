package com.kornievich.selectionCommition.service;

import com.kornievich.selectionCommition.dao.impl.SubjectDAO;
import com.kornievich.selectionCommition.entity.Subject;
import com.kornievich.selectionCommition.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class SubjectService {
    static final Logger LOGGER = LogManager.getLogger(SubjectService.class);
    private static SubjectService instance;
    private SubjectDAO subjectDAO;
    private SubjectService() {
        subjectDAO =new SubjectDAO();

    }


    public static SubjectService getInstance() {
        LOGGER.info("The getInstance() method is called");
        if(instance==null){
            instance = new SubjectService();
        }
        return instance;
    }


    public Subject createSubject(String name) throws DAOException {
        LOGGER.info("The createSubject() method is called");
        return subjectDAO.createSubject(name);
    }
    public ArrayList<Subject> readAllSubjects() throws DAOException {
        LOGGER.info("The readAllSubjects() method is called");
        return subjectDAO.readAllSubjects();
    }
    public boolean updateSubjectName(Subject subject) throws DAOException {
        LOGGER.info("The updateSubjectName() method is called");
        return subjectDAO.updateSubjectName(subject);
    }
    public boolean updateSubjectId(Subject subject) throws DAOException {
        LOGGER.info("The updateSubjectId() method is called");
        return subjectDAO.updateSubjectId(subject);
    }
    public boolean deleteSubject(int subjectId) throws DAOException {
        LOGGER.info("The deleteSubject() method is called");
        return subjectDAO.deleteSubject(subjectId);
    }
    public Subject findSubjectById(int id) throws DAOException {
        LOGGER.info("The findSubjectById() method is called");
        return subjectDAO.findSubjectById(id);
    }
    public Subject findSubjectByName(String name) throws DAOException {
        LOGGER.info("The findSubjectByName() method is called");
        return subjectDAO.findSubjectByName(name);
    }


}
