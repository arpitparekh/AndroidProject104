package com.arpitparekh.jan12androidproject.room_crud;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EmpDao {

    @Insert
    void insertEmp(Emp e);

    @Update
    void updateEmp(Emp e);

    @Delete
    void deleteEmp(Emp e);

    @Query("select * from EmpTable")
    List<Emp> showData();
}
