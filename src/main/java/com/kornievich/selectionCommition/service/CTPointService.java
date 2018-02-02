package com.kornievich.selectionCommition.service;

import com.kornievich.selectionCommition.dao.impl.CTPointDAO;
import com.kornievich.selectionCommition.dao.impl.EntrantDAO;
import com.kornievich.selectionCommition.dao.impl.UserDAO;
import com.kornievich.selectionCommition.entity.CTPoint;
import com.kornievich.selectionCommition.entity.Entrant;
import com.kornievich.selectionCommition.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class CTPointService {
    // private static Logger logger = Logger.getLogger(UserService.class);

    //  private IUserDAO dao;
    private static CTPointService instance = new CTPointService();
    CTPointDAO ctPointDAO;
    private CTPointService() {
        ctPointDAO =new CTPointDAO();

    }
    public static CTPointService getInstance() {
        return instance;
    }

    public boolean create(CTPoint ctPoint){
       return ctPointDAO.create(ctPoint);
    }
    public ArrayList<CTPoint> readAll(){
        return ctPointDAO.readAll();
    }
    public boolean update(CTPoint ctPoint){
        return ctPointDAO.update(ctPoint);
    }
    public CTPoint delete(CTPoint ctPoint){
        return ctPointDAO.delete(ctPoint);
    }
    public ArrayList<CTPoint> findCTPointByEntrantId(int entrantId){
        return ctPointDAO.findCTPointByEntrantId(entrantId);
    }
    public ArrayList<CTPoint> findCTPointBySubjectId(int subjectId){
        return ctPointDAO.findCTPointBySubjectId(subjectId);
    }

}
