package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'DHRUMIL SHAH', 'dhrumil789789@gmail.com','7584','8104385831', 1000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'MELODY PEREIRA', 'melodypereira@gmail.com','7519','12345678', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'GAURAV KUKREJA', 'gaurav@gmail.com','8896','234567891', 1000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1258,'TARUN TALREJA', 'tarun@gmail.com','7752','34567890', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'LAVESH TIRTHANI', 'lavtirt@gmail.com','3669','45678901', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'JINEN SHAH', 'jinen@gmail.com','9985','7977181258', 6500)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'DIVYAM JAIN', 'divyamj@gmail.com','1207','234567890', 4500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'DARSHEEL SHAH', 'darsheels@gmail.com','4522','8291209285', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'JASH CHOLERA', 'jashc@gmail.com','6582','9309565238', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'TIRTH SHAH', 'tirth@gmail.com','5450','9930615778', 9900)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'ANURAG  KASHYAP', 'anurag@gmail.com','2656','1245780123', 9800)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}