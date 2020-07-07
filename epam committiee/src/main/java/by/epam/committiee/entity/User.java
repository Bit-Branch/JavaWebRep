package by.epam.committiee.entity;

import java.io.File;
import java.io.Serializable;

public class User implements Serializable {
    private long id;
    private String surname;
    private String name;
    private String patronymic;
    private String passportNumber;
    private int certificateGrade;
    private boolean hasMedal;
    private long specialtyId;
    private File image;

    public User() {
    }

    public User(long id, String surname, String name, String patronymic, String passportNumber, int certificateGrade, boolean hasMedal, long specialtyId, File image) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.passportNumber = passportNumber;
        this.certificateGrade = certificateGrade;
        this.hasMedal = hasMedal;
        this.specialtyId = specialtyId;
        this.image = image;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public long getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(long specialtyId) {
        this.specialtyId = specialtyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return image != null ? image.equals(user.image) : user.image == null &&
                id == user.id && certificateGrade == user.certificateGrade &&
                hasMedal == user.hasMedal && specialtyId == user.specialtyId &&
                surname != null ? surname.equals(user.surname) : user.surname == null &&
                name != null ? name.equals(user.name) : user.name == null &&
                patronymic != null ? patronymic.equals(user.patronymic) : user.patronymic == null &&
                passportNumber != null ? passportNumber.equals(user.passportNumber) : user.passportNumber == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (passportNumber != null ? passportNumber.hashCode() : 0);
        result = 31 * result + certificateGrade;
        result = 31 * result + (hasMedal ? 1 : 0);
        result = 31 * result + (int) (specialtyId ^ (specialtyId >>> 32));
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(getClass().getName());
        stringBuilder.append("@ id:");
        stringBuilder.append(id);
        stringBuilder.append(", surname: ");
        stringBuilder.append(surname);
        stringBuilder.append(", name: ");
        stringBuilder.append(name);
        stringBuilder.append(", patronymic: ");
        stringBuilder.append(patronymic);
        stringBuilder.append(", passportNumber: ");
        stringBuilder.append(passportNumber);
        stringBuilder.append(", certificateGrade: ");
        stringBuilder.append(certificateGrade);
        stringBuilder.append(", hasMedal: ");
        stringBuilder.append(hasMedal);
        stringBuilder.append(", specialtyId: ");
        stringBuilder.append(specialtyId);
        stringBuilder.append(", image: ");
        stringBuilder.append(image);
        return stringBuilder.toString();
    }
}
