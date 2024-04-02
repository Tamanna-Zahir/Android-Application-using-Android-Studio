package com.example.otterlibrarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class Library extends AppCompatActivity {
    private TextView text;

    private EditText username, passward;
    private Button checkout;
    private  String passedString;
    private MyDatabase db;
    private BooksDao booksDao;
    private AccountsDao accountsDao;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        text = findViewById(R.id.book_to_hold);
        username = findViewById(R.id.library_username);
        passward =findViewById(R.id.library_passward);
        db = MyDatabase.getMyDatabase(Library.this);
        passedString = "";
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            passedString = extras.getString("myGenre");
        }
        Books myBook = db.booksDao().findByGenre(passedString);
        Toast.makeText(Library.this, myBook.getBookTitle(), Toast.LENGTH_SHORT).show();
        text.setText(myBook.getBookTitle());

        checkout = (Button) findViewById(R.id.checkout_btn);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(db.accountsDao().existByName(username.getText().toString()) && passward.getText().toString().equals(db.accountsDao().getPasswardByName(username.getText().toString()))){
                    int reservationNumber = reservationNumber();
                    openActivity(username.getText().toString(), text.getText().toString(), reservationNumber, passedString);
                }
                else{
                    Toast.makeText(Library.this, "username or passward is wrong", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Library.this, MainActivity.class);
//                    Toast.makeText(Library.this,db.accountsDao().existByName(username.getText().toString())+  db.accountsDao().getPasswardByName(username.getText().toString()), Toast.LENGTH_SHORT).show();

                    startActivity(i);
                }

            }
        });
    }
    public void openActivity(String user, String title, int reservationNumber,String genre ){
        Intent i = new Intent(Library.this, Checkout.class);
        Bundle bundle = new Bundle();
        bundle.putString("username",user);
        bundle.putString("bookTitle", title);
        bundle.putInt("number", reservationNumber);
        bundle.putString("genre" ,genre);
        i.putExtras(bundle);
        startActivity(i);

    }
    public int reservationNumber(){
        Random r = new Random();
        int number = r.nextInt(900000)+100000;
        return number;

    }
}