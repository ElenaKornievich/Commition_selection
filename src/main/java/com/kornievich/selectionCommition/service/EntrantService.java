package com.kornievich.selectionCommition.service;

import com.kornievich.selectionCommition.dao.impl.EntrantDAO;
import com.kornievich.selectionCommition.entity.Entrant;
import com.kornievich.selectionCommition.exception.DAOException;

import java.util.ArrayList;

public class EntrantService {
    // private static Logger logger = Logger.getLogger(UserService.class);

    //  private IUserDAO dao;
    private static EntrantService instance;
    EntrantDAO entrantDAO;
    private EntrantService() {
        entrantDAO =new EntrantDAO();
    }
    public static EntrantService getInstance() {
        if(instance==null){
            instance=new EntrantService();
        }
        return instance;
    }

    public boolean create(Entrant entrant) throws DAOException {
        return entrantDAO.createEntrant(entrant);
    }
    public Entrant findEntrantById(int id) throws DAOException {
        return entrantDAO.findEntrantById(id);
    }
    public ArrayList<Entrant> findEntrantByName(String name) throws DAOException {
        return entrantDAO.findEntrantByName(name);
    }
    public boolean updateEntrant(Entrant entrant) throws DAOException {
        return entrantDAO.updateEntrant(entrant);
    }
    public boolean deleteEntrant(int id) throws DAOException {
        return entrantDAO.deleteEntrant(id);
    }
    public ArrayList<Entrant> readAllEntrants() throws DAOException {
        return entrantDAO.readAllEntrants();
    }
    public boolean changeEntrantSpeciality(int entrantId, int specialityId) throws DAOException {
        return entrantDAO.changeEntrantSpeciality(entrantId, specialityId);
    }

}
