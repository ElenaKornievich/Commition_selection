package com.kornievich.selectionCommition.dao.impl;

import com.kornievich.selectionCommition.entity.EntrantInQueueModal;
import com.kornievich.selectionCommition.exception.ConnectionUnavailException;
import com.kornievich.selectionCommition.pool.impl.ConnectionPool;
import com.kornievich.selectionCommition.poolMy.ConnectionPool2;

import java.sql.*;
import java.util.ArrayList;

public class RequestsDAO {
    private static final String ALL_ENTRANT_SCORE_BY_SPESIALTY = "SELECT en.EntrantID, en.Surname, en.FirstName, en.LastName, (SELECT SUM(ctpoints.Score)\n" +
            "FROM ctpoints\n" +
            "WHERE ctpoints.EntrantId=en.EntrantID)+en.Score*10 AS Scores\n" +
            "FROM entrants as en\n" +
            "INNER JOIN ctpoints e ON en.EntrantId = e.EntrantID\n" +
            "  WHERE en.SpecialtyID=?\n" +
            "GROUP BY en.EntrantID\n" +
            "ORDER BY Scores DESC;";
    private static final String ALL_SPESIALTY = "SELECT SpecialtyID FROM specialties";
    public  ArrayList<EntrantInQueueModal> allScoreBySpesialty(int idSpesialty){
        Connection cn = ConnectionPool.getInstance().takeConnection();
        ArrayList<EntrantInQueueModal> entrant = new ArrayList<>();
        try {

            PreparedStatement preparedStatement=cn.prepareStatement(ALL_ENTRANT_SCORE_BY_SPESIALTY);
            preparedStatement.setInt(1, idSpesialty);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet!=null) {
                while (resultSet.next()) {
                    entrant.add(new EntrantInQueueModal(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5)));
                }
                return entrant;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
        return null;
    }
    public ArrayList<Integer> allIdSpesialty(){
        Connection cn = ConnectionPool.getInstance().takeConnection();
        try {
            Statement statement=cn.createStatement();
           ResultSet resultSet= statement.executeQuery(ALL_SPESIALTY);
           if(resultSet!=null) {
               ArrayList<Integer> allIdSpesialty = new ArrayList<>();
               while (resultSet.next()) {
                   allIdSpesialty.add(resultSet.getInt(1));
               }
               return allIdSpesialty;
           }
           return null;
        }  catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
        return null;

    }
}
