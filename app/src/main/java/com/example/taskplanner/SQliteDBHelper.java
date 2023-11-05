package com.example.taskplanner;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

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


    private static final String createTable = "CREATE TABLE " + tableName + " (" +
            id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            task + " TEXT NOT NULL, " +
            category + " TEXT NOT NULL, " +
            selected_day + " TEXT NOT NULL, " +
            hour + " INT NOT NULL, " +
            minute + " INT NOT NULL, " +
            amPm + " TEXT NOT NULL, " +
            checked + " INTEGER, " +
            favourite + " INTEGER, " +
            date_created + " DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL)";

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

    public void addTask(TaskModel taskModel){
        SQLiteDatabase  database  = this.getWritableDatabase();
        ContentValues values =  new ContentValues();

        values.put(task, taskModel.getTitle());
        values.put(category,  taskModel.getCategory());
        values.put(selected_day, taskModel.getDate());
        values.put(hour, taskModel.getHour());
        values.put(minute, taskModel.getMinute());
        values.put(amPm, taskModel.getAmPm());
        values.put(checked, taskModel.isChecked() ? 1 : 0);
        values.put(favourite, taskModel.isChecked() ? 1 : 0);

         database.insert(tableName, null,values);
        database.close();
    }


    public Cursor getAllTasks() {
        ArrayList<TaskModel> taskList = new ArrayList<>();

        SQLiteDatabase database = this.getReadableDatabase();

        String[] columns = new String[] { SQliteDBHelper.id, SQliteDBHelper.task, SQliteDBHelper.category,
                SQliteDBHelper.selected_day, SQliteDBHelper.hour, SQliteDBHelper.minute,SQliteDBHelper.amPm,
                SQliteDBHelper.checked, SQliteDBHelper.favourite};
        Cursor cursor = database.query(SQliteDBHelper.tableName, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        return cursor;
    }



}
