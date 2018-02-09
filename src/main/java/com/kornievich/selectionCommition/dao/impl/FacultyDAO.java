package com.kornievich.selectionCommition.dao.impl;

import com.kornievich.selectionCommition.dao.IFacultyDAO;
import com.kornievich.selectionCommition.entity.Faculty;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.pool.impl.ConnectionPool;

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



    private ArrayList<Faculty> initFaculties(ResultSet resultSet) throws SQLException {
            ArrayList<Faculty> listFaculty = new ArrayList<>();
            while (resultSet.next()) {
                Faculty faculty = new Faculty(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4));
                listFaculty.add(faculty);
            }
            return listFaculty;
    }

    private Faculty initFaculty(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Faculty(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4));
        }
        return null;
    }


    @Override
    public Faculty createFaculty(String name, String startDate, String endDate) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement=cn.prepareStatement(CREATE_FACULTY);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, startDate);
            preparedStatement.setString(3, endDate);
            preparedStatement.executeUpdate();
            ConnectionPool.getInstance().returnConnection(cn);
            return findFacultyByName(name);
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while creating faculty in a database", e);
        }finally {
            if(cn!=null) {
                ConnectionPool.getInstance().returnConnection(cn);
            }
        }
    }

    @Override
    public ArrayList<Faculty> readAllFaculties() throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            Statement statement=cn.createStatement();
            ResultSet resultSet = statement.executeQuery(READ_FACULTY_ALL);
            return initFaculties(resultSet);
        }  catch (SQLException e) {
            throw new DAOException("SQLException occurred while reading faculties from a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    @Override
    public boolean updateFaculty(Faculty faculty) throws DAOException{
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
            throw new DAOException("SQLException occurred while updating faculty in a database", e);
        }finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    @Override
    public boolean deleteFaculty(int facultyId) throws DAOException{
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement=cn.prepareStatement(DELETE_FACULTY);
            preparedStatement.setInt(1, facultyId);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while deleting faculty from a database", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    @Override
    public Faculty findFacultyById(int id) throws DAOException{
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement=cn.prepareStatement(FIND_FACULTY_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return initFaculty(resultSet);
        }catch (SQLException e) {
            throw new DAOException("SQLException occurred while finding faculty with such id", e);
        }finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }

    @Override
    public Faculty findFacultyByName(String name) throws DAOException{
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            PreparedStatement preparedStatement=cn.prepareStatement(FIND_FACULTY_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            return initFaculty(resultSet);
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while finding faculty with such name", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }
}
