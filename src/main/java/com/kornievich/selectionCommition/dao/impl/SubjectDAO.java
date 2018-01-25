package com.kornievich.selectionCommition.dao.impl;

import com.kornievich.selectionCommition.dao.ISubjectDAO;
import com.kornievich.selectionCommition.entity.Subject;
import com.kornievich.selectionCommition.exception.ConnectionUnavailException;
import com.kornievich.selectionCommition.pool.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;

public class SubjectDAO  implements ISubjectDAO{

    private static final String READ_SUBJECT_ALL = "SELECT * FROM selection_commition.subjects";
    private static final String FIND_SUBJECT_BY_ID = "SELECT * FROM selection_commition.subjects WHERE SubjectID=?";
    private static final String FIND_SUBJECT_BY_NAME = "SELECT * FROM selection_commition.subjects WHERE SubjectName=?";
    private static final String CREATE_SUBJECT = "INSERT INTO selection_commition.subjects (SubjectID, SubjectName ) VALUES (?,?)";
    private static final String DELETE_SUBJECT = "DELETE FROM selection_commition.subjects WHERE selection_commition.subjects.SubjectID=? ";
    private static final String UPDATE_SUBJECT_NAME = "UPDATE selection_commition.subjects SET selection_commition.subjects.SubjectName = ? WHERE SubjectID=?;";
    private static final String UPDATE_SUBJECT_ID = "UPDATE selection_commition.subjects SET selection_commition.subjects.SubjectID = ? WHERE SubjectName=?;";


    private ArrayList<Subject> createSubjects(ResultSet resultSet) throws SQLException {
        ArrayList<Subject> listSubject=new ArrayList<>();
        while (resultSet.next()){
            Subject subject=new Subject(resultSet.getInt(1), resultSet.getString(2));
            listSubject.add(subject);
        }
        return listSubject;
    }

    private Subject createSubject(ResultSet resultSet) throws SQLException {
        resultSet.next();
        return new Subject(resultSet.getInt(1), resultSet.getString(2));
    }

    @Override
    public boolean create(Subject subject) {
        try {
            Connection cn= ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement(CREATE_SUBJECT);
            preparedStatement.setInt(1, subject.getId());
            preparedStatement.setString(2, subject.getName());
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
    public ArrayList<Subject> readAll() {
        try {
            Connection cn=ConnectionPool.getInstance().getConnection();
            Statement statement=cn.createStatement();
            ResultSet resultSet = statement.executeQuery(READ_SUBJECT_ALL);
            return createSubjects(resultSet);
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
    public boolean updateSubjectName(Subject subject) {
        try {
            Connection cn=ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement(UPDATE_SUBJECT_NAME);
            preparedStatement.setString(1, subject.getName());
            preparedStatement.setInt(2, subject.getId());
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
    public boolean updateSubjectId(Subject subject) {
        try {
            Connection cn=ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement(UPDATE_SUBJECT_ID);
            preparedStatement.setInt(2, subject.getId());
            preparedStatement.setString(3, subject.getName());
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
    public Subject delete(Subject subject) {
        try {
            Connection cn=ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement(DELETE_SUBJECT);
            preparedStatement.setInt(1, subject.getId());
            preparedStatement.executeUpdate();
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ConnectionUnavailException e) {
            e.printStackTrace();
        }
        return subject;

    }

    @Override
    public Subject findSubjectById(int id) {
        Connection cn= null;
        try {
            cn = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement(FIND_SUBJECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet=preparedStatement.executeQuery();
            return createSubject(resultSet);
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
    public Subject findSubjectByName(String name) {
        Connection cn= null;
        try {
            cn = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement(FIND_SUBJECT_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet=preparedStatement.executeQuery();
            return createSubject(resultSet);
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
