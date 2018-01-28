package com.kornievich.selectionCommition.dao.impl;

import com.kornievich.selectionCommition.dao.ISpecialityDAO;
import com.kornievich.selectionCommition.entity.Speciality;
import com.kornievich.selectionCommition.exception.ConnectionUnavailException;
import com.kornievich.selectionCommition.pool.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;

public class SpecialityDAO implements ISpecialityDAO {

    private static final String READ_SPECIALITY_ALL = "SELECT * FROM selection_commition.specialties";
    private static final String FIND_SPECIALITY_BY_ID = "SELECT * FROM selection_commition.specialties WHERE SpecialtyID=?";
    private static final String FIND_SPECIALITY_BY_NAME = "SELECT * FROM selection_commition.specialties WHERE SpecialtyName=?";
    private static final String CREATE_SPECIALITY = "INSERT INTO selection_commition.specialties (SpecialtyID , SpecialtyName , FacultyID, NumberOfBudgetPlaces, NumberOfPaidPlaces) VALUES (?,?,?,?,?)";
    private static final String UPDATE_SPECIALITY = "UPDATE selection_commition.specialties SET selection_commition.specialties.SpecialtyName = ?, " +
            "selection_commition.specialties.FacultyID=?, selection_commition.specialties.NumberOfBudgetPlaces=?," +
            "selection_commition.specialties.NumberOfPaidPlaces=? WHERE SpecialtyID=?;";
    private static final String DELETE_SPECIALITY = "DELETE FROM selection_commition.specialties WHERE selection_commition.specialties.SpecialtyID=?";


    private ArrayList<Speciality> createSpecialities(ResultSet resultSet) throws SQLException {
        ArrayList<Speciality> listSpeciality = new ArrayList<>();
        while (resultSet.next()){
            Speciality speciality=new Speciality(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getInt(3), resultSet.getInt(4), resultSet.getInt(5));
            listSpeciality.add(speciality);
        }
        return listSpeciality;
    }

    private Speciality createSpeciality(ResultSet resultSet) throws SQLException {
        resultSet.next();
        return new Speciality(resultSet.getInt(1), resultSet.getString(2),
                resultSet.getInt(3), resultSet.getInt(4), resultSet.getInt(5));

    }


    @Override
    public boolean create(Speciality speciality) {
        Connection cn=null;
        try {
            cn= ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement(CREATE_SPECIALITY);
            preparedStatement.setInt(1, speciality.getId());
            preparedStatement.setString(2, speciality.getName());
            preparedStatement.setInt(3,speciality.getFacultyId());
            preparedStatement.setInt(4, speciality.getNumberBudgetPlace());
            preparedStatement.setInt(5, speciality.getNumberPaidPlace());
            preparedStatement.executeUpdate();
            return true;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ConnectionUnavailException e) {
            e.printStackTrace();
        }finally {

            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.err.println("Сonnection close error: " + e);
                }
            }

        }
        return false;
    }

    @Override
    public ArrayList<Speciality> readAll() {
        Connection cn= null;
        try {
            cn = ConnectionPool.getInstance().getConnection();
            Statement statement=cn.createStatement();
            ResultSet resultSet= statement.executeQuery(READ_SPECIALITY_ALL);
            return createSpecialities(resultSet);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ConnectionUnavailException e) {
            e.printStackTrace();
        }finally {

            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.err.println("Сonnection close error: " + e);
                }
            }

        }

        return null;
    }

    @Override
    public boolean update(Speciality speciality) {
        Connection cn=null;
        try {
            cn= ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement(UPDATE_SPECIALITY);

            preparedStatement.setString(1, speciality.getName());
            preparedStatement.setInt(2,speciality.getFacultyId());
            preparedStatement.setInt(3, speciality.getNumberBudgetPlace());
            preparedStatement.setInt(4, speciality.getNumberPaidPlace());
            preparedStatement.setInt(5, speciality.getId());
            preparedStatement.executeUpdate();
            return true;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ConnectionUnavailException e) {
            e.printStackTrace();
        }finally {

            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.err.println("Сonnection close error: " + e);
                }
            }

        }
        return false;
    }

    @Override
    public Speciality delete(Speciality speciality) {
        Connection cn=null;
        try {
            cn=ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement(DELETE_SPECIALITY);
            preparedStatement.setInt(1, speciality.getId());
            preparedStatement.executeUpdate();
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ConnectionUnavailException e) {
            e.printStackTrace();
        }finally {

            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.err.println("Сonnection close error: " + e);
                }
            }

        }
        return speciality;
    }

    @Override
    public Speciality findSpecialityById(int id) {
        Connection cn=null;
        try {
            cn=ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement(FIND_SPECIALITY_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return createSpeciality(resultSet);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ConnectionUnavailException e) {
            e.printStackTrace();
        }finally {

            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.err.println("Сonnection close error: " + e);
                }
            }

        }
        return null;

    }

    @Override
    public Speciality findSpecialityByName(String name) {
        Connection cn=null;
        try {
       cn=ConnectionPool.getInstance().getConnection();
        PreparedStatement preparedStatement=cn.prepareStatement(FIND_SPECIALITY_BY_NAME);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        Speciality speciality= createSpeciality(resultSet);
        return speciality;
    } catch (InterruptedException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ConnectionUnavailException e) {
        e.printStackTrace();
    }
    finally {

        if (cn != null) {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println("Сonnection close error: " + e);
            }
        }


    }
        return null;
    }
}
