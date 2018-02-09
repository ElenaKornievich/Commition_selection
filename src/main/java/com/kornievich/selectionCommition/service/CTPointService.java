package com.kornievich.selectionCommition.service;

import com.kornievich.selectionCommition.dao.impl.CTPointDAO;
import com.kornievich.selectionCommition.entity.CTPoint;
import com.kornievich.selectionCommition.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class CTPointService {
    static final Logger LOGGER = LogManager.getLogger(CTPointService.class);

    private static CTPointService instance;
    private CTPointDAO ctPointDAO;
    private CTPointService() {
        ctPointDAO =new CTPointDAO();

    }
    public static CTPointService getInstance() {
        LOGGER.info("The getInstance() method is called");
        if(instance==null){
            instance = new CTPointService();
        }
        return instance;
    }

    public boolean createCTPoint(CTPoint ctPoint) throws DAOException {
        LOGGER.info("The createCTPoint() method is called");
       return ctPointDAO.createCTPoint(ctPoint);
    }
    public ArrayList<CTPoint> readAllCTPoint() throws DAOException {
        LOGGER.info("The readAllCTPoint() method is called");
        return ctPointDAO.readAllCTPoints();
    }
    public boolean updateCTPoint(CTPoint ctPoint) throws DAOException {
        LOGGER.info("The updateCTPoint() method is called");
        return ctPointDAO.updateCTPoint(ctPoint);
    }
    public CTPoint deleteCTPoint(CTPoint ctPoint) throws DAOException {
        LOGGER.info("The deleteCTPoint() method is called");
        return ctPointDAO.deleteCTPoint(ctPoint);
    }
    public ArrayList<CTPoint> findCTPointByEntrantId(int entrantId) throws DAOException {
        LOGGER.info("The findCTPointByEntrantId() method is called");
        return ctPointDAO.findCTPointByEntrantId(entrantId);
    }
    public ArrayList<CTPoint> findCTPointBySubjectId(int subjectId) throws DAOException {
        LOGGER.info("The findCTPointBySubjectId() method is called");
        return ctPointDAO.findCTPointBySubjectId(subjectId);
    }

}
