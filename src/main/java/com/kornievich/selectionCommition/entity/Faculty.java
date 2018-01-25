package com.kornievich.selectionCommition.entity;

import java.util.Objects;

public class Faculty {
    private int id;
    private String name;
    private String StartDateOfFiling;
    private String EndDataOfFiling;

    public Faculty(int id, String name, String startDateOfFiling, String endDataOfFiling) {
        this.id = id;
        this.name = name;
        StartDateOfFiling = startDateOfFiling;
        EndDataOfFiling = endDataOfFiling;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDateOfFiling() {
        return StartDateOfFiling;
    }

    public void setStartDateOfFiling(String startDateOfFiling) {
        StartDateOfFiling = startDateOfFiling;
    }

    public String getEndDataOfFiling() {
        return EndDataOfFiling;
    }

    public void setEndDataOfFiling(String endDataOfFiling) {
        EndDataOfFiling = endDataOfFiling;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return id == faculty.id &&
                Objects.equals(name, faculty.name) &&
                Objects.equals(StartDateOfFiling, faculty.StartDateOfFiling) &&
                Objects.equals(EndDataOfFiling, faculty.EndDataOfFiling);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, StartDateOfFiling, EndDataOfFiling);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", StartDateOfFiling='" + StartDateOfFiling + '\'' +
                ", EndDataOfFiling='" + EndDataOfFiling + '\'' +
                '}';
    }
}
