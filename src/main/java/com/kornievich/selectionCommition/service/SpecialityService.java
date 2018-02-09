package com.kornievich.selectionCommition.service;

import com.kornievich.selectionCommition.dao.impl.SpecialityDAO;
import com.kornievich.selectionCommition.entity.Speciality;
import com.kornievich.selectionCommition.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class SpecialityService {
    static final Logger LOGGER = LogManager.getLogger(SpecialityService.class);
    private static SpecialityService instance;
    private SpecialityDAO specialityDAO;
    private SpecialityService() {
        specialityDAO =new SpecialityDAO();
    }
    public static SpecialityService getInstance() {
        LOGGER.info("The getInstance() method is called");
        if(instance==null){
            instance = new SpecialityService();
        }
        return instance;
    }

    public Speciality createSpeciality(String name, int facultyId, int numberOfBudgetPlace, int numberOfPainPlace) throws DAOException {
        LOGGER.info("The createSpeciality() method is called");
        specialityDAO.createSpeciality(name, facultyId, numberOfBudgetPlace, numberOfPainPlace);
        return specialityDAO.findSpecialityByName(name);
    }
    public ArrayList<Speciality> readAllSpecialities() throws DAOException {
        LOGGER.info("The readAllSpecialities() method is called");
        return specialityDAO.readAllSpecialities();
    }
    public boolean updateSpeciality(Speciality speciality) throws DAOException {
        LOGGER.info("The updateSpeciality() method is called");
        return specialityDAO.updateSpeciality(speciality);
    }
    public boolean deleteSpeciality(int specialityId) throws DAOException {
        LOGGER.info("The deleteSpeciality() method is called");
        return specialityDAO.deleteSpeciality(specialityId);
    }
    public Speciality findSpecialityById(int id) throws DAOException {
        LOGGER.info("The findSpecialityById() method is called");
        return specialityDAO.findSpecialityById(id);
    }
    public Speciality findSpecialityByName(String name) throws DAOException {
        LOGGER.info("The findSpecialityByName() method is called");
        return specialityDAO.findSpecialityByName(name);
    }




}
