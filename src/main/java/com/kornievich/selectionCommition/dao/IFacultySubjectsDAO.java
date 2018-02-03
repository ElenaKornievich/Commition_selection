package com.kornievich.selectionCommition.dao;

import com.kornievich.selectionCommition.entity.FacultySubject;

import java.util.ArrayList;

public interface IFacultySubjectsDAO {
    boolean create(FacultySubject facultySubject);
    ArrayList<FacultySubject> readAll();
    FacultySubject delete(FacultySubject facultySubject);
    ArrayList<FacultySubject> findByFacultyId(int id);
    ArrayList<FacultySubject> findBySubjectId(int id);
    boolean update(FacultySubject facultySubject);

}
