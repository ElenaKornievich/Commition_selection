package com.kornievich.selectionCommition.dao;

import com.kornievich.selectionCommition.entity.Entrant;
import com.kornievich.selectionCommition.exception.ConnectionUnavailException;
import com.kornievich.selectionCommition.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EntrantDAO {
    public boolean create(Entrant entrant) {
        Connection cn = null;
        //Statement st = null;
        try {

            try {
                cn = ConnectionPool.getInstance().getConnection();
            } catch (InterruptedException | ConnectionUnavailException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (cn != null) {
                PreparedStatement preparedStatement =
                        cn.prepareStatement("INSERT INTO selection_commition.entrants VALUES (?,?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                 preparedStatement.setInt(1, entrant.getId());
                preparedStatement.setString(2, entrant.getDateOfFilling());
                preparedStatement.setInt(3,entrant.getSpecialityId());
                preparedStatement.setString(4,entrant.getPasportSeries());
                preparedStatement.setInt(5,entrant.getPassportNumber());
                preparedStatement.setString(6,entrant.getSurname());
                preparedStatement.setString(7,entrant.getFirstName());
                preparedStatement.setString(8,entrant.getLastName());
                preparedStatement.setString(9,entrant.getDateOfIssue());
                preparedStatement.setString(10,entrant.getIdentificationNumber());
                preparedStatement.setString(11,entrant.getDateOfBirth());
                preparedStatement.setString(12,entrant.getNationality());
                preparedStatement.setString(13,entrant.getTelephoneNumber());
                preparedStatement.setString(14,entrant.getResidenceAddress());
                preparedStatement.setDouble(15,entrant.getScore());
                preparedStatement.setBoolean(16,entrant.isGoldMedal());
                preparedStatement.setString(17,entrant.getEmail());

                preparedStatement.executeUpdate();
                return true;
            } else System.out.println("Всё плохо, здесь ошибка в коннесшне");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public Entrant readEntrantById(int id){
        try {
            Connection cn=ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement("SELECT * FROM selection_commition.entrants WHERE EntrantID=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet=preparedStatement.executeQuery();
            return createEntrant(resultSet);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ConnectionUnavailException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Entrant> readEntrantByName(String name){
        try {
            ArrayList<Entrant> listEntrants=new ArrayList<>();
            Connection cn=ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement("SELECT * FROM selection_commition.entrants WHERE entrants.FirstName=?");
            preparedStatement.setString(1, name);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                listEntrants.add(createEntrant(resultSet));
            }
            return listEntrants;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ConnectionUnavailException e) {
            e.printStackTrace();
        }
        return null;
    }

     private Entrant createEntrant(ResultSet resultSet) {
         try {
             return new Entrant(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),
                      resultSet.getString(4),resultSet.getInt(5), resultSet.getString(6),
                      resultSet.getString(7), resultSet.getString(8), resultSet.getString(9),
                      resultSet.getString(10), resultSet.getString(11), resultSet.getString(12),
                      resultSet.getString(13), resultSet.getString(14), resultSet.getInt(15), resultSet.getBoolean(16),
                      resultSet.getString(17));
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return null;
     }
}
