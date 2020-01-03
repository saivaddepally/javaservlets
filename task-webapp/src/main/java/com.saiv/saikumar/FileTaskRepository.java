package com.saiv.saikumar;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileTaskRepository implements FileRepsoitory {


    private static final String TASKS_JSON_FILE = "/home/saikumarv/IdeaProjects/task-list/src/com/saikumar/abc.json";
    private ObjectMapper objectmapper = new ObjectMapper();
    List<Task> tasks;
    File file = new File(TASKS_JSON_FILE);

    public FileTaskRepository() {
        tasks = readFromFile();
    }
    private void writeToFile(List<Task> task) {
        try {
            objectmapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new FileWriter(TASKS_JSON_FILE), task);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
    private List<Task> readFromFile() {
       // final File file = new File(TASKS_JSON_FILE);
        if (file.exists()) {
            try {
                return objectmapper.readValue(file,TaskList.class);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task);
        writeToFile(tasks);
    }

    @Override
    public List<Task> display() {
        return readFromFile();
    }

    @Override
    public Task searchById(int id) {
        for(Task task : tasks){
            if(task.getTaskId()==id){
                return task;
            }
        }
        return null;
    }

    @Override
    public void removeTask(int taskid) {
    for(Task task:tasks){
        if(task.getTaskId()==taskid)
            tasks.remove(taskid);
        writeToFile(tasks);
    }


    }

    @Override
    public List<Task> getListByStatus(Status input) {
List<Task> t=new ArrayList<>();
return t;
    }

    @Override
    public void updateTaskByStatus(int id, Status newStatus)  {

    }
}