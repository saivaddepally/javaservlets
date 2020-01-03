package com.saiv.saikumar;

import java.util.List;

public interface FileRepsoitory {
    public void addTask(Task task);
    public List<Task> display() ;
    public Task searchById(int id) ;
    public void removeTask(int taskid) ;

 public List<Task> getListByStatus(Status input);



    void updateTaskByStatus(int id,Status newStatus) ;
}
