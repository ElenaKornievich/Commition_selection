package com.kornievich.selectionCommition.dao;

import com.kornievich.selectionCommition.entity.CTPoint;
import com.kornievich.selectionCommition.entity.Faculty;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public interface IFacultyDAO {
    Faculty create(String name, String startDate, String endDate);
    ArrayList<Faculty> readAll();
    boolean update(Faculty faculty);
    boolean delete(int facultyId);
    Faculty findFacultyById(int id);
    Faculty findFacultyByName(String name);

}
