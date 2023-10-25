package com.example.taskplanner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<TaskModel> taskModelArrayList;
    private Context context;

    public TaskAdapter(ArrayList<TaskModel> taskModelArrayList, Context context) {
        inflater = LayoutInflater.from(context);
        this.taskModelArrayList = taskModelArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = inflater.inflate(R.layout.todo_item,parent,false);
        TaskAdapter.ViewHolder holder = new TaskAdapter.ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.ViewHolder holder, int position) {
        holder.title.setText(taskModelArrayList.get(position).getTitle());
        holder.date.setText(taskModelArrayList.get(position).getDate());
        holder.status.setChecked(taskModelArrayList.get(position).isChecked());

    }

    @Override
    public int getItemCount() {
        return taskModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,date;
        CheckBox status;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.task_date);
            status = itemView.findViewById(R.id.checkBox);
        }
    }
}
