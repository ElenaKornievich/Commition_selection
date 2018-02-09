package com.kornievich.selectionCommition.dao;

import com.kornievich.selectionCommition.entity.FacultySubject;
import com.kornievich.selectionCommition.exception.DAOException;

import java.util.ArrayList;

public interface IFacultySubjectsDAO {
    boolean createFacultySubject(FacultySubject facultySubject) throws DAOException;
    ArrayList<FacultySubject> readAllFacultySubject() throws DAOException;
    FacultySubject deleteFacultySubject(FacultySubject facultySubject) throws DAOException;
    ArrayList<FacultySubject> findFacultySubjectsByFacultyId(int id) throws DAOException;
    ArrayList<FacultySubject> findFacultySubjectsBySubjectId(int id) throws DAOException;
    boolean updateFacultySubject(FacultySubject facultySubject) throws DAOException;

}
