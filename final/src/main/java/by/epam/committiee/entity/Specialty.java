package by.epam.committiee.entity;

import java.io.Serializable;

public class Specialty implements Serializable {
    private long id;
    private int plan;
    private long facultyId;

    public Specialty() {
    }

    public Specialty(long id, int plan, long facultyId) {
        this.id = id;
        this.plan = plan;
        this.facultyId = facultyId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPlan() {
        return plan;
    }

    public void setPlan(int plan) {
        this.plan = plan;
    }

    public long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(long facultyId) {
        this.facultyId = facultyId;
    }
}
