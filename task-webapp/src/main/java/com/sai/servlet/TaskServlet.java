package com.sai.servlet;

import com.saiv.saikumar.Task;
import com.saiv.saikumar.TaskManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
public class TaskServlet extends HttpServlet {


    public TaskServlet() {
    }
    @Override


    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {

            TaskManager tm=new TaskManager();

            List<Task> ListOfTasks=tm.display();
        PrintWriter out= null;
        try {
            out = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.println(ListOfTasks);





    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

int id= Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        String des=req.getParameter("des");
        String date=req.getParameter("date");
        String status=req.getParameter("status");



        TaskManager tm=new TaskManager();

            tm.addTask(id,name,des,date,status);



    }
}
