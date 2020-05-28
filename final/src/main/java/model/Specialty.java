package model;

public class Specialty {
    private int id;
    private int plan;
    private int facultyId;

    public Specialty(int id, int plan, int facultyId) {
        this.id = id;
        this.plan = plan;
        this.facultyId = facultyId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlan() {
        return plan;
    }

    public void setPlan(int plan) {
        this.plan = plan;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }
}
