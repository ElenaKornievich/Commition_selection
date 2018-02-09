package com.kornievich.selectionCommition.dao.impl;

import com.kornievich.selectionCommition.dao.IFacultySubjectsDAO;
import com.kornievich.selectionCommition.entity.FacultySubject;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.pool.impl.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;

public class FacultySubjectDAO implements IFacultySubjectsDAO{

    private static final String READ_FACULTY_SUBJECT_ALL = "SELECT * FROM selection_commition.facultysubjects";
    private static final String FIND_FACULTY_SUBJECT_BY_FUCULTY_ID = "SELECT * FROM selection_commition.facultysubjects WHERE FacultyID=?";
    private static final String FIND_FACULTY_SUBJECT_BY_SUBJECT_ID = "SELECT * FROM selection_commition.facultysubjects WHERE SubjectId=?";
    private static final String CREATE_FACULTY_SUBJECT = "INSERT INTO selection_commition.facultysubjects (FacultyID, SubjectId ) VALUES (?,?)";
    private static final String DELETE_FACULTY_SUBJECT = "DELETE FROM selection_commition.facultysubjects WHERE selection_commition.facultysubjects.FacultyID=? AND selection_commition.facultysubjects.SubjectId=?";
    private static final String UPDATE_FACULTY_SUBJECT = "UPDATE selection_commition.facultysubjects SET selection_commition.facultysubjects.FacultyId = ?, " +
            "selection_commition.facultysubjects.SubjectId=?";

    @Override
    public boolean updateFacultySubject(FacultySubject facultySubject) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement=cn.prepareStatement(UPDATE_FACULTY_SUBJECT);
            preparedStatement.setInt(1, facultySubject.getFacultyId());
            preparedStatement.setInt(2, facultySubject.getSubjectId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while updating faculty subject in a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }


    private ArrayList<FacultySubject> initFacultySubjects(ResultSet resultSet) throws SQLException {
        ArrayList<FacultySubject> listFacultySubject = new ArrayList<>();
            while (resultSet.next()) {
                FacultySubject facultySubject = new FacultySubject(resultSet.getInt(1), resultSet.getInt(2));
                listFacultySubject.add(facultySubject);
            }
            return listFacultySubject;
    }

    private FacultySubject initFacultySubject(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new FacultySubject(resultSet.getInt(1), resultSet.getInt(2));
        }
        return null;
    }

    @Override
    public boolean createFacultySubject(FacultySubject facultySubject) throws DAOException{
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement=cn.prepareStatement(CREATE_FACULTY_SUBJECT);
            preparedStatement.setInt(1, facultySubject.getFacultyId());
            preparedStatement.setInt(2, facultySubject.getSubjectId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while creating faculty subject in a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    @Override
    public ArrayList<FacultySubject> readAllFacultySubject() throws DAOException{
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            Statement statement=cn.createStatement();
            ResultSet resultSet = statement.executeQuery(READ_FACULTY_SUBJECT_ALL);
            return initFacultySubjects(resultSet);
        }  catch (SQLException e) {
            throw new DAOException("SQLException occurred while reading faculty subject from a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }


    @Override
    public FacultySubject deleteFacultySubject(FacultySubject facultySubject) throws DAOException{
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement=cn.prepareStatement(DELETE_FACULTY_SUBJECT);
            preparedStatement.setInt(1, facultySubject.getFacultyId());
            preparedStatement.setInt(2, facultySubject.getSubjectId());
            preparedStatement.executeUpdate();
            return null;
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while deleting faculty subject from a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    @Override
    public ArrayList<FacultySubject> findFacultySubjectsByFacultyId(int id) throws DAOException{
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement=cn.prepareStatement(FIND_FACULTY_SUBJECT_BY_FUCULTY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet=preparedStatement.executeQuery();
            return initFacultySubjects(resultSet);
        }  catch (SQLException e) {
            throw new DAOException("SQLException occurred while finding faculty subject with such faculty id", e);
        }finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    @Override
    public ArrayList<FacultySubject> findFacultySubjectsBySubjectId(int id) throws DAOException{

        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {

            PreparedStatement preparedStatement=cn.prepareStatement(FIND_FACULTY_SUBJECT_BY_SUBJECT_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet=preparedStatement.executeQuery();
            return initFacultySubjects(resultSet);
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while finding faculty subjects with such subject id", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }
}
