package com.example.mytodo.Model;

public class ToDoModel {
    private int id, status;
    private String task,uid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() { return uid;}
    public void setUid(String uid) { this.uid = uid ;}

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
