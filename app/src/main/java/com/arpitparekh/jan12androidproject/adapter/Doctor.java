package com.arpitparekh.jan12androidproject.adapter;

public class Doctor {

    String name;
    String address;

    public Doctor(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "name= " + name+
                "\naddress= " + address;

    }
}
