package entity;

import java.io.Serializable;

public class User implements Serializable {
    private String login;
    private String password;
    private String role;
    private Reader reader;

    public User(String login, String password, String role, Reader reader) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.reader = reader;
    }

    public User() {

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", reader=" + reader +
                '}';
    }

    public void setRole(int nextInt) {
    }
}
