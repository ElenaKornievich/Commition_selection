package com.kornievich.selectionCommition.dao;

import com.kornievich.selectionCommition.entity.CTPoint;
import com.kornievich.selectionCommition.exception.DAOException;


import java.util.ArrayList;

public interface ICTPointDAO {
     boolean createCTPoint(CTPoint ctPoint) throws DAOException;
     ArrayList<CTPoint> readAllCTPoints() throws DAOException;
     boolean updateCTPoint(CTPoint ctPoint) throws DAOException;
     CTPoint deleteCTPoint(CTPoint ctPoint) throws DAOException;
     ArrayList<CTPoint> findCTPointByEntrantId(int entrantId) throws DAOException;
     ArrayList<CTPoint> findCTPointBySubjectId(int subjectId) throws DAOException;

}
