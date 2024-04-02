package com.example.otterlibrarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.otterlibrarysystem.databinding.ActivityTransactionBinding;

import java.util.ArrayList;
import java.util.List;

public class Transaction extends AppCompatActivity {
    private Button ok_btn;
    private ListView listview;
    private AccountLogDao accountLogDao;
    private HoldBookLogDao holdBookLogDao;
    private MyDatabase db;
    private List<AccountLog> accountsList;
    private List<HoldBookLog> holdBookLogList;

    private ActivityTransactionBinding binding;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_transaction);
        binding = ActivityTransactionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = MyDatabase.getMyDatabase(Transaction.this);
        //account Log table
        accountLogDao = db.accountLogDao();
        accountsList = accountLogDao.getAllLogs();
        //hold book log table
        holdBookLogDao = db.holdBookLogDao();
        holdBookLogList = holdBookLogDao.getAllBookHold();

        listview = binding.listView;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Transaction.this, android.R.layout.simple_list_item_1, getData());
        listview.setAdapter(adapter);
        ok_btn = findViewById(R.id.OK_btn);
        ok_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                openActivity(NewBookPrompt.class);
            }
        });
    }
    public void openActivity(Class<?> activityClass){
        Intent i = new Intent(Transaction.this, activityClass);
        startActivity(i);

    }
    private List<String> getData(){
        List<String> dataList = new ArrayList<>();
        for (AccountLog accountLog : accountsList) {
            dataList.add(accountLog.toString());
        }
        for (HoldBookLog holdBookLog : holdBookLogList) {
            dataList.add(holdBookLog.toString());
        }
        return dataList;
    }
}