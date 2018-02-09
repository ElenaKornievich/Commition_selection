package com.kornievich.selectionCommition.service;

import com.kornievich.selectionCommition.dao.impl.CTPointDAO;
import com.kornievich.selectionCommition.entity.CTPoint;
import com.kornievich.selectionCommition.exception.DAOException;

import java.util.ArrayList;

public class CTPointService {
    // private static Logger logger = Logger.getLogger(UserService.class);

    //  private IUserDAO dao;
    private static CTPointService instance;
    private CTPointDAO ctPointDAO;
    private CTPointService() {
        ctPointDAO =new CTPointDAO();

    }
    public static CTPointService getInstance() {
        if(instance==null){
            instance = new CTPointService();
        }
        return instance;
    }

    public boolean createCTPoint(CTPoint ctPoint) throws DAOException {
       return ctPointDAO.createCTPoint(ctPoint);
    }
    public ArrayList<CTPoint> readAllCTPoint() throws DAOException {
        return ctPointDAO.readAllCTPoints();
    }
    public boolean updateCTPoint(CTPoint ctPoint) throws DAOException {
        return ctPointDAO.updateCTPoint(ctPoint);
    }
    public CTPoint deleteCTPoint(CTPoint ctPoint) throws DAOException {
        return ctPointDAO.deleteCTPoint(ctPoint);
    }
    public ArrayList<CTPoint> findCTPointByEntrantId(int entrantId) throws DAOException {
        return ctPointDAO.findCTPointByEntrantId(entrantId);
    }
    public ArrayList<CTPoint> findCTPointBySubjectId(int subjectId) throws DAOException {
        return ctPointDAO.findCTPointBySubjectId(subjectId);
    }

}
