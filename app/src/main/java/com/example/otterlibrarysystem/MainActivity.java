package com.example.otterlibrarysystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.otterlibrarysystem.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button create_Account, place_Hold, manage_System;
    private MyDatabase db;
    private List<Accounts> AccountBank;
    private String username, passward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = MyDatabase.getMyDatabase(MainActivity.this);
        db.populateInitialData();
        create_Account = findViewById(R.id.create_account_btn);
        create_Account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openActivity(CreateAccount.class);
            }
        });
        place_Hold = findViewById(R.id.place_Hold_btn);
        place_Hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(PlaceHold.class);
            }
        });
        manage_System = findViewById(R.id.manage_System_btn);
        manage_System.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(ManageSystem.class);
            }
        });

    }
    public void openActivity(Class<?> activityClass){
        Intent i = new Intent(MainActivity.this, activityClass);
        startActivity(i);

    }

}