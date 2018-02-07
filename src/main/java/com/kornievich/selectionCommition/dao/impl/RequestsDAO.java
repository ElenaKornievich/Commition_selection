package com.kornievich.selectionCommition.dao.impl;

import com.kornievich.selectionCommition.exception.ConnectionUnavailException;
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
    public  ArrayList<Integer> allScoreBySpesialty(int idSpesialty){
        Connection cn=null;
        ArrayList<Integer> entrant = new ArrayList<>();
        try {
            cn= ConnectionPool2.getInstance().getConnection();
            PreparedStatement preparedStatement=cn.prepareStatement(ALL_ENTRANT_SCORE_BY_SPESIALTY);
            preparedStatement.setInt(1, idSpesialty);
            ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    entrant.add(resultSet.getInt(5));
                }
            return entrant;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ConnectionUnavailException e) {
            e.printStackTrace();
        }
        finally {
            if(cn!=null){
                try {
                    cn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    public ArrayList<Integer> allIdSpesialty(){
        Connection cn=null;
        try {
            cn= ConnectionPool2.getInstance().getConnection();
            Statement statement=cn.createStatement();
           ResultSet resultSet= statement.executeQuery(ALL_SPESIALTY);
           ArrayList<Integer> allIdSpesialty = new ArrayList<>();
           while (resultSet.next()){
               allIdSpesialty.add(resultSet.getInt(1));
           }
            return allIdSpesialty;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ConnectionUnavailException e) {
            e.printStackTrace();
        }
        finally {
            if(cn!=null){
                try {
                    cn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;

    }
}
