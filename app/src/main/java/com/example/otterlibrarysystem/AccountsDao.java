package com.example.otterlibrarysystem;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AccountsDao {
    @Insert
    void insertAll(Accounts ... accounts);

    @Insert
    void addAccount(Accounts account);
    @Query("SELECT * FROM accounts")
    int count();
    @Query("SELECT * FROM accounts")
    List<Accounts> getAllAccounts();
    @Delete
    void delete(Accounts account);
    @Query("SELECT * FROM accounts WHERE username = :username")
    Accounts findByName(String username);

    @Query("SELECT * FROM accounts WHERE username = :username")
    boolean existByName(String username);

    @Query("SELECT passward FROM accounts WHERE username = :username")
    String getPasswardByName(String username);
}
