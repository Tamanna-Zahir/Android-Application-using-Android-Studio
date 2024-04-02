package com.example.otterlibrarysystem;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CreateAccount extends AppCompatActivity {
    private EditText username, passward;
    private String user, passWardString;
    private MyDatabase db;
    private AccountsDao accountsDao;
    private List<Accounts> accountBank;
    private TextView result;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        result = (TextView) findViewById(R.id.result);
        username =(EditText) findViewById(R.id.enter_username);
        passward =(EditText) findViewById(R.id.enter_passward);
        result.setText("Please Enter Username and passward");
        db = MyDatabase.getMyDatabase(CreateAccount.this);

        accountBank = db.accountsDao().getAllAccounts();
        btn = (Button) findViewById(R.id.create_account);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                user = username.getText().toString();
                passWardString = passward.getText().toString();
                Accounts temp = db.accountsDao().findByName(user);
//                for (int i = 0; i < accountBank.size(); i++) {
//                    Log.d(user, "for loop");
//                    if(user.equals(accountBank.get(i).getUsername())) {
//                        result.setText("Sorry this user name alread exist");
//                    }
//
//                }
                if(db.accountsDao().existByName(user)){


                    Toast.makeText(CreateAccount.this, "Account already exist", Toast.LENGTH_SHORT).show();
                    result.setText("Sorry, Account already exist, please use a different Username");
                    onResume();
                    openActivity();

                }
                 else if(user.equals("!admin2")){
//                    result.setText("Invalid username");
                    Toast.makeText(CreateAccount.this, "Invalid username", Toast.LENGTH_SHORT).show();
                    result.setText("Invalid username, can't use !admin2");
                    onResume();
                    openActivity();



                }else if(user.isEmpty() || passWardString.isEmpty()){
//                    result.setText(user);
                        Toast.makeText(CreateAccount.this, "Username and/or Passward can't be blank", Toast.LENGTH_SHORT).show();
                        result.setText("Username and/or Passward can't be blank");
                        onResume();
                        openActivity();
                }
                else{
                      result.setText(user + " has successfully created");
                     Accounts myAcc = new Accounts(user, passWardString);
                     db.accountsDao().addAccount(myAcc);
                     Toast.makeText(CreateAccount.this, "Account Created successfully", Toast.LENGTH_SHORT).show();
//                     CreateAccount.this.finish();
                    AccountLog myaccLog = new AccountLog(user, "new Account");
                    db.accountLogDao().addAccountLog(myaccLog);
                     openActivity();
                }
            }
        });

//
    }

    public void openActivity(){
        Intent i = new Intent(CreateAccount.this, MainActivity.class);
        startActivity(i);

    }
    @Override
    protected void onResume() {
        username.setText("");
        passward.setText("");
        super.onResume();
    }
}