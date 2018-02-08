package com.kornievich.selectionCommition.dao;

import com.kornievich.selectionCommition.entity.Speciality;

import java.util.ArrayList;

public interface ISpecialityDAO {
    String create(String name, int facultyId, int numberOfBudgetPlace, int numberOfPainPlace);
    ArrayList<Speciality> readAll();
    boolean update(Speciality speciality);
    boolean delete(int specialityId);
    Speciality findSpecialityById(int id);
    Speciality findSpecialityByName(String name);

}
