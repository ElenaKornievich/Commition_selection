package com.kornievich.selectionCommition.dao.impl;

import com.kornievich.selectionCommition.dao.ISpecialityDAO;
import com.kornievich.selectionCommition.entity.Speciality;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.pool.impl.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;

public class SpecialityDAO implements ISpecialityDAO {

    private static final String READ_SPECIALITY_ALL = "SELECT * FROM selection_commition.specialties";
    private static final String FIND_SPECIALITY_BY_ID = "SELECT * FROM selection_commition.specialties WHERE SpecialtyID=?";
    private static final String FIND_SPECIALITY_BY_FACULTY_ID = "SELECT * FROM selection_commition.specialties WHERE FacultyID=? AND SpecialtyID<>0";

    private static final String FIND_SPECIALITY_BY_NAME = "SELECT * FROM selection_commition.specialties WHERE SpecialtyName=?";
    private static final String CREATE_SPECIALITY = "INSERT INTO selection_commition.specialties (SpecialtyName , FacultyID, NumberOfBudgetPlaces, NumberOfPaidPlaces) VALUES (?,?,?,?)";
    private static final String UPDATE_SPECIALITY = "UPDATE selection_commition.specialties SET selection_commition.specialties.SpecialtyName = ?, " +
            "selection_commition.specialties.FacultyID=?, selection_commition.specialties.NumberOfBudgetPlaces=?," +
            "selection_commition.specialties.NumberOfPaidPlaces=? WHERE SpecialtyID=?;";
    private static final String DELETE_SPECIALITY = "DELETE FROM selection_commition.specialties WHERE selection_commition.specialties.SpecialtyID=?";
    private static final String ALL_SPECIALTY = "SELECT SpecialtyID FROM specialties";

    private ArrayList<Speciality> initSpecialities(ResultSet resultSet) throws SQLException {
        ArrayList<Speciality> listSpeciality = new ArrayList<>();
        while (resultSet.next()) {
            Speciality speciality = new Speciality(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getInt(3), resultSet.getInt(4), resultSet.getInt(5));
            listSpeciality.add(speciality);
        }
        return listSpeciality;
    }


    private Speciality initSpeciality(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Speciality(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getInt(3), resultSet.getInt(4), resultSet.getInt(5));
        }
        return null;
    }


    @Override
    public String createSpeciality(String name, int facultyId, int numberOfBudgetPlace, int numberOfPainPlace) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement = cn.prepareStatement(CREATE_SPECIALITY);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, facultyId);
            preparedStatement.setInt(3, numberOfBudgetPlace);
            preparedStatement.setInt(4, numberOfPainPlace);
            preparedStatement.executeUpdate();
            return name;
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while creating speciality in a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    @Override
    public ArrayList<Speciality> readAllSpecialities() throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            Statement statement = cn.createStatement();
            ResultSet resultSet = statement.executeQuery(READ_SPECIALITY_ALL);
            return initSpecialities(resultSet);
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while reading specialities from a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    @Override
    public boolean updateSpeciality(Speciality speciality) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement = cn.prepareStatement(UPDATE_SPECIALITY);
            preparedStatement.setString(1, speciality.getName());
            preparedStatement.setInt(2, speciality.getFacultyId());
            preparedStatement.setInt(3, speciality.getNumberBudgetPlace());
            preparedStatement.setInt(4, speciality.getNumberPaidPlace());
            preparedStatement.setInt(5, speciality.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while updating speciality in a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    @Override
    public boolean deleteSpeciality(int specialityId) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement = cn.prepareStatement(DELETE_SPECIALITY);
            preparedStatement.setInt(1, specialityId);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while deleting speciality from a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    @Override
    public Speciality findSpecialityById(int id) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement = cn.prepareStatement(FIND_SPECIALITY_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return initSpeciality(resultSet);
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while finding speciality with such id", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }
    @Override
    public ArrayList<Speciality> findSpecialityByFacultyId(int id) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement = cn.prepareStatement(FIND_SPECIALITY_BY_FACULTY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return initSpecialities(resultSet);
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while finding speciality with such id", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    @Override
    public Speciality findSpecialityByName(String name) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement = cn.prepareStatement(FIND_SPECIALITY_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            Speciality speciality = initSpeciality(resultSet);
            return speciality;
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while finding speciality with such name", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    public ArrayList<Integer> readAllIdSpecialties() throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            Statement statement = cn.createStatement();
            ResultSet resultSet = statement.executeQuery(ALL_SPECIALTY);
            if (resultSet != null) {
                ArrayList<Integer> allIdSpecialty = new ArrayList<>();
                while (resultSet.next()) {
                    allIdSpecialty.add(resultSet.getInt(1));
                }
                return allIdSpecialty;
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while reading all id specialities", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }
}
