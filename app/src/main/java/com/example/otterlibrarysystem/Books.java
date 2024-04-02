package com.example.otterlibrarysystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import android.os.Bundle;
@Entity(tableName = "Books")
public class Books {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "Author")
    private String author;
    @ColumnInfo(name = "Books Title")
    private String bookTitle;

    @ColumnInfo(name = "Genre")
    private String genre;

    public Books( String author, String bookTitle, String genre) {
        this.author = author;
        this.bookTitle = bookTitle;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
}