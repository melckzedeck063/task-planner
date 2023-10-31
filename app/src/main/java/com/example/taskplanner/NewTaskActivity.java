package com.example.taskplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class NewTaskActivity extends AppCompatActivity {

    private Spinner spinner,spinner_day, spinner_hour, spinner_mins, spinner_zone;
    private EditText task;
    private Button  button;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        spinner = findViewById(R.id.spinner);
        task = findViewById(R.id.taskName);
        spinner_day  =  findViewById(R.id.days);
        spinner_hour = findViewById(R.id.time_spinner);
        spinner_mins = findViewById(R.id.minute_spinner);
        spinner_zone = findViewById(R.id.zone_spinner);

        button =  findViewById(R.id.submit_btn);




    }
}