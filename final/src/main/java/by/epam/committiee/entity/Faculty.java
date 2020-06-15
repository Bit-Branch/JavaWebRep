package by.epam.committiee.entity;

import java.io.Serializable;

public class Faculty implements Serializable {
    private long id;
    private int examOne;
    private int examTwo;
    private int examThree;

    public Faculty() {
    }

    public Faculty(long id, int examOne, int examTwo, int examThree) {
        this.id = id;
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

    public int getExamOne() {
        return examOne;
    }

    public void setExamOne(int examOne) {
        this.examOne = examOne;
    }

    public int getExamTwo() {
        return examTwo;
    }

    public void setExamTwo(int examTwo) {
        this.examTwo = examTwo;
    }

    public int getExamThree() {
        return examThree;
    }

    public void setExamThree(int examThree) {
        this.examThree = examThree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Faculty faculty = (Faculty) o;

        return examThree == faculty.examThree &&
                id == faculty.id && examOne == faculty.examOne &&
                examTwo == faculty.examTwo;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + examOne;
        result = 31 * result + examTwo;
        result = 31 * result + examThree;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(getClass().getName());
        stringBuilder.append("@ id:");
        stringBuilder.append(id);
        stringBuilder.append(", examOne: ");
        stringBuilder.append(examOne);
        stringBuilder.append(", examTwo: ");
        stringBuilder.append(examTwo);
        stringBuilder.append(", examThree: ");
        stringBuilder.append(examThree);
        return stringBuilder.toString();
    }
}
