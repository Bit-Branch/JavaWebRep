package model;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String passportNumber;
    private int certificateGrade;
    private boolean hasMedal;
    private int specialtyId;

    public User(int id, String surname, String name, String patronymic, String passportNumber, int certificateGrade, boolean hasMedal, int specialtyId) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.passportNumber = passportNumber;
        this.certificateGrade = certificateGrade;
        this.hasMedal = hasMedal;
        this.specialtyId = specialtyId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getCertificateGrade() {
        return certificateGrade;
    }

    public void setCertificateGrade(int certificateGrade) {
        this.certificateGrade = certificateGrade;
    }

    public boolean isHasMedal() {
        return hasMedal;
    }

    public void setHasMedal(boolean hasMedal) {
        this.hasMedal = hasMedal;
    }

    public int getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }

}
