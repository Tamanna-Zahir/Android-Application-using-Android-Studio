package com.example.otterlibrarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ManageSystem extends AppCompatActivity {
    private EditText username, passsward;
    private String usernameString, passwardString;

    private Button submit_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_system);
        username =findViewById(R.id.librarian_username);
        passsward= findViewById(R.id.librarian_passward);
        submit_btn = findViewById(R.id.submit_btn);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usernameString = username.getText().toString();
                passwardString = passsward.getText().toString();
                if(usernameString.equals("!admin2") && passwardString.equals("!admin2")){
                    openActivity(Transaction.class);
                }

                else{
                    Toast.makeText(ManageSystem.this, "Invalid Username or passward", Toast.LENGTH_SHORT).show();
                    onResume();
                    finish();
                }
            }
        });

    }
    public void openActivity(Class<?> activityClass){
        Intent i = new Intent(ManageSystem.this, activityClass);
        startActivity(i);

    }
    @Override
    protected void onResume() {
        username.setText("");
        passsward.setText("");
        super.onResume();
    }
}