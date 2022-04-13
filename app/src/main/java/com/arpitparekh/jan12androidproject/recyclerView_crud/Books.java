package com.arpitparekh.jan12androidproject.recyclerView_crud;

public class Books {

    String title;
    String des;
    int price;

    public Books(String title, String des, int price) {
        this.title = title;
        this.des = des;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
