package com.kornievich.selectionCommition;

import com.kornievich.selectionCommition.dao.EntrantDAO;
import com.kornievich.selectionCommition.entity.Entrant;

import java.sql.*;


public class SimpleJDBCRunner {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Entrant entrant = new Entrant(3,"2018-10-10", 1, "VC", 1233212,
                "Kornievich","Elena", "Igorevna", "2013-11-11","123NM330","1997-05-12",
                "belarusian", "+37529279992", "Minsk,Oct.1-/2",
                9.8,true,"kornievichalena@gmail.com");
        EntrantDAO entrantDAO =new EntrantDAO();
        entrantDAO.create(entrant);


    }
}