package com.example.taskplanner;

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
    private Button button;
    private CheckBox checkBox;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerView1);
        button = view.findViewById(R.id.newTaskBtn);
        checkBox = view.findViewById(R.id.checkBox);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), NewTaskActivity.class));
            }
        });


        createTask();

        return  view;
    }

    private void createTask(){
        taskModelArrayList =  new ArrayList<>();

        taskModelArrayList.add(new TaskModel("Time to code Meck", "2023-25 22:00", false,false));
        taskModelArrayList.add(new TaskModel("Fitness and sports exercise", "2023-10-25", false, false));
        taskModelArrayList.add(new TaskModel("Time to code Meck", "2023-25 22:00", false,false));
        taskModelArrayList.add(new TaskModel("Fitness and sports exercise", "2023-10-25", false, false));
        taskModelArrayList.add(new TaskModel("Time to code Meck", "2023-25 22:00", true,false));
        taskModelArrayList.add(new TaskModel("Fitness and sports exercise", "2023-10-25", true, false));
        taskModelArrayList.add(new TaskModel("Time to code Meck", "2023-25 22:00", false,false));
        taskModelArrayList.add(new TaskModel("Fitness and sports exercise", "2023-10-25", true, false));

        taskAdapter =  new TaskAdapter(taskModelArrayList, getContext());
        recyclerView.setAdapter(taskAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setNestedScrollingEnabled(false);
    }
}