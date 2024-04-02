package com.example.otterlibrarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewBookPrompt extends AppCompatActivity {
    private Button yes_btn, no_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_book_prompt);
        yes_btn = findViewById(R.id.yes);
        no_btn = findViewById(R.id.no);
        yes_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(NewBook.class);
            }
        });
        no_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(MainActivity.class);
            }
        });
    }
    public void openActivity(Class<?> activityClass){
        Intent i = new Intent(NewBookPrompt.this, activityClass);
        startActivity(i);

    }
}