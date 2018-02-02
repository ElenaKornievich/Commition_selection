package com.kornievich.selectionCommition.service;

import com.kornievich.selectionCommition.dao.impl.EntrantDAO;
import com.kornievich.selectionCommition.dao.impl.UserDAO;
import com.kornievich.selectionCommition.entity.Entrant;
import com.kornievich.selectionCommition.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class EntrantService {
    // private static Logger logger = Logger.getLogger(UserService.class);

    //  private IUserDAO dao;
    private static EntrantService instance = new EntrantService();
    EntrantDAO entrantDAO;
    private EntrantService() {
        entrantDAO =new EntrantDAO();
    }
    public static EntrantService getInstance() {
        return instance;
    }

    public boolean create(Entrant entrant){
        return entrantDAO.create(entrant);
    }
    public Entrant findEntrantById(int id){
        return entrantDAO.findEntrantById(id);
    }
    public ArrayList<Entrant> findEntrantByName(String name){
        return entrantDAO.findEntrantByName(name);
    }
    public boolean update(Entrant entrant){
        return entrantDAO.update(entrant);
    }
    public boolean delete(int id){
        return entrantDAO.delete(id);
    }
    public ArrayList<Entrant> readEntrant(){
        return entrantDAO.readEntrant();
    }
    public boolean changeSpeciality(int entrantId, int specialityId){
        return entrantDAO.changeSpeciality(entrantId, specialityId);
    }

}
