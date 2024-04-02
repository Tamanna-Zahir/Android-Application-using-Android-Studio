package com.example.otterlibrarysystem;

import android.content.Context;
import android.media.tv.TableRequest;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Accounts.class, Books.class, AccountLog.class, HoldBookLog.class},version = 11, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    public abstract AccountsDao accountsDao();
    public abstract BooksDao booksDao();
    public abstract AccountLogDao accountLogDao();
    public abstract HoldBookLogDao holdBookLogDao();




    public static MyDatabase mydatabase;
    public static synchronized MyDatabase getMyDatabase(Context context){
        if(mydatabase== null){
            mydatabase = Room.databaseBuilder(context.getApplicationContext(),
                            MyDatabase.class, "myDatabase")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();

        }
        return mydatabase;

    }
    public void populateInitialData() {
        runInTransaction(() -> {

            if (booksDao().count() == 0) {
                booksDao().addBook(
                        new Books("Frank McCourt", "Angela’s Ashes", "Memoir"));

                booksDao().addBook(
                        new Books("Kathy Sierra", "Head First Java", "Computer Science"));
                booksDao().addBook(
                        new Books("Hanya Yanagihara", "A littla life", "Fiction"));


            }
            if (accountsDao().count() == 0){
                accountsDao().addAccount(
                        new Accounts("anton","t2nn1s23"));
                accountsDao().addAccount(
                        new Accounts("bernie","ind1em3d$"));
                accountsDao().addAccount(
                        new Accounts("shirleybee","carme12chicago"));

            }
        });
    }


}
