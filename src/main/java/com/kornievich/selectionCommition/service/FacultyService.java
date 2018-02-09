package com.kornievich.selectionCommition.service;

import com.kornievich.selectionCommition.dao.impl.FacultyDAO;
import com.kornievich.selectionCommition.entity.Faculty;
import com.kornievich.selectionCommition.exception.DAOException;

import java.util.ArrayList;

public class FacultyService {
    // private static Logger logger = Logger.getLogger(UserService.class);

    //  private IUserDAO dao;
    private static FacultyService instance;
    FacultyDAO facultyDAO;
    private FacultyService() {
        facultyDAO =new FacultyDAO();

    }

    public static FacultyService getInstance() {
        if(instance==null){
            instance = new FacultyService();
        }
        return instance;
    }


    public Faculty findFacultyByName(String name) throws DAOException {
        return facultyDAO.findFacultyByName(name);
    }
    public Faculty findFacultyById(int id) throws DAOException {
        return facultyDAO.findFacultyById(id);
    }
    public Faculty createFaculty(String name, String startDate, String endDate) throws DAOException {
        return facultyDAO.createFaculty(name, startDate, endDate);
    }
    public ArrayList<Faculty> readAllFaculties() throws DAOException {
        return facultyDAO.readAllFaculties();
    }

    public boolean updateFaculty(Faculty faculty) throws DAOException {
        return facultyDAO.updateFaculty(faculty);
    }
    public boolean deleteFaculty(int facultyId) throws DAOException {
        return facultyDAO.deleteFaculty(facultyId);
    }
}
