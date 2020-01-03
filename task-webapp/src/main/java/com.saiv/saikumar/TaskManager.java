package com.saiv.saikumar;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {


    FileRepsoitory inmemory=new Database();

    public void addTask(int id,String name, String description, String date, String status) {
       inmemory.addTask(new Task(name, description, date, Status.valueOf(status), id));


   }

    public List<Task> display()  {
       List<Task> tasks = inmemory.display();
       return tasks;
    }

    public Task searchById(int id)  {
       Task task = inmemory.searchById(id);
       return task;
    }

    public void removeTask(int taskid)  {
       inmemory.removeTask(taskid);
    }
    public List<Task> getListByStatus(Status input)  {
        List<Task> t;
       t=  inmemory.getListByStatus(input);
        return t;
    }
    public void updateTaskByStatus(int id,Status newStatus) {
        inmemory.updateTaskByStatus(id,newStatus);
    }
}

