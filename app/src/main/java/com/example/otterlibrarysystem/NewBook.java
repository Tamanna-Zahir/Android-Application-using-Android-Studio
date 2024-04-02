package com.example.otterlibrarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;

public class NewBook extends AppCompatActivity {
    private EditText bookTitle, author, genre;
    private Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_book);
        bookTitle = findViewById(R.id.book_title);
        author = findViewById(R.id.author);
        genre = findViewById(R.id.genre_text);
        btn = findViewById(R.id.add_book);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(bookTitle.getText().toString(), author.getText().toString(), genre.getText().toString(), ConfirnBook.class);
            }
        });

    }
    public void openActivity(String title, String author, String genre, Class<?> activityClass){
        Intent i = new Intent(NewBook.this, activityClass);
        Bundle bunble = new Bundle();
        bunble.putString("title", title);
        bunble.putString("author", author);
        bunble.putString("genre", genre);
        i.putExtras(bunble);
        startActivity(i);

    }
}