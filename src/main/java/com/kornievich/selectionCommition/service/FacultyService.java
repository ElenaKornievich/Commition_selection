package com.kornievich.selectionCommition.service;

import com.kornievich.selectionCommition.dao.impl.EntrantDAO;
import com.kornievich.selectionCommition.dao.impl.FacultyDAO;
import com.kornievich.selectionCommition.dao.impl.UserDAO;
import com.kornievich.selectionCommition.entity.Entrant;
import com.kornievich.selectionCommition.entity.Faculty;
import com.kornievich.selectionCommition.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class FacultyService {
    // private static Logger logger = Logger.getLogger(UserService.class);

    //  private IUserDAO dao;
    private static FacultyService instance = new FacultyService();
    FacultyDAO facultyDAO;
    private FacultyService() {
        facultyDAO =new FacultyDAO();

    }

    public static FacultyService getInstance() {
        return instance;
    }


    public Faculty findFacultyByName(String name){
        return facultyDAO.findFacultyByName(name);
    }
    public Faculty findFacultyById(int id){
        return facultyDAO.findFacultyById(id);
    }
    public Faculty create(String name, String startDate, String endDate){
        return facultyDAO.create(name, startDate, endDate);
    }
    public ArrayList<Faculty> readAll(){
        return facultyDAO.readAll();
    }

    public boolean update(Faculty faculty){
        return facultyDAO.update(faculty);
    }
    public Faculty delete(Faculty faculty){
        return facultyDAO.delete(faculty);
    }
}
