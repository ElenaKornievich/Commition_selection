package com.kornievich.selectionCommition.service;

import com.kornievich.selectionCommition.command.EmptyCommand;
import com.kornievich.selectionCommition.dao.impl.AdminDAO;
import com.kornievich.selectionCommition.entity.Admin;
import com.kornievich.selectionCommition.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class AdminService {
    static final Logger LOGGER = LogManager.getLogger(AdminService.class);

    //  private IUserDAO dao;
    private static AdminService instance;
    private AdminDAO adminDAO;
    private AdminService() {
        adminDAO =new AdminDAO();
    }


    public static AdminService getInstance() {
        LOGGER.info("The getInstance() method is called");
        if(instance==null){
            instance= new AdminService();
        }
        return instance;
    }

    public boolean createAdmin(Admin admin) throws DAOException {
        LOGGER.info("The createAdmin() method is called");
        return adminDAO.createAdmin(admin);
    }
    public ArrayList<Admin> readAllAdmins() throws DAOException {
        LOGGER.info("The readAllAdmins() method is called");
        return adminDAO.readAllAdmins();
    }
    public boolean updateAdmin(Admin admin) throws DAOException {
        LOGGER.info("The updateAdmin() method is called");
        return adminDAO.updateAdmin(admin);
    }
    public Admin deleteAdmin(Admin admin) throws DAOException {
        LOGGER.info("The deleteAdmin() method is called");
        return adminDAO.deleteAdmin(admin);
    }
    public Admin findAdminById(int id) throws DAOException {
        LOGGER.info("The findAdminById() method is called");
        return adminDAO.findAdminById(id);
    }
    public ArrayList<Admin> findAdminByName(String name) throws DAOException {
        LOGGER.info("The findAdminByName() method is called");
        return adminDAO.findAdminByName(name);
    }
}
