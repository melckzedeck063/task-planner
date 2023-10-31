package com.example.taskplanner;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class CompletedFragment extends Fragment {
    private TaskAdapter taskAdapter;
    private ArrayList<TaskModel> taskModelArrayList;
    private RecyclerView recyclerView;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_completed, container, false);

        recyclerView =   view.findViewById(R.id.completed_recycler);

        createNeWtask();

        return  view;
    }

    private void createNeWtask(){
        taskModelArrayList =  new ArrayList<>();

        taskModelArrayList.add(new TaskModel("Time to code Meck", "2023-25 22:00", true,false));
        taskModelArrayList.add(new TaskModel("Fitness and sports exercise", "2023-10-25", true, false));
        taskModelArrayList.add(new TaskModel("Time to code Meck", "2023-25 22:00", true,false));
        taskModelArrayList.add(new TaskModel("Fitness and sports exercise", "2023-10-25", true, false));
        taskModelArrayList.add(new TaskModel("Time to code Meck", "2023-25 22:00", true,false));
        taskModelArrayList.add(new TaskModel("Fitness and sports exercise", "2023-10-25", true, false));
        taskModelArrayList.add(new TaskModel("Time to code Meck", "2023-25 22:00", true,false));
        taskModelArrayList.add(new TaskModel("Fitness and sports exercise", "2023-10-25", true, false));
        taskModelArrayList.add(new TaskModel("Time to code Meck", "2023-25 22:00", true,false));
        taskModelArrayList.add(new TaskModel("Fitness and sports exercise", "2023-10-25", true, false));

        taskAdapter = new TaskAdapter(taskModelArrayList, getContext());
        recyclerView.setAdapter(taskAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setNestedScrollingEnabled(false);
    }
}