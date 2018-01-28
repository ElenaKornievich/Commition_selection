package com.kornievich.selectionCommition;

import com.kornievich.selectionCommition.command.Roles;
import com.kornievich.selectionCommition.dao.impl.*;
import com.kornievich.selectionCommition.entity.*;
import com.kornievich.selectionCommition.exception.ConnectionUnavailException;
import org.w3c.dom.UserDataHandler;

import java.sql.*;


public class SimpleJDBCRunner {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       // User user = new User(6, "ignat", , Roles.ENTRANT);
      //  Faculty faculty = new Faculty(3, "Seio", "2018-12-12", "2018-11-11");
        //FacultyDAO facultyDAO=new FacultyDAO();
       // facultyDAO.create(faculty);
        //Speciality speciality=new Speciality(3,"mn", 2,12, 12);
        //SpecialityDAO specialityDAO = new SpecialityDAO();
       // specialityDAO.create(speciality);
        //facultyDAO.delete(faculty);
        //FacultySubjectDAO facultySubjectDAO=new FacultySubjectDAO();
       // System.out.println(facultySubjectDAO.findBySubjectId(2));
        /*FacultySubject facultySubject=new FacultySubject(3,1);
        FacultySubject facultySubject2=new FacultySubject(3,2);
        FacultySubject facultySubject3=new FacultySubject(3,3);
        FacultySubjectDAO facultySubjectDAO=new FacultySubjectDAO();
        facultySubjectDAO.create(facultySubject);
        facultySubjectDAO.create(facultySubject2);
        facultySubjectDAO.create(facultySubject3);*/



       /* Entrant entrant = new Entrant(10,"2018-10-10", 1, "VC", 1233212,
                "Ivanov","Elena", "Ivanov", "2013-11-11","123NM330","1997-05-12",
                "belarusian", "+37529279992", "Minsk,Oct.1-/2",
                9.8,false,"ivanovivan@gmail.com");
        EntrantDAO entrantDAO =new EntrantDAO();
        entrantDAO.delete(entrant);*/
        //System.out.println(entrantDAO.findEntrantByName("Elena"));
        SpecialityDAO specialityDAO=new SpecialityDAO();
        System.out.println(specialityDAO.findSpecialityByName("1").getId());


    }
}