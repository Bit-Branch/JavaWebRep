package by.epam.committiee.entity;

public class Faculty implements Entity{
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
}
