package com.kornievich.selectionCommition.dao;

import com.kornievich.selectionCommition.entity.Entrant;
import com.kornievich.selectionCommition.exception.ConnectionUnavailException;
import com.kornievich.selectionCommition.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
            } else System.out.println("Всё плохо, здесь ошибка в коннесшне");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
