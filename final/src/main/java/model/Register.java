package model;

public class Register {
    private int id;
    private boolean isCredited;

    public Register(int id, boolean isCredited) {
        this.id = id;
        this.isCredited = isCredited;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCredited() {
        return isCredited;
    }

    public void setCredited(boolean credited) {
        isCredited = credited;
    }
}
