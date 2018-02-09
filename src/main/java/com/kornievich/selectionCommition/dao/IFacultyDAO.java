package com.kornievich.selectionCommition.dao;


import com.kornievich.selectionCommition.entity.Faculty;
import com.kornievich.selectionCommition.exception.DAOException;

import java.util.ArrayList;

public interface IFacultyDAO {
    Faculty createFaculty(String name, String startDate, String endDate) throws DAOException;
    ArrayList<Faculty> readAllFaculties() throws DAOException;
    boolean updateFaculty(Faculty faculty) throws DAOException;
    boolean deleteFaculty(int facultyId) throws DAOException;
    Faculty findFacultyById(int id) throws DAOException;
    Faculty findFacultyByName(String name) throws DAOException;

}
