package com.kornievich.selectionCommition.dao;

import com.kornievich.selectionCommition.entity.Subject;
import com.kornievich.selectionCommition.exception.DAOException;

import java.util.ArrayList;

public interface ISubjectDAO {
    Subject createSubject(String name) throws DAOException;
    ArrayList<Subject> readAllSubjects() throws DAOException;
    boolean updateSubjectName(Subject subject) throws DAOException;
    boolean updateSubjectId(Subject subject) throws DAOException;
    boolean deleteSubject(int subjectId) throws DAOException;
    Subject findSubjectById(int id) throws DAOException;
    Subject findSubjectByName(String name) throws DAOException;

}
