package com.vinayprabhakarx.oops.singleton;

import java.util.Objects;

public class PrimeMinister {
    private static PrimeMinister instance;

    private String name;
    private int age;

    // Private constructor prevents object creation using new PrimeMinister().
    private PrimeMinister(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // getInstance() creates the object only once and returns the same object every time.
    public static PrimeMinister getInstance(String name, int age) {
        if (instance == null) {
            instance = new PrimeMinister(name, age);
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "PrimeMinister{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PrimeMinister that = (PrimeMinister) obj;
        return age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
