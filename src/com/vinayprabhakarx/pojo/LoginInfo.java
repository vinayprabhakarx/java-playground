package com.vinayprabhakarx.pojo;

import java.io.Serializable;
import java.util.Objects;

public class LoginInfo implements Serializable {
    private int id;

    // transient fields are skipped during serialization.
    private transient String username;
    private transient String password;

    // Default constructor creates an object with default values.
    public LoginInfo() {
    }

    // Parameterized constructor creates an object with given login values.
    public LoginInfo(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    // Getter returns the id value.
    public int getId() {
        return id;
    }

    // Setter updates the id value.
    public void setId(int id) {
        this.id = id;
    }

    // Getter returns the password value.
    public String getPassword() {
        return password;
    }

    // Setter updates the password value.
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter returns the username value.
    public String getUsername() {
        return username;
    }

    // Setter updates the username value.
    public void setUsername(String username) {
        this.username = username;
    }

    // toString() returns the object data in readable text form.
    @Override
    public String toString() {
        return "LoginInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    // equals() compares whether two LoginInfo objects have the same data.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LoginInfo that = (LoginInfo) obj;
        return id == that.id
                && Objects.equals(username, that.username)
                && Objects.equals(password, that.password);
    }

    // hashCode() generates a hash value used in hash-based collections.
    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }
}
