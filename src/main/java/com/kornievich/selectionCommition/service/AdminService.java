package com.kornievich.selectionCommition.service;

import com.kornievich.selectionCommition.dao.impl.AdminDAO;
import com.kornievich.selectionCommition.dao.impl.EntrantDAO;
import com.kornievich.selectionCommition.dao.impl.UserDAO;
import com.kornievich.selectionCommition.entity.Admin;
import com.kornievich.selectionCommition.entity.Entrant;
import com.kornievich.selectionCommition.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class AdminService {
    // private static Logger logger = Logger.getLogger(UserService.class);

    //  private IUserDAO dao;
    private static AdminService instance = new AdminService();
    AdminDAO adminDAO;
    private AdminService() {
        adminDAO =new AdminDAO();

    }


    public static AdminService getInstance() {
        return instance;
    }

    public boolean create(Admin admin){
        return adminDAO.create(admin);
    }
    public ArrayList<Admin> readAll(){
        return adminDAO.readAll();
    }
    public boolean update(Admin admin){
        return adminDAO.update(admin);
    }
    public Admin delete(Admin admin){
        return adminDAO.delete(admin);
    }
    public Admin findAdminById(int id){
        return adminDAO.findAdminById(id);
    }
    public ArrayList<Admin> findAdminByName(String name){
        return adminDAO.findAdminByName(name);
    }



}
