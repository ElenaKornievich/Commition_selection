package com.kornievich.selectionCommition.entity;

import java.util.Objects;

public class Faculty {
    private int id;
    private String name;
    private String StartDateOfFiling;
    private String EndDateOfFiling;

    public Faculty(int id, String name, String startDateOfFiling, String endDateOfFiling) {
        this.id = id;
        this.name = name;
        StartDateOfFiling = startDateOfFiling;
        EndDateOfFiling = endDateOfFiling;
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

    public String getEndDateOfFiling() {
        return EndDateOfFiling;
    }

    public void setEndDateOfFiling(String endDateOfFiling) {
        EndDateOfFiling = endDateOfFiling;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return id == faculty.id &&
                Objects.equals(name, faculty.name) &&
                Objects.equals(StartDateOfFiling, faculty.StartDateOfFiling) &&
                Objects.equals(EndDateOfFiling, faculty.EndDateOfFiling);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, StartDateOfFiling, EndDateOfFiling);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", StartDateOfFiling='" + StartDateOfFiling + '\'' +
                ", EndDateOfFiling='" + EndDateOfFiling + '\'' +
                '}';
    }
}
