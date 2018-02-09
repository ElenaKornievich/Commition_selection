package com.kornievich.selectionCommition.service;

import com.kornievich.selectionCommition.dao.impl.EntrantDAO;
import com.kornievich.selectionCommition.entity.Entrant;
import com.kornievich.selectionCommition.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class EntrantService {
    static final Logger LOGGER = LogManager.getLogger(EntrantService.class);
    private static EntrantService instance;
    EntrantDAO entrantDAO;
    private EntrantService() {
        entrantDAO =new EntrantDAO();
    }
    public static EntrantService getInstance() {
        LOGGER.info("The getInstance() method is called");
        if(instance==null){
            instance=new EntrantService();
        }
        return instance;
    }

    public boolean createEntrant(Entrant entrant) throws DAOException {
        LOGGER.info("The createEntrant() method is called");
        return entrantDAO.createEntrant(entrant);
    }
    public Entrant findEntrantById(int id) throws DAOException {
        LOGGER.info("The findEntrantById() method is called");
        return entrantDAO.findEntrantById(id);
    }
    public ArrayList<Entrant> findEntrantByName(String name) throws DAOException {
        LOGGER.info("The findEntrantByName() method is called");
        return entrantDAO.findEntrantByName(name);
    }
    public boolean updateEntrant(Entrant entrant) throws DAOException {
        LOGGER.info("The updateEntrant() method is called");
        return entrantDAO.updateEntrant(entrant);
    }
    public boolean deleteEntrant(int id) throws DAOException {
        LOGGER.info("The deleteEntrant() method is called");
        return entrantDAO.deleteEntrant(id);
    }
    public ArrayList<Entrant> readAllEntrants() throws DAOException {
        LOGGER.info("The readAllEntrants() method is called");
        return entrantDAO.readAllEntrants();
    }
    public boolean changeEntrantSpeciality(int entrantId, int specialityId) throws DAOException {
        LOGGER.info("The changeEntrantSpeciality() method is called");
        return entrantDAO.changeEntrantSpeciality(entrantId, specialityId);
    }

}
