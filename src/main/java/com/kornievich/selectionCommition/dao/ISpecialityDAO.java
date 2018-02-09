package com.kornievich.selectionCommition.dao;

import com.kornievich.selectionCommition.entity.Speciality;
import com.kornievich.selectionCommition.exception.DAOException;

import java.util.ArrayList;

public interface ISpecialityDAO {
    String createSpeciality(String name, int facultyId, int numberOfBudgetPlace, int numberOfPainPlace) throws DAOException;
    ArrayList<Speciality> readAllSpecialities() throws DAOException;
    boolean updateSpeciality(Speciality speciality) throws DAOException;
    boolean deleteSpeciality(int specialityId) throws DAOException;
    Speciality findSpecialityById(int id) throws DAOException;
    Speciality findSpecialityByName(String name) throws DAOException;

}
