package com.kornievich.selectionCommition.dao;

import com.kornievich.selectionCommition.entity.Subject;

import java.util.ArrayList;

public interface ISubjectDAO {
    Subject create(String name);
    ArrayList<Subject> readAll();
    boolean updateSubjectName(Subject subject);
    boolean updateSubjectId(Subject subject);
    boolean delete(int subjectId);
    Subject findSubjectById(int id);
    Subject findSubjectByName(String name);

}
