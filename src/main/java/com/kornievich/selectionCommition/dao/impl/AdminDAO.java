package com.kornievich.selectionCommition.dao.impl;

import com.kornievich.selectionCommition.dao.IAdminDAO;
import com.kornievich.selectionCommition.entity.Admin;
import com.kornievich.selectionCommition.exception.ConnectionUnavailException;
import com.kornievich.selectionCommition.pool.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;

public class AdminDAO implements IAdminDAO {

    private static final String READ_ADMIN_ALL = "SELECT * FROM selection_commition.admins";
    private static final String FIND_ADMIN_BY_ID = "SELECT * FROM selection_commition.admins WHERE AdminId=?";
    private static final String FIND_ADMIN_BY_NAME = "SELECT * FROM selection_commition.admins WHERE FirstName=?";
    private static final String CREATE_ADMIN = "INSERT INTO selection_commition.admins (AdminId, Surname, FirstName, LastName) VALUES (?,?,?,?)";
    private static final String UPDATE_ADMIN = "UPDATE selection_commition.admins SET selection_commition.admins.Surname = ?, " +
            "selection_commition.admins.FirstName=?, selection_commition.admins.LastName WHERE AdminID=?;";
    private static final String DELETE_ADMIN = "DELETE FROM selection_commition.admins WHERE selection_commition.admins.AdminsID=?";


    @Override
    public boolean create(Admin admin) {
        Connection cn = null;
        //Statement st = null;
        try {

            try {
                cn = ConnectionPool.getInstance().getConnection();
            } catch (InterruptedException | ConnectionUnavailException e) {
                e.printStackTrace();
            }
            if (cn != null) {
                PreparedStatement preparedStatement =
                        cn.prepareStatement(CREATE_ADMIN);
                preparedStatement.setInt(1, admin.getId());
                preparedStatement.setString(2,admin.getSurname());
                preparedStatement.setString(3, admin.getFirstName());
                preparedStatement.setString(4, admin.getSecondName());
                preparedStatement.executeUpdate();
            return true;
            } else System.out.println("Всё плохо, здесь ошибка в коннесшне");

        } catch (SQLException e) {
            System.err.println("DB connection error: " + e);
        } finally {

            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.err.println("Сonnection close error: " + e);
                }
            }

        }

        return false;
    }

    private ArrayList<Admin> createAdmins(ResultSet resultSet) throws SQLException {
        ArrayList<Admin> listAdmin = new ArrayList<>();
        while (resultSet.next()){
            Admin admin=new Admin(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4));
            listAdmin.add(admin);
        }
        return listAdmin;
    }

    private Admin createAdmin(ResultSet resultSet) throws SQLException {
        ArrayList<Admin> listAdmin = new ArrayList<>();
       resultSet.next();
            return new Admin(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4));
    }

    @Override
    public ArrayList<Admin> readAll() {
        Connection cn= null;
        try {
            cn = ConnectionPool.getInstance().getConnection();
            Statement statement=cn.createStatement();
            ResultSet resultSet = statement.executeQuery(READ_ADMIN_ALL);
            return createAdmins(resultSet);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ConnectionUnavailException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Admin admin) {
        try {
            Connection cn=ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement(UPDATE_ADMIN);
            preparedStatement.setString(1, admin.getSurname());
            preparedStatement.setString(2, admin.getFirstName());
            preparedStatement.setString(3, admin.getSecondName());
            preparedStatement.executeUpdate();
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ConnectionUnavailException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Admin delete(Admin admin) {
        try {
            Connection cn=ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement(DELETE_ADMIN);
            preparedStatement.setInt(1, admin.getId());
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ConnectionUnavailException e) {
            e.printStackTrace();
        }
        return admin;
    }

    @Override
    public Admin findAdminById(int id) {
        Connection cn= null;
        try {
            cn = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement(FIND_ADMIN_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            return createAdmin(resultSet);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ConnectionUnavailException e) {
            e.printStackTrace();
        }
         return null;
    }

    @Override
    public ArrayList<Admin> findAdminByName(String name) {
        Connection cn= null;
        try {
            cn = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement(FIND_ADMIN_BY_NAME);
            preparedStatement.setString(1,name);
            ResultSet resultSet=preparedStatement.executeQuery();
            return createAdmins(resultSet);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ConnectionUnavailException e) {
            e.printStackTrace();
        }
        return null;
    }
}
