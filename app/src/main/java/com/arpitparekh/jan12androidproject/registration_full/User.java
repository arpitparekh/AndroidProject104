package com.arpitparekh.jan12androidproject.registration_full;

public class User {

    String email;
    String uid;
    String url;
    String phone;
    String address;
    String name;

    User(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public User(String email, String uid, String url, String phone, String address, String name) {
        this.email = email;
        this.uid = uid;
        this.url = url;
        this.phone = phone;
        this.address = address;
        this.name = name;
    }
}
