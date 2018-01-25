package com.kornievich.selectionCommition.dao;

import com.kornievich.selectionCommition.entity.CTPoint;
import com.kornievich.selectionCommition.entity.Faculty;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public interface IFacultyDAO {
    boolean create(Faculty faculty);
    ArrayList<Faculty> readAll();
    boolean update(Faculty faculty);
    Faculty delete(Faculty faculty);
    Faculty findFacultyById(int id);
    ArrayList<Faculty> findFacultyByName(String name);

}
