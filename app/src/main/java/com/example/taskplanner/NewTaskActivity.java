package com.example.taskplanner;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewTaskActivity extends AppCompatActivity {

    private Spinner spinner,spinner_day;
    private EditText task;
    private Button  button;
    private TimePicker  timePicker;
    private ArrayList<TaskModel>  taskModelArrayList;
    private TaskAdapter  taskAdapter;
    private SQliteDBHelper databaseHelper;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        Toolbar toolbar =  findViewById(R.id.toolbar_item);
        setSupportActionBar(toolbar);

         databaseHelper  =  new SQliteDBHelper(this);

        // Set back button click listener
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        // Center the title
        getSupportActionBar().setDisplayShowTitleEnabled(false); // Hide default title
        View backButton = toolbar.findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        spinner = findViewById(R.id.spinner);
        task = findViewById(R.id.taskName);
        spinner_day  =  findViewById(R.id.days);
        timePicker  =   findViewById(R.id.timePicker);

        button =  findViewById(R.id.submit_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                 String taskName =  task.getText().toString();
                 String selected_day =   spinner_day.getSelectedItem().toString();
                 String category =  spinner.getSelectedItem().toString();
                 int hour =  timePicker.getHour();
                 int minute =  timePicker.getMinute();

                // Check if the TimePicker is in 24-hour mode
                boolean is24HourFormat = android.text.format.DateFormat.is24HourFormat(NewTaskActivity.this);
                String amPm;

                // Determine AM or PM based on the selected hour
                if (is24HourFormat) {
                    // If in 24-hour mode, do not show AM/PM
                    amPm = "";
                } else {
                    // If in 12-hour mode, determine AM or PM
                    if (hour >= 12) {
                        amPm = "PM";
                        if (hour > 12) {
                            hour -= 12;
                        }
                    } else {
                        amPm = "AM";
                        if (hour == 0) {
                            hour = 12;
                        }
                    }
                }

//                String toastMessage = "Task Name: " + taskName +
//                        "\nCategory: " + category +
//                        "\nDay: " + selected_day +
//                        "\nTime: " + hour + ":" + String.format("%02d", minute) + " " + amPm;
//
//                // Show the toast message

                TaskModel taskModel = new TaskModel(taskName, category, selected_day,amPm, false,false,hour,minute);

                databaseHelper.addTask(taskModel);

                Toast.makeText(NewTaskActivity.this, "New task added", Toast.LENGTH_SHORT).show();
            }
        });





    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (databaseHelper != null) {
            databaseHelper.close();
        }
    }

}


