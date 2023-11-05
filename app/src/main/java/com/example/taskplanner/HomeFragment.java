package com.example.taskplanner;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private TaskAdapter taskAdapter;
    private ArrayList<TaskModel> taskModelArrayList;
    private RecyclerView recyclerView;
    private Button button, buttonComplete, buttonCancel;
    private CheckBox checkBox;
    public Dialog customDialog;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerView1);
        button = view.findViewById(R.id.newTaskBtn);
        checkBox = view.findViewById(R.id.checkBox);

        customDialog =  new Dialog(getContext());
        customDialog.setContentView(R.layout.complete_dialog);

        buttonComplete = customDialog.findViewById(R.id.buttonComplete);
        buttonCancel = customDialog.findViewById(R.id.buttonCancel);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), NewTaskActivity.class));
            }
        });


        createTask();

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog.dismiss();
            }
        });

        return  view;
    }

    private void createTask(){
        
        taskAdapter =  new TaskAdapter(taskModelArrayList, getContext());
        recyclerView.setAdapter(taskAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setNestedScrollingEnabled(false);
    }

    public void completeTask (){
        customDialog.show();
    }
}