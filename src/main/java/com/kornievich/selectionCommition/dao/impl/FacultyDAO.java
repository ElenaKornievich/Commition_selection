package com.kornievich.selectionCommition.dao.impl;

import com.kornievich.selectionCommition.dao.IFacultyDAO;
import com.kornievich.selectionCommition.entity.Faculty;
import com.kornievich.selectionCommition.exception.ConnectionUnavailException;
import com.kornievich.selectionCommition.pool.impl.ConnectionPool;
import com.kornievich.selectionCommition.poolMy.ConnectionPool2;

import java.sql.*;
import java.util.ArrayList;

public class FacultyDAO implements IFacultyDAO{

    private static final String READ_FACULTY_ALL = "SELECT * FROM selection_commition.faculties";
    private static final String FIND_FACULTY_BY_ID = "SELECT * FROM selection_commition.faculties WHERE FacultyID=?";
    private static final String FIND_FACULTY_BY_NAME = "SELECT * FROM selection_commition.faculties WHERE FacultyName=?";
    private static final String CREATE_FACULTY = "INSERT INTO selection_commition.faculties (FacultyName , StartDateOfFiling, EndDateOfFiling) VALUES (?,?,?)";
    private static final String UPDATE_FACULTY = "UPDATE selection_commition.faculties SET selection_commition.faculties.FacultyName = ?, " +
            "selection_commition.faculties.StartDateOfFiling=?, selection_commition.faculties.EndDateOfFiling=? WHERE FacultyID=?;";
    private static final String DELETE_FACULTY = "DELETE FROM selection_commition.faculties WHERE selection_commition.faculties.FacultyID=?";



    private ArrayList<Faculty> createFacylties(ResultSet resultSet) throws SQLException {
        if(resultSet!=null) {
            ArrayList<Faculty> listFaculty = new ArrayList<>();
            while (resultSet.next()) {
                Faculty faculty = new Faculty(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4));
                listFaculty.add(faculty);
            }
            return listFaculty;
        }
        return null;
    }

    private Faculty createFaculty(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Faculty(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4));
        }
        return null;
    }


    @Override
    public Faculty create(String name, String startDate, String endDate) {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement=cn.prepareStatement(CREATE_FACULTY);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, startDate);
            preparedStatement.setString(3, endDate);
            preparedStatement.executeUpdate();

            return findFacultyByName(name);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }

        return null;
    }

    @Override
    public ArrayList<Faculty> readAll() {
        Connection cn = ConnectionPool.getInstance().takeConnection();

        try {

            Statement statement=cn.createStatement();
            ResultSet resultSet = statement.executeQuery(READ_FACULTY_ALL);
            return createFacylties(resultSet);
        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
        return null;
    }

    @Override
    public boolean update(Faculty faculty) {
        Connection cn = ConnectionPool.getInstance().takeConnection();

        try {
            PreparedStatement preparedStatement=cn.prepareStatement(UPDATE_FACULTY);
            preparedStatement.setString(1, faculty.getName());
            preparedStatement.setString(2, faculty.getStartDateOfFiling());
            preparedStatement.setString(3, faculty.getEndDateOfFiling());
            preparedStatement.setInt(4, faculty.getId());
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
        return false;
    }

    @Override
    public boolean delete(int facultyId) {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement=cn.prepareStatement(DELETE_FACULTY);
            preparedStatement.setInt(1, facultyId);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
        return false;
    }

    @Override
    public Faculty findFacultyById(int id) {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement=cn.prepareStatement(FIND_FACULTY_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return createFaculty(resultSet);
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
        return null;
    }

    @Override
    public Faculty findFacultyByName(String name) {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement=cn.prepareStatement(FIND_FACULTY_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            return createFaculty(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
        return null;
    }
}
