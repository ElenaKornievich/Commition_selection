package com.kornievich.selectionCommition.dao.impl;

import com.kornievich.selectionCommition.dao.ICTPointDAO;
import com.kornievich.selectionCommition.entity.CTPoint;
import com.kornievich.selectionCommition.exception.ConnectionUnavailException;
import com.kornievich.selectionCommition.pool.ConnectionPool;

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
    public boolean create(CTPoint ctPoint) {
        try {
            Connection cn= ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement(CREATE_CTPOINT);
            preparedStatement.setInt(1, ctPoint.getSubjectId());
            preparedStatement.setInt(2, ctPoint.getEntrantId());
            preparedStatement.setInt(3, ctPoint.getScope());



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
    private ArrayList<CTPoint> readCTPoint(ResultSet resultSet) throws SQLException {
        ArrayList<CTPoint> listCTPoint=new ArrayList<>();
        while (resultSet.next()) {
            CTPoint ctPoint = new CTPoint(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3));
            listCTPoint.add(ctPoint);
        }
        return listCTPoint;
    }
    private CTPoint createCTPoint(ResultSet resultSet) throws SQLException {
        resultSet.next();
            return new CTPoint(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3));
    }

    @Override
    public ArrayList<CTPoint> readAll() {
        try {
            Connection cn=ConnectionPool.getInstance().getConnection();
            Statement statement = cn.createStatement();

            ResultSet resultSet = statement.executeQuery(READ_ALL);
          return readCTPoint(resultSet);
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
    public boolean update(CTPoint ctPoint) {
        try {
            Connection cn= ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement(UPDATE_CTPOINT);

            preparedStatement.setInt(1, ctPoint.getScope());
            preparedStatement.setInt(2, ctPoint.getEntrantId());
            preparedStatement.setInt(3, ctPoint.getSubjectId());

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

    public ArrayList<CTPoint> findCTPointByEntrantId(int entrantId){
        ArrayList<CTPoint> ctPoints=new ArrayList<>();
        try {
            Connection cn=ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement =cn.prepareStatement(FIND_CTPOINT_BY_ENTRANT_ID);
            preparedStatement.setInt(1,entrantId);
            ResultSet resultSet=preparedStatement.executeQuery();
           return readCTPoint(resultSet);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ConnectionUnavailException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<CTPoint> findCTPointBySubjectId(int subjectId){
        ArrayList<CTPoint> ctPoints=new ArrayList<>();
        try {
            Connection cn=ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement =cn.prepareStatement(FIND_CTPOINT_BY_SUBJECT_ID);
            preparedStatement.setInt(1,subjectId);
            ResultSet resultSet=preparedStatement.executeQuery();
            return readCTPoint(resultSet);
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
    public CTPoint delete(CTPoint ctPoint) {
        try {
            Connection cn=ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement(DELETE_CTPOINT);
            preparedStatement.setInt(1,ctPoint.getEntrantId());
            preparedStatement.setInt(2, ctPoint.getSubjectId());
            preparedStatement.executeUpdate();
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ConnectionUnavailException e) {
            e.printStackTrace();
        }
        return ctPoint;
    }
}
