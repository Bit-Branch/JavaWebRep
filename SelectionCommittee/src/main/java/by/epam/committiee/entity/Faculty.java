package by.epam.committiee.entity;

import java.io.Serializable;

public class Faculty implements Serializable {
    private long id;
    private String name;
    private String examOne;
    private String examTwo;
    private String examThree;

    public Faculty() {
    }

    public Faculty(long id, String name, String examOne, String examTwo, String examThree) {
        this.id = id;
        this.name = name;
        this.examOne = examOne;
        this.examTwo = examTwo;
        this.examThree = examThree;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExamOne() {
        return examOne;
    }

    public void setExamOne(String examOne) {
        this.examOne = examOne;
    }

    public String getExamTwo() {
        return examTwo;
    }

    public void setExamTwo(String examTwo) {
        this.examTwo = examTwo;
    }

    public String getExamThree() {
        return examThree;
    }

    public void setExamThree(String examThree) {
        this.examThree = examThree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Faculty faculty = (Faculty) o;

        return examThree != null ? examThree.equals(faculty.examThree) : faculty.examThree == null &&
                id == faculty.id && name != null ? name.equals(faculty.name) : faculty.name == null &&
                examOne != null ? examOne.equals(faculty.examOne) : faculty.examOne == null &&
                examTwo != null ? examTwo.equals(faculty.examTwo) : faculty.examTwo == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (examOne != null ? examOne.hashCode() : 0);
        result = 31 * result + (examTwo != null ? examTwo.hashCode() : 0);
        result = 31 * result + (examThree != null ? examThree.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(getClass().getName());
        stringBuilder.append("@ id:");
        stringBuilder.append(id);
        stringBuilder.append(", name: ");
        stringBuilder.append(name);
        stringBuilder.append(", examOne: ");
        stringBuilder.append(examOne);
        stringBuilder.append(", examTwo: ");
        stringBuilder.append(examTwo);
        stringBuilder.append(", examThree: ");
        stringBuilder.append(examThree);
        return stringBuilder.toString();
    }
}
