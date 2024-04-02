package com.example.otterlibrarysystem;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AccountLogDao {
    @Insert
    void insertAll(AccountLog ... accountLog);

    @Insert
    void addAccountLog(AccountLog  accountLog);

    @Query("SELECT * FROM accountslog")
    int count();

    @Query("SELECT * FROM accountslog")
    List<AccountLog> getAllLogs();
    @Delete
    void delete(AccountLog  accountLog);
}
