package com.kornievich.selectionCommition.dao;

import com.kornievich.selectionCommition.entity.Admin;
import com.kornievich.selectionCommition.entity.Faculty;

import java.util.ArrayList;

public interface IAdminDAO {
    boolean create(Admin admin);
    ArrayList<Admin> readAll();
    boolean update(Admin admin);
    Admin delete(Admin admin);
    Admin findAdminById(int id);
    ArrayList<Admin> findAdminByName(String name);

}
