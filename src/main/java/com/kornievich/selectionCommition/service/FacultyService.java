package com.kornievich.selectionCommition.service;

import com.kornievich.selectionCommition.dao.impl.FacultyDAO;
import com.kornievich.selectionCommition.entity.Faculty;
import com.kornievich.selectionCommition.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class FacultyService {
    static final Logger LOGGER = LogManager.getLogger(FacultyService.class);
    private static FacultyService instance;
    FacultyDAO facultyDAO;
    private FacultyService() {
        facultyDAO =new FacultyDAO();

    }

    public static FacultyService getInstance() {
        LOGGER.info("The getInstance() method is called");
        if(instance==null){
            instance = new FacultyService();
        }
        return instance;
    }


    public Faculty findFacultyByName(String name) throws DAOException {
        LOGGER.info("The findFacultyByName() method is called");
        return facultyDAO.findFacultyByName(name);
    }
    public Faculty findFacultyById(int id) throws DAOException {
        LOGGER.info("The findFacultyById() method is called");
        return facultyDAO.findFacultyById(id);
    }
    public Faculty createFaculty(String name, String startDate, String endDate) throws DAOException {
        LOGGER.info("The createFaculty() method is called");
        return facultyDAO.createFaculty(name, startDate, endDate);
    }
    public ArrayList<Faculty> readAllFaculties() throws DAOException {
        LOGGER.info("The readAllFaculties() method is called");
        return facultyDAO.readAllFaculties();
    }

    public boolean updateFaculty(Faculty faculty) throws DAOException {
        LOGGER.info("The updateFaculty() method is called");
        return facultyDAO.updateFaculty(faculty);
    }
    public boolean deleteFaculty(int facultyId) throws DAOException {
        LOGGER.info("The deleteFaculty() method is called");
        return facultyDAO.deleteFaculty(facultyId);
    }
}
