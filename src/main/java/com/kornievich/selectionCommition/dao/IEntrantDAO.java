package com.kornievich.selectionCommition.dao;


import com.kornievich.selectionCommition.entity.Entrant;
import com.kornievich.selectionCommition.exception.DAOException;

import java.util.ArrayList;

public interface IEntrantDAO {
    boolean createEntrant(Entrant entrant) throws DAOException;
    Entrant findEntrantById(int id) throws DAOException;
    ArrayList<Entrant> findEntrantByName(String name) throws DAOException;
    boolean updateEntrant(Entrant entrant) throws DAOException;
    boolean deleteEntrant(int id) throws DAOException;
    ArrayList<Entrant> readAllEntrants() throws DAOException;
    boolean changeEntrantSpeciality(int entrantId, int specialityId) throws DAOException;
}
