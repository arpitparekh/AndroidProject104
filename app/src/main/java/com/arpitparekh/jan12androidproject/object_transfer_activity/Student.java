package com.arpitparekh.jan12androidproject.object_transfer_activity;

import java.io.Serializable;

public class Student implements Serializable {

    String name;
    String address;

    public Student(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
