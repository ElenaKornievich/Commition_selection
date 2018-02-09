package com.kornievich.selectionCommition.service;

import com.kornievich.selectionCommition.dao.impl.SpecialityDAO;
import com.kornievich.selectionCommition.entity.Speciality;
import com.kornievich.selectionCommition.exception.DAOException;

import java.util.ArrayList;

public class SpecialityService {
    // private static Logger logger = Logger.getLogger(UserService.class);

    private static SpecialityService instance;
    private SpecialityDAO specialityDAO;
    private SpecialityService() {
        specialityDAO =new SpecialityDAO();
    }
    public static SpecialityService getInstance() {
        if(instance==null){
            instance = new SpecialityService();
        }
        return instance;
    }

    public Speciality createSpeciality(String name, int facultyId, int numberOfBudgetPlace, int numberOfPainPlace) throws DAOException {
        specialityDAO.createSpeciality(name, facultyId, numberOfBudgetPlace, numberOfPainPlace);
        return specialityDAO.findSpecialityByName(name);
    }
    public ArrayList<Speciality> readAllSpecialities() throws DAOException {
        return specialityDAO.readAllSpecialities();
    }
    public boolean updateSpeciality(Speciality speciality) throws DAOException {
        return specialityDAO.updateSpeciality(speciality);
    }
    public boolean deleteSpeciality(int specialityId) throws DAOException {
        return specialityDAO.deleteSpeciality(specialityId);
    }
    public Speciality findSpecialityById(int id) throws DAOException {
        return specialityDAO.findSpecialityById(id);
    }
    public Speciality findSpecialityByName(String name) throws DAOException {
        return specialityDAO.findSpecialityByName(name);
    }




}
