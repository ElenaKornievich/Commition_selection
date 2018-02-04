package com.kornievich.selectionCommition.entity;

import java.util.Objects;

public class Speciality {
    private int id;
    private String name;
    private int facultyId;
    private int numberBudgetPlace;
    private int numberPaidPlace;

    public Speciality(int id, String name, int facultyId, int numberBudgetPlace, int numberPaidPlace) {
        this.id = id;
        this.name = name;
        this.facultyId = facultyId;
        this.numberBudgetPlace = numberBudgetPlace;
        this.numberPaidPlace = numberPaidPlace;
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

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public int getNumberBudgetPlace() {
        return numberBudgetPlace;
    }

    public void setNumberBudgetPlace(int numberBudgetPlace) {
        this.numberBudgetPlace = numberBudgetPlace;
    }

    public int getNumberPaidPlace() {
        return numberPaidPlace;
    }

    public void setNumberPaidPlace(int numberPaidPlace) {
        this.numberPaidPlace = numberPaidPlace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speciality that = (Speciality) o;
        return id == that.id &&
                facultyId == that.facultyId &&
                numberBudgetPlace == that.numberBudgetPlace &&
                numberPaidPlace == that.numberPaidPlace &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, facultyId, numberBudgetPlace, numberPaidPlace);
    }

    @Override
    public String toString() {
        return "SpecialityCommand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", facultyId=" + facultyId +
                ", numberBudgetPlace=" + numberBudgetPlace +
                ", numberPaidPlace=" + numberPaidPlace +
                '}';
    }
}
