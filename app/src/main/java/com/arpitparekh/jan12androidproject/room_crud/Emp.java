package com.arpitparekh.jan12androidproject.room_crud;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "EmpTable")
public class Emp {

    @PrimaryKey(autoGenerate = true)
    int key;

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(name = "address")
    String address;

    public Emp(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
