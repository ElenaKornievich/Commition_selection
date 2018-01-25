package com.kornievich.selectionCommition.dao.impl;

import com.kornievich.selectionCommition.dao.IFacultyDAO;
import com.kornievich.selectionCommition.entity.Faculty;
import com.kornievich.selectionCommition.exception.ConnectionUnavailException;
import com.kornievich.selectionCommition.pool.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;

public class FacultyDAO implements IFacultyDAO{

    private static final String READ_FACULTY_ALL = "SELECT * FROM selection_commition.faculties";
    private static final String FIND_FACULTY_BY_ID = "SELECT * FROM selection_commition.faculties WHERE FacultyID=?";
    private static final String FIND_FACULTY_BY_NAME = "SELECT * FROM selection_commition.faculties WHERE FacultyName=?";
    private static final String CREATE_FACULTY = "INSERT INTO selection_commition.faculties (FacultyID, FacultyName , StartDateOfFiling, EndDateOfFiling) VALUES (?,?,?,?)";
    private static final String UPDATE_FACULTY = "UPDATE selection_commition.faculties SET selection_commition.faculties.FacultyName = ?, " +
            "selection_commition.faculties.StartDateOfFiling=?, selection_commition.faculties.EndDateOfFiling WHERE FacultyID=?;";
    private static final String DELETE_FACULTY = "DELETE FROM selection_commition.faculties WHERE selection_commition.faculties.FacultyID=?";



    private ArrayList<Faculty> createFacylties(ResultSet resultSet) throws SQLException {
        ArrayList<Faculty> listFaculty = new ArrayList<>();
        while (resultSet.next()){
            Faculty faculty=new Faculty(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4));
            listFaculty.add(faculty);
        }
        return listFaculty;
    }

    private Faculty createFaculty(ResultSet resultSet) throws SQLException {
        resultSet.next();
        return new Faculty(resultSet.getInt(1), resultSet.getString(2),
                resultSet.getString(3), resultSet.getString(4));
    }


    @Override
    public boolean create(Faculty faculty) {
        try {
            Connection cn= ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement(CREATE_FACULTY);
            preparedStatement.setInt(1, faculty.getId());
            preparedStatement.setString(2, faculty.getName());
            preparedStatement.setString(3, faculty.getStartDateOfFiling());
            preparedStatement.setString(4, faculty.getEndDataOfFiling());
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
    public ArrayList<Faculty> readAll() {
        try {
            Connection cn=ConnectionPool.getInstance().getConnection();
            Statement statement=cn.createStatement();
            ResultSet resultSet = statement.executeQuery(READ_FACULTY_ALL);
            return createFacylties(resultSet);
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
    public boolean update(Faculty faculty) {
        try {
            Connection cn=ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement(UPDATE_FACULTY);
            preparedStatement.setString(1, faculty.getName());
            preparedStatement.setString(2, faculty.getStartDateOfFiling());
            preparedStatement.setString(3, faculty.getEndDataOfFiling());
            preparedStatement.setInt(4, faculty.getId());
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
    public Faculty delete(Faculty faculty) {
        try {
            Connection cn=ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement(DELETE_FACULTY);
            preparedStatement.setInt(1, faculty.getId());
            preparedStatement.executeUpdate();
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ConnectionUnavailException e) {
            e.printStackTrace();
        }
        return faculty;
    }

    @Override
    public Faculty findFacultyById(int id) {
        try {
            Connection cn=ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement(FIND_FACULTY_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return createFaculty(resultSet);
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
    public ArrayList<Faculty> findFacultyByName(String name) {
        try {
            ArrayList<Faculty> listFaculty;
            Connection cn=ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement(FIND_FACULTY_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            return createFacylties(resultSet);
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
