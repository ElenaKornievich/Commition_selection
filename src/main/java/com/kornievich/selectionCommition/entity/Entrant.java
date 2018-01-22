package com.kornievich.selectionCommition.entity;

import java.util.Objects;

public class Entrant {
    private int id;
    private String dateOfFilling;
    private int specialityId;
    private String pasportSeries;
    private int passportNumber;
    private String surname;
    private String firstName;
    private String lastName;
    private String dateOfIssue;
    private String identificationNumber;
    private String dateOfBirth;
    private String nationality;
    private String telephoneNumber;
    private String residenceAddress;
    private double score;
    private boolean goldMedal;
    private String email;

    public Entrant(int id, String dateOfFilling, int specialityId, String pasportSeries, int passportNumber, String surname, String firstName, String lastName, String dateOfIssue, String identificationNumber, String dateOfBirth, String nationality, String telephoneNumber, String residenceAddress, double score, boolean goldMedal, String email) {
        this.id = id;
        this.dateOfFilling = dateOfFilling;
        this.specialityId = specialityId;
        this.pasportSeries = pasportSeries;
        this.passportNumber = passportNumber;
        this.surname = surname;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfIssue = dateOfIssue;
        this.identificationNumber = identificationNumber;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.telephoneNumber = telephoneNumber;
        this.residenceAddress = residenceAddress;
        this.score = score;
        this.goldMedal = goldMedal;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateOfFilling() {
        return dateOfFilling;
    }

    public void setDateOfFilling(String dateOfFilling) {
        this.dateOfFilling = dateOfFilling;
    }

    public int getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(int specialityId) {
        this.specialityId = specialityId;
    }

    public String getPasportSeries() {
        return pasportSeries;
    }

    public void setPasportSeries(String pasportSeries) {
        this.pasportSeries = pasportSeries;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
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

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public boolean isGoldMedal() {
        return goldMedal;
    }

    public void setGoldMedal(boolean goldMedal) {
        this.goldMedal = goldMedal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entrant entrant = (Entrant) o;
        return id == entrant.id &&
                specialityId == entrant.specialityId &&
                passportNumber == entrant.passportNumber &&
                Double.compare(entrant.score, score) == 0 &&
                goldMedal == entrant.goldMedal &&
                Objects.equals(dateOfFilling, entrant.dateOfFilling) &&
                Objects.equals(pasportSeries, entrant.pasportSeries) &&
                Objects.equals(surname, entrant.surname) &&
                Objects.equals(firstName, entrant.firstName) &&
                Objects.equals(lastName, entrant.lastName) &&
                Objects.equals(dateOfIssue, entrant.dateOfIssue) &&
                Objects.equals(identificationNumber, entrant.identificationNumber) &&
                Objects.equals(dateOfBirth, entrant.dateOfBirth) &&
                Objects.equals(nationality, entrant.nationality) &&
                Objects.equals(telephoneNumber, entrant.telephoneNumber) &&
                Objects.equals(residenceAddress, entrant.residenceAddress) &&
                Objects.equals(email, entrant.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, dateOfFilling, specialityId, pasportSeries, passportNumber, surname, firstName, lastName, dateOfIssue, identificationNumber, dateOfBirth, nationality, telephoneNumber, residenceAddress, score, goldMedal, email);
    }

    @Override
    public String toString() {
        return "Entrant{" +
                "id=" + id +
                ", dateOfFilling='" + dateOfFilling + '\'' +
                ", specialityId=" + specialityId +
                ", pasportSeries='" + pasportSeries + '\'' +
                ", passportNumber=" + passportNumber +
                ", surname='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfIssue='" + dateOfIssue + '\'' +
                ", identificationNumber='" + identificationNumber + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", nationality='" + nationality + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", residenceAddress='" + residenceAddress + '\'' +
                ", score=" + score +
                ", goldMedal=" + goldMedal +
                ", email='" + email + '\'' +
                '}';
    }
}
