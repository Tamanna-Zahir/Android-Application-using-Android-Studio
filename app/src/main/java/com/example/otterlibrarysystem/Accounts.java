package com.example.otterlibrarysystem;

import androidx.room.Entity;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
@Entity(tableName =  "Accounts")
public class Accounts {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "Username")
    private String username;
    @ColumnInfo
    private String passward;
   // @ColumnInfo
    //private String transactionType;



    public Accounts(String username,String passward){
        this.username = username;
        this.passward = passward;
        //this.transactionType = transactionType;

    }

//    public String getTransactionType() {
//        return transactionType;
//    }
//
//    public void setTransactionType(String transactionType) {
//        this.transactionType = transactionType;
//    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
