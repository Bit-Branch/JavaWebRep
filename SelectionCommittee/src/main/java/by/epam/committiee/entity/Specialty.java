package by.epam.committiee.entity;

import java.io.Serializable;

public class Specialty implements Serializable {
    private long id;
    private String name;
    private int plan;
    private long facultyId;

    public Specialty() {
    }

    public Specialty(long id, String name, int plan, long facultyId) {
        this.id = id;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Specialty specialty = (Specialty) o;

        return facultyId == specialty.facultyId &&
                id == specialty.id && plan == specialty.plan &&
                name != null ? name.equals(specialty.name) : specialty.name == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + plan;
        result = 31 * result + (int) (facultyId ^ (facultyId >>> 32));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(getClass().getName());
        stringBuilder.append("@ id:");
        stringBuilder.append(id);
        stringBuilder.append(", name: ");
        stringBuilder.append(name);
        stringBuilder.append(", plan: ");
        stringBuilder.append(plan);
        stringBuilder.append(", facultyId: ");
        stringBuilder.append(facultyId);
        return stringBuilder.toString();
    }
}
