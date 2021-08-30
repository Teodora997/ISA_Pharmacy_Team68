package com.example.demo.model;

public class DermaObj{
    int id;
    String name;
    String lastName;
    double mark;
    int phId;

    public DermaObj(int id, String name, String lastName, double mark, int phId) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.mark = mark;
        this.phId = phId;
    }
    public DermaObj() {}

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public int getPhId() {
        return phId;
    }

    public void setPhId(int phId) {
        this.phId = phId;
    }
}
