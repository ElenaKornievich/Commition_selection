package com.kornievich.selectionCommition.dao;

import com.kornievich.selectionCommition.entity.CTPoint;
import javafx.scene.shape.ClosePathBuilder;

import java.util.ArrayList;

public interface ICTPointDAO {
     boolean create(CTPoint ctPoint);
     ArrayList<CTPoint> readAll();
     boolean update(CTPoint ctPoint);
     CTPoint delete(CTPoint ctPoint);
    public ArrayList<CTPoint> findCTPointByEntrantId(int entrantId);
    public ArrayList<CTPoint> findCTPointBySubjectId(int subjectId);

}
