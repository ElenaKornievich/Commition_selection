package com.kornievich.selectionCommition.dao.impl;

import com.kornievich.selectionCommition.dao.IFacultySubjectsDAO;
import com.kornievich.selectionCommition.entity.Faculty;
import com.kornievich.selectionCommition.entity.FacultySubject;
import com.kornievich.selectionCommition.exception.ConnectionUnavailException;
import com.kornievich.selectionCommition.pool.ConnectionPool;

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
    public boolean update(FacultySubject facultySubject) {
        try {
            Connection cn=ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement(UPDATE_FACULTY_SUBJECT);
            preparedStatement.setInt(1, facultySubject.getFacultyId());
            preparedStatement.setInt(2, facultySubject.getSubjectId());
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


    private ArrayList<FacultySubject> createFacultySubjects(ResultSet resultSet) throws SQLException {
        ArrayList<FacultySubject> listFacultySubject=new ArrayList<>();
        while (resultSet.next()){
            FacultySubject facultySubject=new FacultySubject(resultSet.getInt(1), resultSet.getInt(2));
            listFacultySubject.add(facultySubject);
        }
        return listFacultySubject;
    }

    private FacultySubject createFacultySubject(ResultSet resultSet) throws SQLException {
       resultSet.next();
            return new FacultySubject(resultSet.getInt(1), resultSet.getInt(2));
    }

    @Override
    public boolean create(FacultySubject facultySubject) {
        try {
            Connection cn= ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement(CREATE_FACULTY_SUBJECT);
            preparedStatement.setInt(1, facultySubject.getFacultyId());
            preparedStatement.setInt(2, facultySubject.getSubjectId());
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
    public ArrayList<FacultySubject> readAll() {
        try {
            Connection cn=ConnectionPool.getInstance().getConnection();
            Statement statement=cn.createStatement();
            ResultSet resultSet = statement.executeQuery(READ_FACULTY_SUBJECT_ALL);
            return createFacultySubjects(resultSet);
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
    public FacultySubject delete(FacultySubject facultySubject) {
        try {
            Connection cn=ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement(DELETE_FACULTY_SUBJECT);
            preparedStatement.setInt(1, facultySubject.getFacultyId());
            preparedStatement.setInt(2, facultySubject.getSubjectId());
            preparedStatement.executeUpdate();
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ConnectionUnavailException e) {
            e.printStackTrace();
        }
        return facultySubject;
    }

    @Override
    public ArrayList<FacultySubject> findByFacultyId(int id) {
        Connection cn= null;
        try {
            cn = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement(FIND_FACULTY_SUBJECT_BY_FUCULTY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet=preparedStatement.executeQuery();
            return createFacultySubjects(resultSet);
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
    public ArrayList<FacultySubject> findBySubjectId(int id) {

        Connection cn= null;
        try {
            cn = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement(FIND_FACULTY_SUBJECT_BY_SUBJECT_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet=preparedStatement.executeQuery();
            return createFacultySubjects(resultSet);
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
