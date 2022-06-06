package com.arpitparekh.jan12androidproject.firebase_realtime;

public class Faculty {

    String name;
    float salary;
    String address;

    Faculty(){   // add empty constructor for realtime database

    }

    @Override
    public String toString() {
        return "name = " + name +
                "\nsalary = " + salary;
    }

    public Faculty(String name, float salary, String address) {
        this.name = name;
        this.salary = salary;
        this.address = address;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
