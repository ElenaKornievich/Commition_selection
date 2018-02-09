package com.kornievich.selectionCommition.service;

import com.kornievich.selectionCommition.dao.impl.AdminDAO;
import com.kornievich.selectionCommition.entity.Admin;
import com.kornievich.selectionCommition.exception.DAOException;

import java.util.ArrayList;

public class AdminService {
    // private static Logger logger = Logger.getLogger(UserService.class);

    //  private IUserDAO dao;
    private static AdminService instance;
    private AdminDAO adminDAO;
    private AdminService() {
        adminDAO =new AdminDAO();
    }


    public static AdminService getInstance() {
        if(instance==null){
            instance= new AdminService();
        }
        return instance;
    }

    public boolean createAdmin(Admin admin) throws DAOException {

        return adminDAO.createAdmin(admin);
    }
    public ArrayList<Admin> readAllAdmins() throws DAOException {
        return adminDAO.readAllAdmins();
    }
    public boolean updateAdmin(Admin admin) throws DAOException {
        return adminDAO.updateAdmin(admin);
    }
    public Admin deleteAdmin(Admin admin) throws DAOException {
        return adminDAO.deleteAdmin(admin);
    }
    public Admin findAdminById(int id) throws DAOException {
        return adminDAO.findAdminById(id);
    }
    public ArrayList<Admin> findAdminByName(String name) throws DAOException {
        return adminDAO.findAdminByName(name);
    }
}
