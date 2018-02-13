package com.kornievich.selectionCommition.entity;

import java.io.Serializable;
import java.util.Objects;

public class EntrantInQueueModal implements Serializable, Cloneable {
    private int entrantId;
    private String surname;
    private String firstName;
    private String lastName;
    private int sumOfScores;

    public EntrantInQueueModal(int entrantId, String surname, String firstName, String lastName, int sumOfScores) {
        this.entrantId = entrantId;
        this.surname = surname;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sumOfScores = sumOfScores;
    }

    public int getEntrantId() {
        return entrantId;
    }

    public void setEntrantId(int entrantId) {
        this.entrantId = entrantId;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSumOfScores() {
        return sumOfScores;
    }

    public void setSumOfScores(int sumOfScores) {
        this.sumOfScores = sumOfScores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntrantInQueueModal that = (EntrantInQueueModal) o;
        return entrantId == that.entrantId &&
                sumOfScores == that.sumOfScores &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(entrantId, surname, firstName, lastName, sumOfScores);
    }

    @Override
    public String toString() {
        return "EntrantInQueueModal{" +
                "entrantId=" + entrantId +
                ", surname='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sumOfScores=" + sumOfScores +
                '}';
    }
}
