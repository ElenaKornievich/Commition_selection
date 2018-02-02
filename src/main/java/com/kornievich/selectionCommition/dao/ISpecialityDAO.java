package com.kornievich.selectionCommition.dao;

import com.kornievich.selectionCommition.entity.Speciality;

import java.util.ArrayList;

public interface ISpecialityDAO {
    Speciality create(String name, int facultyId, int numberOfBudgetPlace, int numberOfPainPlace);
    ArrayList<Speciality> readAll();
    boolean update(Speciality speciality);
    Speciality delete(Speciality speciality);
    Speciality findSpecialityById(int id);
    Speciality findSpecialityByName(String name);

}
