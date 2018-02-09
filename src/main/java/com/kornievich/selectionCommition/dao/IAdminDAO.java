package com.kornievich.selectionCommition.dao;

import com.kornievich.selectionCommition.entity.Admin;
import com.kornievich.selectionCommition.exception.DAOException;

import java.util.ArrayList;

public interface IAdminDAO {
    boolean createAdmin(Admin admin) throws DAOException;
    ArrayList<Admin> readAllAdmins() throws DAOException;
    boolean updateAdmin(Admin admin) throws DAOException;
    Admin deleteAdmin(Admin admin) throws DAOException;
    Admin findAdminById(int id) throws DAOException;
    ArrayList<Admin> findAdminByName(String name) throws DAOException;

}
