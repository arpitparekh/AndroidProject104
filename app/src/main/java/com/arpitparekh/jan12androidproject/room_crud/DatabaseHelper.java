package com.arpitparekh.jan12androidproject.room_crud;

import android.content.Context;

import androidx.room.Room;

public class DatabaseHelper {

    public static EmpDatabase getDatabaseObject(Context context){

        EmpDatabase database  = Room.databaseBuilder(context,EmpDatabase.class,"EmpDatabase")
                .allowMainThreadQueries()
                .build();
        return database;

    }

}
