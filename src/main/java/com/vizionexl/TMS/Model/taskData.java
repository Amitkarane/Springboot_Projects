package com.vizionexl.TMS.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="task")
public class taskData {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="task",length = 50)
    private String task;

    @Column(name="status",length = 50)
    private String status;

    @Column(name="completed")
    private boolean completed;

    public taskData(){ }

    public taskData(int id, String task, String status, boolean completed) {
        this.id = id;
        this.task = task;
        this.status = status;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
