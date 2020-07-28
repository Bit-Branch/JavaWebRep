package by.epam.committiee.entity;


import java.io.File;
import java.io.Serializable;

public class Account implements Serializable {
    private long id;
    private String login;
    private transient String password;
    private transient byte[] salt;
    private transient byte[] hash;
    private Role role;
    private String email;
    private File image;

    public Account() {
    }

    public Account(long id, String login, String password, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Account(long id, String login, String password, byte[] hash, byte[] salt, Role role, String email, File image) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.salt = salt;
        this.hash = hash;
        this.role = role;
        this.email = email;
        this.image = image;
    }

    public Account(String login, String password, Role role, String email) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
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

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public byte[] getHash() {
        return hash;
    }

    public void setHash(byte[] hash) {
        this.hash = hash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return role == account.role
                && id == account.id &&
                login != null ? login.equals(account.login) : account.login == null &&
                password != null ? password.equals(account.password) : account.password == null &&
                salt != null ? salt.equals(account.salt) : account.salt == null &&
                hash != null ? hash.equals(account.hash) : account.hash == null &&
                email != null ? email.equals(account.email) : account.email == null &&
                image != null ? image.equals(account.image) : account.image == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
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
        stringBuilder.append(", email: ");
        stringBuilder.append(email);
        stringBuilder.append(", image: ");
        stringBuilder.append(image);
        return stringBuilder.toString();
    }
}
