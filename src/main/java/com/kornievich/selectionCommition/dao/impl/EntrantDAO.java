package com.kornievich.selectionCommition.dao.impl;

import com.kornievich.selectionCommition.dao.IEntrantDAO;
import com.kornievich.selectionCommition.entity.Entrant;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.pool.impl.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;

public class EntrantDAO implements IEntrantDAO {

    private static final String DELETE_ENTRANT = "DELETE FROM selection_commition.entrants " +
            "WHERE selection_commition.entrants.EntrantId=?";
    private static final String CREATE_ENTRANT = "INSERT INTO selection_commition.entrants VALUES (?,?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String FIND_ENTRANT_BY_ID = "SELECT * FROM selection_commition.entrants WHERE EntrantID=?";
    private static final String FIND_ENTRANT_BY_NAME = "SELECT * FROM selection_commition.entrants WHERE entrants.FirstName=?";
    private static final String READ_ALL_ENTRANT = "SELECT * FROM entrants";
    private static final String CHANGE_SPECIALITY = "UPDATE selection_commition.entrants SET selection_commition.entrants.SpecialtyID=?" +
            " WHERE selection_commition.entrants.EntrantID=?";
    private static final String UPDATE_ENTRANT = "UPDATE selection_commition.entrants SET selection_commition.entrants.DateOfFiling = ?, " +
            "selection_commition.entrants.SpecialtyID = ?, " +
            "selection_commition.entrants.PassportSeries=?, selection_commition.entrants.PassportNumber=?, " +
            "selection_commition.entrants.Surname=?, selection_commition.entrants.FirstName=?," +
            "selection_commition.entrants.LastName=?, selection_commition.entrants.DateOfIssue=?," +
            "selection_commition.entrants.IdentificationNumber=?, selection_commition.entrants.DateOfBirth=?," +
            "selection_commition.entrants.Nationality=?, selection_commition.entrants.TelephoneNumber=?," +
            "selection_commition.entrants.ResidenceAddress=?, selection_commition.entrants.Score=?," +
            "selection_commition.entrants.GoldMedal=?, selection_commition.entrants.Email=? WHERE EntrantID=?;";

    @Override
    public boolean createEntrant(Entrant entrant) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement =
                    cn.prepareStatement(CREATE_ENTRANT);
            preparedStatement.setInt(1, entrant.getId());
            preparedStatement.setString(2, entrant.getDateOfFilling());
            preparedStatement.setInt(3, entrant.getSpecialityId());
            preparedStatement.setString(4, entrant.getPasportSeries());
            preparedStatement.setInt(5, entrant.getPassportNumber());
            preparedStatement.setString(6, entrant.getSurname());
            preparedStatement.setString(7, entrant.getFirstName());
            preparedStatement.setString(8, entrant.getLastName());
            preparedStatement.setString(9, entrant.getDateOfIssue());
            preparedStatement.setString(10, entrant.getIdentificationNumber());
            preparedStatement.setString(11, entrant.getDateOfBirth());
            preparedStatement.setString(12, entrant.getNationality());
            preparedStatement.setString(13, entrant.getTelephoneNumber());
            preparedStatement.setString(14, entrant.getResidenceAddress());
            preparedStatement.setDouble(15, entrant.getScore());
            preparedStatement.setBoolean(16, entrant.isGoldMedal());
            preparedStatement.setString(17, entrant.getEmail());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while creating entrant in a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    @Override
    public Entrant findEntrantById(int id) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement = cn.prepareStatement(FIND_ENTRANT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return initEntrant(resultSet);
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while finding entrant with such id", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }


    @Override
    public boolean updateEntrant(Entrant entrant) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement =
                    cn.prepareStatement(UPDATE_ENTRANT);
            preparedStatement.setString(1, entrant.getDateOfFilling());
            preparedStatement.setInt(2, entrant.getSpecialityId());
            preparedStatement.setString(3, entrant.getPasportSeries());
            preparedStatement.setInt(4, entrant.getPassportNumber());
            preparedStatement.setString(5, entrant.getSurname());
            preparedStatement.setString(6, entrant.getFirstName());
            preparedStatement.setString(7, entrant.getLastName());
            preparedStatement.setString(8, entrant.getDateOfIssue());
            preparedStatement.setString(9, entrant.getIdentificationNumber());
            preparedStatement.setString(10, entrant.getDateOfBirth());
            preparedStatement.setString(11, entrant.getNationality());
            preparedStatement.setString(12, entrant.getTelephoneNumber());
            preparedStatement.setString(13, entrant.getResidenceAddress());
            preparedStatement.setDouble(14, entrant.getScore());
            preparedStatement.setBoolean(15, entrant.isGoldMedal());
            preparedStatement.setString(16, entrant.getEmail());
            preparedStatement.setInt(17, entrant.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while updating entrant in a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    @Override
    public boolean changeEntrantSpeciality(int entrantId, int specialityId) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement =
                    cn.prepareStatement(CHANGE_SPECIALITY);
            preparedStatement.setInt(1, specialityId);
            preparedStatement.setInt(2, entrantId);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while changing entrant speciality in a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }


    @Override
    public boolean deleteEntrant(int id) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement =
                    cn.prepareStatement(DELETE_ENTRANT);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while deleting entrant from a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    private ArrayList<Entrant> initEntrants(ResultSet resultSet) throws SQLException {
        ArrayList<Entrant> listEntrant = new ArrayList<>();
        while (resultSet.next()) {
            Entrant entrant = new Entrant(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),
                    resultSet.getString(4), resultSet.getInt(5), resultSet.getString(6),
                    resultSet.getString(7), resultSet.getString(8), resultSet.getString(9),
                    resultSet.getString(10), resultSet.getString(11), resultSet.getString(12),
                    resultSet.getString(13), resultSet.getString(14), resultSet.getInt(15), resultSet.getBoolean(16),
                    resultSet.getString(17));
            listEntrant.add(entrant);
        }
        return listEntrant;
    }

    @Override
    public ArrayList<Entrant> readAllEntrants() throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            Statement statement = cn.createStatement();
            ResultSet resultSet = statement.executeQuery(READ_ALL_ENTRANT);
            return initEntrants(resultSet);
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while reading entrants from a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    @Override
    public ArrayList<Entrant> findEntrantByName(String name) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement = cn.prepareStatement(FIND_ENTRANT_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            return initEntrants(resultSet);
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while finding entrant with such name", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    private Entrant initEntrant(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Entrant(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),
                    resultSet.getString(4), resultSet.getInt(5), resultSet.getString(6),
                    resultSet.getString(7), resultSet.getString(8), resultSet.getString(9),
                    resultSet.getString(10), resultSet.getString(11), resultSet.getString(12),
                    resultSet.getString(13), resultSet.getString(14), resultSet.getInt(15), resultSet.getBoolean(16),
                    resultSet.getString(17));
        }
        return null;
    }

}
