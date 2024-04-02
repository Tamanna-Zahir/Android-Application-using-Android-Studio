package com.example.otterlibrarysystem;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HoldBookLogDao {

    @Insert
    void insertAll(HoldBookLog ... holdBookLogs);

    @Insert
    void addHold(HoldBookLog  holdBookLogs);

    @Query("SELECT * FROM holdbooklog")
    int count();

    @Query("SELECT * FROM holdbooklog")
    List<HoldBookLog> getAllBookHold();
    @Delete
    void delete(HoldBookLog  holdBookLogs);


}
