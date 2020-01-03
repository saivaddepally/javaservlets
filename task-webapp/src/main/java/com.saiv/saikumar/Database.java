package com.saiv.saikumar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class Database implements FileRepsoitory
{
    public Statement statement;
    public Connection connection;

    public Database() {
        databaseConnection();

    }
     public void databaseConnection()
      {
    String URL = "jdbc:mysql://localhost:3306/testdb";
    String USERNAME = "testuser";
    String PASSWORD = "password";
          //Connection connection = null;
          try {
              Class.forName("com.mysql.jdbc.Driver");
          } catch (ClassNotFoundException e) {
              e.printStackTrace();
          }
          try {

              connection= DriverManager.getConnection(URL, USERNAME, PASSWORD);
               statement = connection.createStatement();
          } catch (SQLException e) {
              e.printStackTrace();
          }

}






    @Override
    public void addTask(Task task)  {
        try{

        String q = "insert into task values(" + task.getTaskId() + ",\"" + task.getName() + "\",\"" + task.getDescription() + "\",\"" + task.getDate()
                     + "\",\"" + task.getStatus() + "\")";
        //System.out.println(q);


            statement.executeUpdate(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<Task> display()  {
        List<Task> n = new ArrayList<>();

    try {
    String q = "select * from task";

    ResultSet rs = statement.executeQuery(q);

    if (rs.next()) {
        do {
            Task t = new Task();
            t.setTaskId(rs.getInt(1));
            t.setName(rs.getString(2));
            t.setDescription(rs.getString(3));
            t.setDate(rs.getString(4));
            t.setStatus(Status.valueOf(rs.getString(5)));
            n.add(t);
            //System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4) + "," + rs.getString(5));
        } while (rs.next());
    } else {
        System.out.println("Record Not Found...");
    }
} catch (SQLException e) {
    e.printStackTrace();
} catch (IllegalArgumentException e) {
    e.printStackTrace();
}

        return n;
    }

    @Override
    public Task searchById(int id) {

        Task t = null;
        try {
            String q = "select * from task where id=" + id;

            ResultSet rs = statement.executeQuery(q);
            t = new Task();

            if (rs.next()) {


                t.setTaskId(rs.getInt(1));
                t.setName(rs.getString(2));
                t.setDescription(rs.getString(3));
                t.setDate(rs.getString(4));
                t.setStatus(Status.valueOf(rs.getString(5)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return t;
    }

    @Override
    public List<Task> getListByStatus(Status input) {
        List<Task> n = new ArrayList<>();
        try {

            String q = "select * from task where status='"+input+"'";
            //  System.out.println(q);
            ResultSet rs = statement.executeQuery(q);

            while (rs.next()) {

                Task t = new Task();
                //System.out.println(rs.getString(2));
                t.setTaskId(rs.getInt(1));
                t.setName(rs.getString(2));
                t.setDescription(rs.getString(3));
                t.setDate(rs.getString(4));
                t.setStatus(Status.valueOf(rs.getString(5)));
               // System.out.println(t);
                n.add(t);
            }
        }catch(SQLException e){
                e.printStackTrace();
            }
        //System.out.println(n);
            return n;
        }


    @Override
    public void updateTaskByStatus(int id, Status newStatus)
    {
   try {

    String q = "update task set status='" + newStatus + "'where id=" + id;
    statement.executeUpdate(q);


   System.out.println("updated sucessfully");

} catch (SQLException e) {
    e.printStackTrace();
   }


    }

    @Override
    public void removeTask(int taskid)
    {


        try {

            String q = "delete from task where id=" + taskid;

            statement.executeUpdate(q);
            //if(rs.next()){
           // System.out.println("Deleted sucessfully");

            // System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5));
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //}

    }



}




