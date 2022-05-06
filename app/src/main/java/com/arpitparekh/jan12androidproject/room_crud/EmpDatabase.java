package com.arpitparekh.jan12androidproject.room_crud;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Emp.class},version = 1)
abstract public class EmpDatabase extends RoomDatabase {

    public abstract EmpDao getDao();

}
