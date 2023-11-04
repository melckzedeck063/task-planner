package com.example.taskplanner;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQliteDBHelper extends SQLiteOpenHelper {

    public static final String tableName = "Tasks";

//    columns

    public static final String id = "ID";
    public static  final String task  = "TASK";
    public static final String category = "CATEGORY";
    public static final String selected_day = "DAY";
    public static final String  hour ="HOUR";
    public static final  String minute = "MINUTE";
    public static final String amPm = "AMPM";
    public static final String date_created = "DATE";
    public static final String favourite = "FAVOURITE";
    public static final String checked = "CHECKED";

    static final  String dbName= "TODO.DB";
    static final int dbVersion = 1;


    private static final String createTable = "create table" + tableName + "(" + id + "INTEGER PRIMARY KEY AUTOINCREMENT," + task + "TEXT NOT  NULL,"  +  category + "TEXT NOT NULL," + selected_day + "TEXT NOT NULL," + hour + "INT NOT NULL," + minute + "INT NOT  NULL," + amPm + "TEXT NOT NULL," + checked + "TEXT NOT NULL," + favourite + "TEXT NOT NULL," + date_created + "DATETIME CURRENT TIMESTAMP;";

    public SQliteDBHelper(@Nullable Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + tableName);
        onCreate(sqLiteDatabase);
    }
}
