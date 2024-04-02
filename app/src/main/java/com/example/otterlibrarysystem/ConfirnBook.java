package com.example.otterlibrarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirnBook extends AppCompatActivity {
    private TextView title, author, genre;
    private String titleString, authorString, genreString;
    private MyDatabase db;


    private Button confirm, edit;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirn_book);
        db = MyDatabase.getMyDatabase(ConfirnBook.this);
        title = findViewById(R.id.title_text);
        author = findViewById(R.id.author_text);
        genre = findViewById(R.id.genre_text);
        titleString = "";
        authorString = "";
        genreString = "";
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            titleString = extras.getString("title");
            authorString = extras.getString("author");
            genreString = extras.getString("genre");
        }
        title.setText(titleString);
        author.setText(authorString);
        genre.setText(genreString);
        confirm = findViewById(R.id.confirm_btn);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Books newBook = new Books(authorString,titleString,genreString);
                db.booksDao().addBook(newBook);
                Toast.makeText(ConfirnBook.this,"Add Book confirmed", Toast.LENGTH_SHORT).show();
                openActivity(MainActivity.class);

            }
        });
        edit = findViewById(R.id.edit_btn);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(NewBook.class);
            }
        });

    }
    public void openActivity(Class<?> activityClass){
        Intent i = new Intent(ConfirnBook.this, activityClass);
        startActivity(i);

    }
}