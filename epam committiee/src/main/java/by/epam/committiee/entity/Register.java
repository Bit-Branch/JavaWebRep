package by.epam.committiee.entity;

import java.io.Serializable;

public class Register implements Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Register register = (Register) o;

        return isCredited == register.isCredited && id == register.id;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (isCredited ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(getClass().getName());
        stringBuilder.append("@ id:");
        stringBuilder.append(id);
        stringBuilder.append(", isCredited: ");
        stringBuilder.append(isCredited);
        return stringBuilder.toString();
    }
}
