package com.kornievich.selectionCommition.dao.impl;

import com.kornievich.selectionCommition.dao.IAdminDAO;
import com.kornievich.selectionCommition.entity.Admin;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.pool.impl.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;

public class AdminDAO implements IAdminDAO {

    private static final String READ_ADMIN_ALL = "SELECT * FROM selection_commition.admins";
    private static final String FIND_ADMIN_BY_ID = "SELECT * FROM selection_commition.admins WHERE AdminId=?";
    private static final String FIND_ADMIN_BY_NAME = "SELECT * FROM selection_commition.admins WHERE FirstName=?";
    private static final String CREATE_ADMIN = "INSERT INTO selection_commition.admins (AdminId, Surname, FirstName, LastName) VALUES (?,?,?,?)";
    private static final String UPDATE_ADMIN = "UPDATE selection_commition.admins SET selection_commition.admins.Surname = ?, " +
            "selection_commition.admins.FirstName=?, selection_commition.admins.LastName=? WHERE selection_commition.admins.AdminID=?";
    private static final String DELETE_ADMIN = "DELETE FROM selection_commition.admins WHERE selection_commition.admins.AdminsID=?";


    @Override
    public boolean createAdmin(Admin admin) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement =
                    cn.prepareStatement(CREATE_ADMIN);
            preparedStatement.setInt(1, admin.getId());
            preparedStatement.setString(2, admin.getSurname());
            preparedStatement.setString(3, admin.getFirstName());
            preparedStatement.setString(4, admin.getSecondName());
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while creating admin in a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }

    }

    private ArrayList<Admin> initAdmins(ResultSet resultSet) throws SQLException {
        ArrayList<Admin> listAdmin = new ArrayList<>();
        while (resultSet.next()) {
            Admin admin = new Admin(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4));
            listAdmin.add(admin);
        }
        return listAdmin;
    }

    private Admin initAdmin(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Admin(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4));
        }
        return null;
    }

    @Override
    public ArrayList<Admin> readAllAdmins() throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            Statement statement = cn.createStatement();
            ResultSet resultSet = statement.executeQuery(READ_ADMIN_ALL);
            return initAdmins(resultSet);
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while reading admins from a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    @Override
    public boolean updateAdmin(Admin admin) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement = cn.prepareStatement(UPDATE_ADMIN);
            preparedStatement.setString(1, admin.getSurname());
            preparedStatement.setString(2, admin.getFirstName());
            preparedStatement.setString(3, admin.getSecondName());
            preparedStatement.setInt(4, admin.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while updating admin in a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    @Override
    public Admin deleteAdmin(Admin admin) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement = cn.prepareStatement(DELETE_ADMIN);
            preparedStatement.setInt(1, admin.getId());
            return null;
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while deleting admin from a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    @Override
    public Admin findAdminById(int id) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement = cn.prepareStatement(FIND_ADMIN_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return initAdmin(resultSet);
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while finding admin with such id", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    @Override
    public ArrayList<Admin> findAdminByName(String name) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement = cn.prepareStatement(FIND_ADMIN_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            return initAdmins(resultSet);
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while finding admin with such name", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }
}
