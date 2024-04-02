package com.example.otterlibrarysystem;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BooksDao {
    @Insert
    void insertAll(Books... books);
    @Insert
    void addBook(Books books);
    @Query("SELECT * FROM books ")
    List<Books> getAllBooks();
    @Delete
    void delete(Books Book);

    @Query("SELECT * FROM books WHERE genre = :genre")
            Books findByGenre(String genre);

    @Query("SELECT COUNT(*) FROM books")
    int count();
    @Query("SELECT *FROM books WHERE genre = :genreName")
    boolean hasGenre(String genreName);
}
