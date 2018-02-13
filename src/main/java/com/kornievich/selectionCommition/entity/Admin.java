package com.kornievich.selectionCommition.entity;

import java.io.Serializable;
import java.util.Objects;

public class Admin implements Serializable, Cloneable{
    private int id;
    private String surname;
    private String firstName;
    private String secondName;

    public Admin(int id, String surname, String firstName, String secondName) {
        this.id = id;
        this.surname = surname;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return id == admin.id &&

                Objects.equals(surname, admin.surname) &&
                Objects.equals(firstName, admin.firstName) &&
                Objects.equals(secondName, admin.secondName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, surname, firstName, secondName);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
