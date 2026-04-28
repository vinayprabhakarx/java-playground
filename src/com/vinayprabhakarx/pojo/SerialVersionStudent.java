package com.vinayprabhakarx.pojo;

import java.io.Serializable;

public class SerialVersionStudent implements Serializable {
    // serialVersionUID identifies the class version during serialization.
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;

    public SerialVersionStudent() {
    }

    public SerialVersionStudent(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SerialVersionStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
