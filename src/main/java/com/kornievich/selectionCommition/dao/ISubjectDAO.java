package com.kornievich.selectionCommition.dao;

import com.kornievich.selectionCommition.entity.Subject;

import java.util.ArrayList;

public interface ISubjectDAO {
    boolean create(Subject subject);
    ArrayList<Subject> readAll();
    boolean updateSubjectName(Subject subject);
    boolean updateSubjectId(Subject subject);
    Subject delete(Subject subject);
    Subject findSubjectById(int id);
    Subject findSubjectByName(String name);

}
