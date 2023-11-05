package com.example.taskplanner;

public class TaskModel {
    private String title, date,status,category, amPm;
    private boolean favoutite, checked;
    int hour,minute;

    public TaskModel(String title, String date, String category, String amPm, boolean favoutite, boolean checked, int hour, int minute) {
        this.title = title;
        this.date = date;
        this.category = category;
        this.amPm = amPm;
        this.favoutite = favoutite;
        this.checked = checked;
        this.hour = hour;
        this.minute = minute;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAmPm() {
        return amPm;
    }

    public void setAmPm(String amPm) {
        this.amPm = amPm;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
