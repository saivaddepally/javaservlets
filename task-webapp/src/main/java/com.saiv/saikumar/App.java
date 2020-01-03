package com.saiv.saikumar;
import com.sun.org.apache.xpath.internal.objects.XObject;

import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.*;
import java.util.ArrayList;


public class App {


    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);

        TaskManager taskManager=new TaskManager();
        while (true) {
            System.out.println("1.Add\n2.display\n3.search\n4.delete\n5.exit\n6.ListByStatus\n7.update status");
            System.out.println("enter ur choice");

            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Enter id");
                int id=sc.nextInt();
                System.out.println("Enter ur name");
                String forname= sc.next();
                System.out.println("Enter ur description");
                String description = sc.next();
                System.out.println("enter date");
                String fordate = sc.next();
                System.out.println("enter status:");
                String forstatus=sc.next();
                //int id=sc.nextInt();
                //Task taskobject= new Task(forname, description, fordate, Status.valueOf(forstatus));
                taskManager.addTask(id,forname,description,fordate,forstatus);

                System.out.println("added sucessfully");

            } else if (choice == 2)
            {
                List<Task> tasks=taskManager.display();
                if(tasks!=null){
                    for(Task task : tasks){
                        System.out.println(task);
                    }
                }


            } else if (choice == 3) {
                System.out.print("Enter the task you want to search:");
                int id = sc.nextInt();
                Task task = taskManager.searchById(id);
                System.out.println(task);

            } else if (choice == 4) {
                System.out.print("Enter the task you want to delete:");
                int taskid = sc.nextInt();
                taskManager.removeTask(taskid);

            }

           else if(choice==5)
            {
                System.exit(0);
            }

           else if(choice==6)
            {
                System.out.println("enter status:");
                Status s=Status.valueOf(sc.next());
           List<Task> k= taskManager.getListByStatus(s);
                System.out.println(k);

            }
          else if(choice ==7)
            {
                System.out.println("enter id");
                int id=sc.nextInt();

                System.out.println("enter new status");
                Status newStatus=Status.valueOf(sc.next());
               taskManager.updateTaskByStatus(id,newStatus);


            }



        }

    }
}

