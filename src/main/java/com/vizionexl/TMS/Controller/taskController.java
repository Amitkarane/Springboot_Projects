package com.vizionexl.TMS.Controller;


import com.vizionexl.TMS.Model.taskData;
import com.vizionexl.TMS.Service.taskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class taskController {

    @Autowired
    private taskService taskservice;

    @GetMapping("/health")
    public String check(){
        return "the application is running properly!!!";
    }

    @GetMapping
    public List<taskData> getTask(){
        return taskservice.getAllTask();
    }

    @PostMapping
    public taskData saveTask(@RequestBody taskData task){
        return taskservice.saveTask(task);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable("id") int id){
        taskservice.deleteTask(id);
        return "the task with the id "+id+" is deleted.";
    }

    @PatchMapping("/updateTaskName/{id}")
    public taskData updateTask(@PathVariable("id") int id,@RequestBody taskData task){
        return taskservice.updateTask(id,task);
    }

    @PatchMapping("/updateStatus/{id}")
    public taskData updateTaskStatus(@PathVariable("id")int id,@RequestBody taskData task){
        return taskservice.updateTaskStatus(id,task);
    }
}
