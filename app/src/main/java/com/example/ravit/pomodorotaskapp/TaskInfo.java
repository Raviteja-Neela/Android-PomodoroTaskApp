package com.example.ravit.pomodorotaskapp;

/**
 * Created by ravit on 4/26/2018.
 */

class TaskInfo {

    String date,workTag,workTime,taskStatus,totalTime;

    public String getDate() {
        return date;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public String getWorkTag() {
        return workTag;
    }

    public String getWorkTime() {
        return workTime;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setWorkTag(String workTag) {
        this.workTag = workTag;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }
}
