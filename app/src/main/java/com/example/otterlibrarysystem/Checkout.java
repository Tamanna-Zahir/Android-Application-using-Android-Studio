package com.example.otterlibrarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.time.temporal.Temporal;

public class Checkout extends AppCompatActivity {
        private TextView customer, bookTitle, reservation;
//        private String customerString, bookTitleString, reservationString;
        private MyDatabase db;
        private AccountsDao accountsDao;
        private String customerString,bookTitleString, genre;
        private int reservationNumber;
        private Button btn;






    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        db = MyDatabase.getMyDatabase(Checkout.this);
        db.populateInitialData();
        customer = findViewById(R.id.customer);
        bookTitle = findViewById(R.id.book_title);
        reservation = findViewById(R.id.reservation);
        customerString = "";
        bookTitleString= "";
        reservationNumber =0;
        genre = "";


        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
             customerString = bundle.getString("username");
             bookTitleString = bundle.getString("bookTitle");
             reservationNumber = bundle.getInt("number");
             genre = bundle.getString("genre");


        }
        customer.setText("Customer username: " + customerString);
        bookTitle.setText("Book Title: " + bookTitleString);
        reservation.setText("Reservation Number: " + reservationNumber);
        btn= findViewById(R.id.confirm);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Checkout.this, "The Hold is confirmed", Toast.LENGTH_SHORT).show();
                HoldBookLog hold = new HoldBookLog("Place Hold" , customerString, reservationNumber);
                db.booksDao().delete(db.booksDao().findByGenre(genre));
                db.holdBookLogDao().addHold(hold);
                // add that to log
                openActivity(MainActivity.class);
            }
        });


    }
    public void openActivity(Class<?> activityClass){
        Intent i = new Intent(Checkout.this, activityClass);
        startActivity(i);

    }

}