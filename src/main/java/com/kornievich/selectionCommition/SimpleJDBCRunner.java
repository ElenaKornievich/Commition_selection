package com.kornievich.selectionCommition;

import com.kornievich.selectionCommition.command.Roles;
import com.kornievich.selectionCommition.dao.impl.*;
import com.kornievich.selectionCommition.entity.*;
import com.kornievich.selectionCommition.exception.ConnectionUnavailException;
import com.kornievich.selectionCommition.service.SubjectService;
import com.kornievich.selectionCommition.service.UserService;
import com.kornievich.selectionCommition.util.SHA256Util;
import org.w3c.dom.UserDataHandler;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SimpleJDBCRunner {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       // User user = new User(6, "ignat", , Roles.ENTRANT);
      //  MainFacultyCommand faculty = new MainFacultyCommand(3, "Seio", "2018-12-12", "2018-11-11");
        //FacultyDAO facultyDAO=new FacultyDAO();
       // facultyDAO.createAdmin(faculty);
        //SpecialityCommand speciality=new SpecialityCommand(3,"mn", 2,12, 12);
        //SpecialityDAO specialityDAO = new SpecialityDAO();
       // specialityDAO.createAdmin(speciality);
        //facultyDAO.deleteAdmin(faculty);
        //FacultySubjectDAO facultySubjectDAO=new FacultySubjectDAO();
       // System.out.println(facultySubjectDAO.findFacultySubjectsBySubjectId(2));
        /*FacultySubject facultySubject=new FacultySubject(3,1);
        FacultySubject facultySubject2=new FacultySubject(3,2);
        FacultySubject facultySubject3=new FacultySubject(3,3);
        FacultySubjectDAO facultySubjectDAO=new FacultySubjectDAO();
        facultySubjectDAO.createAdmin(facultySubject);
        facultySubjectDAO.createAdmin(facultySubject2);
        facultySubjectDAO.createAdmin(facultySubject3);*/



       /* Entrant entrant = new Entrant(10,"2018-10-10", 1, "VC", 1233212,
                "Ivanov","Elena", "Ivanov", "2013-11-11","123NM330","1997-05-12",
                "belarusian", "+37529279992", "Minsk,Oct.1-/2",
                9.8,false,"ivanovivan@gmail.com");
        EntrantDAO entrantDAO =new EntrantDAO();
        entrantDAO.deleteAdmin(entrant);*/
        //System.out.println(entrantDAO.findEntrantByName("Elena"));
        //SpecialityDAO specialityDAO=new SpecialityDAO();
        //System.out.println(specialityDAO.findSpecialityByName("1").getId());
//SubjectDAO subjectDAO=new SubjectDAO();
        //System.out.println(subjectDAO.findSubjectById(1));
        //System.out.println(SubjectService.getInstance().findSubjectById(1));
        //String str="bvaleo";
        //System.out.println(SHA256Util.encrypt(str));
       // java.util.Date dateNow = new Date();
      //  SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd");

       // System.out.println("Текущая дата " + formatForDateNow.format(dateNow));
//UserDAO userDAO=new UserDAO();
       // User user = userDAO.createAdmin("aaaa","qqqq");
       // userDAO.changeUserRole(user, "admin");
        System.out.println(Roles.ADMIN.getText());
    }
}