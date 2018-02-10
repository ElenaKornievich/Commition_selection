package com.kornievich.selectionCommition.dao.impl;

import com.kornievich.selectionCommition.dao.IRequest;
import com.kornievich.selectionCommition.entity.EntrantInQueueModal;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.pool.impl.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;

public class RequestDAO implements IRequest {
    private static final String ALL_ENTRANT_SCORE_BY_SPESIALTY = "SELECT en.EntrantID, en.Surname, en.FirstName, en.LastName, (SELECT SUM(ctpoints.Score)\n" +
            "FROM ctpoints\n" +
            "WHERE ctpoints.EntrantId=en.EntrantID)+en.Score*10 AS Scores\n" +
            "FROM entrants as en\n" +
            "INNER JOIN ctpoints e ON en.EntrantId = e.EntrantID\n" +
            "  WHERE en.SpecialtyID=?\n" +
            "GROUP BY en.EntrantID\n" +
            "ORDER BY Scores DESC;";

    @Override
    public ArrayList<EntrantInQueueModal> allEntrantsScoreBySpecialty(int idSpecialty) throws DAOException {
        Connection cn = ConnectionPool.getInstance().takeConnection();
        ArrayList<EntrantInQueueModal> entrant = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = cn.prepareStatement(ALL_ENTRANT_SCORE_BY_SPESIALTY);
            preparedStatement.setInt(1, idSpecialty);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    entrant.add(new EntrantInQueueModal(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5)));
                }
                return entrant;
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while reading entrants score with such speciality", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
    }
}
