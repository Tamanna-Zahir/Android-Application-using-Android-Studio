package com.example.otterlibrarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class PlaceHold extends AppCompatActivity {
    private Button memoir, computerScience, fiction;
    private String genre;
    private TextView text;
    private MyDatabase db;
    private BooksDao booksDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = MyDatabase.getMyDatabase(PlaceHold.this);
        db.populateInitialData();
        setContentView(R.layout.activity_place_hold);
        memoir = findViewById(R.id.memoir_btn);
        memoir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity("Memoir");
            }
        });
        computerScience = findViewById(R.id.cpmputer_Science_btn);
        computerScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity("Computer Science");
            }
        });
        fiction = findViewById(R.id.fiction_btn);
        fiction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity("Fiction");

            }
        });
    }
    public void openActivity(String g){
        if(db.booksDao().hasGenre(g)){
            Intent i = new Intent(PlaceHold.this, Library.class);

            Bundle bundle = new Bundle();
            bundle.putString("myGenre",g);
            i.putExtras(bundle);
            startActivity(i);
        }
        else {
            text = findViewById(R.id.genre);
            text.setText("there is no book available in that genre.");
            Toast.makeText(PlaceHold.this, "there is no book available in that genre.", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(PlaceHold.this, MainActivity.class);
            startActivity(i);
        }


    }

}