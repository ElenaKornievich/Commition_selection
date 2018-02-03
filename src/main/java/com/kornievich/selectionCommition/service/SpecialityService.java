package com.kornievich.selectionCommition.service;

import com.kornievich.selectionCommition.dao.impl.EntrantDAO;
import com.kornievich.selectionCommition.dao.impl.SpecialityDAO;
import com.kornievich.selectionCommition.dao.impl.UserDAO;
import com.kornievich.selectionCommition.entity.Entrant;
import com.kornievich.selectionCommition.entity.Speciality;
import com.kornievich.selectionCommition.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class SpecialityService {
    // private static Logger logger = Logger.getLogger(UserService.class);

    //  private IUserDAO dao;
    private static SpecialityService instance = new SpecialityService();
    SpecialityDAO specialityDAO;
    private SpecialityService() {
        specialityDAO =new SpecialityDAO();
    }
    public static SpecialityService getInstance() {
        return instance;
    }

    public Speciality create(String name, int facultyId, int numberOfBudgetPlace, int numberOfPainPlace){
        return specialityDAO.create(name, facultyId, numberOfBudgetPlace, numberOfPainPlace);
    }
    public ArrayList<Speciality> readAll(){
        return specialityDAO.readAll();
    }
    public boolean update(Speciality speciality){
        return specialityDAO.update(speciality);
    }
    public boolean delete(int specialityId){
        return specialityDAO.delete(specialityId);
    }
    public Speciality findSpecialityById(int id){
        return specialityDAO.findSpecialityById(id);
    }
    public Speciality findSpecialityByName(String name){
        return specialityDAO.findSpecialityByName(name);
    }




}
