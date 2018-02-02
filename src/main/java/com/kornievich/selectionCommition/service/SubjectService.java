package com.kornievich.selectionCommition.service;

import com.kornievich.selectionCommition.dao.impl.EntrantDAO;
import com.kornievich.selectionCommition.dao.impl.SubjectDAO;
import com.kornievich.selectionCommition.dao.impl.UserDAO;
import com.kornievich.selectionCommition.entity.Entrant;
import com.kornievich.selectionCommition.entity.Subject;
import com.kornievich.selectionCommition.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class SubjectService {
    // private static Logger logger = Logger.getLogger(UserService.class);

    //  private IUserDAO dao;
    private static SubjectService instance = new SubjectService();
    SubjectDAO subjectDAO;
    private SubjectService() {
        subjectDAO =new SubjectDAO();

    }


    public static SubjectService getInstance() {
        return instance;
    }


    public Subject create(String name){
        return subjectDAO.create(name);
    }
    public ArrayList<Subject> readAll(){
        return subjectDAO.readAll();
    }
    public boolean updateSubjectName(Subject subject){
        return subjectDAO.updateSubjectName(subject);
    }
    public boolean updateSubjectId(Subject subject){
        return subjectDAO.updateSubjectId(subject);
    }
    public Subject delete(Subject subject){
        return subjectDAO.delete(subject);
    }
    public Subject findSubjectById(int id){
        return subjectDAO.findSubjectById(id);
    }
    public Subject findSubjectByName(String name){
        return subjectDAO.findSubjectByName(name);
    }


}
