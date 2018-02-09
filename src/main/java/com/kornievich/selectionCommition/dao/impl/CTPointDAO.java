package com.kornievich.selectionCommition.dao.impl;

import com.kornievich.selectionCommition.dao.ICTPointDAO;
import com.kornievich.selectionCommition.entity.CTPoint;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.pool.impl.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;

public class CTPointDAO implements ICTPointDAO {

    private static final String CREATE_CTPOINT = "INSERT INTO selection_commition.ctpoints VALUES (?,?,?);";
    private static final String READ_ALL = "SELECT * FROM selection_commition.ctpoints;";
    private static final String UPDATE_CTPOINT = "UPDATE selection_commition.ctpoints SET selection_commition.ctpoints.Score=? " +
            "WHERE selection_commition.ctpoints.EntrantId=? AND selection_commition.ctpoints.SubjectId=?;";
    private static final String DELETE_CTPOINT = "DELETE FROM selection_commition.ctpoints " +
            "WHERE selection_commition.ctpoints.EntrantId=? AND selection_commition.ctpoints.SubjectId=?";
    private static final String FIND_CTPOINT_BY_ENTRANT_ID = "SELECT * FROM selection_commition.ctpoints WHERE EntrantId=?";
    private static final String FIND_CTPOINT_BY_SUBJECT_ID = "SELECT * FROM selection_commition.ctpoints WHERE SubjectId=?";


    @Override
    public boolean createCTPoint(CTPoint ctPoint) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement = cn.prepareStatement(CREATE_CTPOINT);
            preparedStatement.setInt(1, ctPoint.getSubjectId());
            preparedStatement.setInt(2, ctPoint.getEntrantId());
            preparedStatement.setInt(3, ctPoint.getScope());
            return true;
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while creating CTPoint in a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    private ArrayList<CTPoint> initCTPoints(ResultSet resultSet) throws SQLException {
        ArrayList<CTPoint> listCTPoint = new ArrayList<>();
        while (resultSet.next()) {
            CTPoint ctPoint = new CTPoint(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3));
            listCTPoint.add(ctPoint);
        }
        return listCTPoint;
    }

    private CTPoint initCTPoint(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new CTPoint(resultSet.getInt(2), resultSet.getInt(1), resultSet.getInt(3));
        }
        return null;
    }

    @Override
    public ArrayList<CTPoint> readAllCTPoints() throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            Statement statement = cn.createStatement();
            ResultSet resultSet = statement.executeQuery(READ_ALL);
            return initCTPoints(resultSet);
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while reading CTPoints from a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    @Override
    public boolean updateCTPoint(CTPoint ctPoint) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement = cn.prepareStatement(UPDATE_CTPOINT);
            preparedStatement.setInt(1, ctPoint.getScope());
            preparedStatement.setInt(2, ctPoint.getEntrantId());
            preparedStatement.setInt(3, ctPoint.getSubjectId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while updating CTPoint in a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    public ArrayList<CTPoint> findCTPointByEntrantId(int entrantId) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement = cn.prepareStatement(FIND_CTPOINT_BY_ENTRANT_ID);
            preparedStatement.setInt(1, entrantId);
            ResultSet resultSet = preparedStatement.executeQuery();
            return initCTPoints(resultSet);
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while finding CTPoint with such entrant id", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    public ArrayList<CTPoint> findCTPointBySubjectId(int subjectId) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement = cn.prepareStatement(FIND_CTPOINT_BY_SUBJECT_ID);
            preparedStatement.setInt(1, subjectId);
            ResultSet resultSet = preparedStatement.executeQuery();
            return initCTPoints(resultSet);
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while finding CTPoint with such subject id", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    @Override
    public CTPoint deleteCTPoint(CTPoint ctPoint) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement = cn.prepareStatement(DELETE_CTPOINT);
            preparedStatement.setInt(1, ctPoint.getEntrantId());
            preparedStatement.setInt(2, ctPoint.getSubjectId());
            preparedStatement.executeUpdate();
            return null;
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while deleting CTPoint from a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }
}
