package com.vizionexl.TMS.Service;

import com.vizionexl.TMS.Dao.taskRepository;
import com.vizionexl.TMS.Model.taskData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class taskService {

    @Autowired
    private taskRepository taskrepository;


    public List<taskData> getAllTask(){
        return taskrepository.findAll();
    }

    public taskData saveTask(taskData task){
        return taskrepository.save(task);
    }

    public String deleteTask(int id){
        taskrepository.deleteById(id);
        return "The task with id "+id+" is deleted.";
    }

    public taskData updateTask(int id, taskData task){
        Optional<taskData> taskoptional= taskrepository.findById(id);
        taskData savedTask= taskoptional.get();

        if(task.getTask()!=null)
            savedTask.setTask(task.getTask());

        return taskrepository.save(savedTask);
    }

    public taskData updateTaskStatus(int id, taskData task){
        Optional<taskData> taskOptional=taskrepository.findById(id);
        taskData savedTask= taskOptional.get(); //kbvsovno

        savedTask.setCompleted(task.isCompleted());

        return taskrepository.save(savedTask);
    }
}
