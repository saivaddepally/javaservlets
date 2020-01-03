package com.saiv.saikumar;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTaskRepository {

    List<Task> taskList = new ArrayList<>();

    public void addTask(Task task) {
        taskList.add(task);
    }


    public List<Task> display() {
        return taskList;
    }

    public Task searchById(int id) {
        for(Task task : taskList){
            if(task.getTaskId()==id){
                return task;
            }
        }
        return null;
    }

    public void removeTask(int taskid) {
        for(Task task : taskList){
            if(task.getTaskId()==taskid){
                taskList.remove(task);
            }
        }
    }
}





