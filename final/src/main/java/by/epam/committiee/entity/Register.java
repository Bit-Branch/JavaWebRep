package by.epam.committiee.entity;

public class Register implements Entity{
    private long id;
    private boolean isCredited;

    public Register() {
    }

    public Register(long id, boolean isCredited) {
        this.id = id;
        this.isCredited = isCredited;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isCredited() {
        return isCredited;
    }

    public void setCredited(boolean credited) {
        isCredited = credited;
    }
}
