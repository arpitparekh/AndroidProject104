package com.arpitparekh.jan12androidproject.json_parsing;

public class MyData {

    String title;
    String body;

    public MyData(String title, String body) {
        this.title = title;
        this.body = body;
    }

    @Override
    public String toString() {
        return "MyData{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
