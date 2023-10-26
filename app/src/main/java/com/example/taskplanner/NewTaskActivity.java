package com.example.taskplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class NewTaskActivity extends AppCompatActivity {

    private Spinner spinner;
    private ArrayAdapter<String> adapter;
    private List<String> items;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        spinner = findViewById(R.id.spinner);

        items =  new ArrayList<>();
        items.add("Health");
        items.add("Personal");
        items.add("Work");

//        adapter  =  new ArrayAdapter<>(this,R.layout.spinner_item, items);
//        adapter.setDropDownViewResource(R.layout.spinner_item);
//
//        spinner.setAdapter(adapter);
    }
}