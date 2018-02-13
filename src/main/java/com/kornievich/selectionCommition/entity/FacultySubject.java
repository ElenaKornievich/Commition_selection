package com.kornievich.selectionCommition.entity;

import java.io.Serializable;
import java.util.Objects;

public class FacultySubject implements Serializable, Cloneable{
    private int facultyId;
    private int subjectId;

    public FacultySubject(int facultyId, int subjectId) {
        this.facultyId = facultyId;
        this.subjectId = subjectId;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultySubject that = (FacultySubject) o;
        return facultyId == that.facultyId &&
                subjectId == that.subjectId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(facultyId, subjectId);
    }

    @Override
    public String toString() {
        return "FacultySubject{" +
                "facultyId=" + facultyId +
                ", subjectId=" + subjectId +
                '}';
    }
}
