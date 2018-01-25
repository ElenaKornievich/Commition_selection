package com.kornievich.selectionCommition.dao;

import com.kornievich.selectionCommition.command.Roles;
import com.kornievich.selectionCommition.entity.Entrant;
import com.kornievich.selectionCommition.entity.User;
import com.kornievich.selectionCommition.exception.ConnectionUnavailException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IEntrantDAO {
    public boolean create(Entrant entrant);
    public Entrant findEntrantById(int id);
    public ArrayList<Entrant> findEntrantByName(String name);
    public boolean update(Entrant entrant);
    public Entrant delete(Entrant entrant);
    public ArrayList<Entrant> readEntrant();
}
