package by.epam.committiee.entity;


import java.io.Serializable;

public class Account implements Serializable {
    private long id;
    private String login;
    private String password;
    private Role role;

    public Account() {
    }

    public Account(long id, String login, String password, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return role == account.role
                && id == account.id &&
                login != null ? login.equals(account.login) : account.login == null &&
                password != null ? password.equals(account.password) : account.password == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(getClass().getName());
        stringBuilder.append("@ id:");
        stringBuilder.append(id);
        stringBuilder.append(", login: ");
        stringBuilder.append(login);
        stringBuilder.append(", password: ");
        stringBuilder.append(password);
        stringBuilder.append(", role: ");
        stringBuilder.append(role);
        return stringBuilder.toString();
    }
}
