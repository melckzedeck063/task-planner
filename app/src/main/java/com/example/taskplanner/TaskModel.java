package com.example.taskplanner;

public class TaskModel {
    private String title, date,status;
    private boolean favoutite, checked;

    public TaskModel(String title, String date, boolean checked, boolean favoutite) {
        this.title = title;
        this.date = date;
        this.checked = checked;
        this.favoutite = favoutite;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isFavoutite() {
        return favoutite;
    }

    public void setFavoutite(boolean favoutite) {
        this.favoutite = favoutite;
    }
}
