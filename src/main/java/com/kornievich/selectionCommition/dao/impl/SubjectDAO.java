package com.kornievich.selectionCommition.dao.impl;

import com.kornievich.selectionCommition.dao.ISubjectDAO;
import com.kornievich.selectionCommition.entity.Subject;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.pool.impl.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;

public class SubjectDAO  implements ISubjectDAO{

    private static final String READ_SUBJECT_ALL = "SELECT * FROM selection_commition.subjects";
    private static final String FIND_SUBJECT_BY_ID = "SELECT * FROM selection_commition.subjects WHERE SubjectID=?";
    private static final String FIND_SUBJECT_BY_NAME = "SELECT * FROM selection_commition.subjects WHERE SubjectName=?";
    private static final String CREATE_SUBJECT = "INSERT INTO selection_commition.subjects (SubjectName ) VALUES (?)";
    private static final String DELETE_SUBJECT = "DELETE FROM selection_commition.subjects WHERE selection_commition.subjects.SubjectID=? ";
    private static final String UPDATE_SUBJECT_NAME = "UPDATE selection_commition.subjects SET selection_commition.subjects.SubjectName = ? WHERE SubjectID=?;";
    private static final String UPDATE_SUBJECT_ID = "UPDATE selection_commition.subjects SET selection_commition.subjects.SubjectID = ? WHERE SubjectName=?;";


    private ArrayList<Subject> initSubjects(ResultSet resultSet) throws SQLException {
        ArrayList<Subject> listSubject = new ArrayList<>();
            while (resultSet.next()) {
                Subject subject = new Subject(resultSet.getInt(1), resultSet.getString(2));
                listSubject.add(subject);
            }
            return listSubject;
    }

    private Subject initSubject(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Subject(resultSet.getInt(1), resultSet.getString(2));
        }
        return null;
    }

    @Override
    public Subject createSubject(String name) throws DAOException{
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement=cn.prepareStatement(CREATE_SUBJECT);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            return findSubjectByName(name);
        }catch (SQLException e) {
            throw new DAOException("SQLException occurred while creating subject in a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    @Override
    public ArrayList<Subject> readAllSubjects() throws DAOException{
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            Statement statement=cn.createStatement();
            ResultSet resultSet = statement.executeQuery(READ_SUBJECT_ALL);
            return initSubjects(resultSet);
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while reading all subjects", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    @Override
    public boolean updateSubjectName(Subject subject) throws DAOException{
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement=cn.prepareStatement(UPDATE_SUBJECT_NAME);
            preparedStatement.setString(1, subject.getName());
            preparedStatement.setInt(2, subject.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while updating subject name in a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    @Override
    public boolean updateSubjectId(Subject subject) throws DAOException{
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement=cn.prepareStatement(UPDATE_SUBJECT_ID);
            preparedStatement.setInt(1, subject.getId());
            preparedStatement.setString(2, subject.getName());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while updating subject id in a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    @Override
    public boolean deleteSubject(int subjectId) throws DAOException{
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement=cn.prepareStatement(DELETE_SUBJECT);
            preparedStatement.setInt(1, subjectId);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while deleting subject from a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    @Override
    public Subject findSubjectById(int id) throws DAOException{
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement=cn.prepareStatement(FIND_SUBJECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet=preparedStatement.executeQuery();
            return initSubject(resultSet);
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while finding subject with such id", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    @Override
    public Subject findSubjectByName(String name) throws DAOException{
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement=cn.prepareStatement(FIND_SUBJECT_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet=preparedStatement.executeQuery();
            return initSubject(resultSet);
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while finding subject with such name", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }
}
