package com.saiv.saikumar;
import java.util.*;
import java.util.ArrayList;

public class Main {
App n=new App();
public static void add(String a,ArrayList<String> t)
{
    t.add(a);
}
    public static void display(ArrayList<String> t)
    {
        for(int i=0;i<t.size();i++)
        {
            System.out.println(t.get(i));
        }
    }
    public static void search(String a,ArrayList<String> t)
    {

            if(t.contains(a))
                System.out.println("found");
            else
                System.out.println("not found");


    }
    public static void delete(String a,ArrayList<String> t)
    {
        t.remove(a);
        System.out.println("deleted sucessfully");
    }


        public static void main(String[] args)
        {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> t = new ArrayList<String>();


        while (true)
        {
            System.out.println("1.Add\n 2.display\n 3.search\n 4.delete\n 5.exit");
            System.out.println("enter ur choice");

            int c = sc.nextInt();
            if (c == 1) {
                System.out.println("Enter ur tasks");
                String a = sc.next();
                add(a, t);

                System.out.println("added sucessfully");

            } else if (c == 2) {
                display(t);
            } else if (c == 3) {
                System.out.print("Enter the task you want to search:");
                String k = sc.next();
                search(k, t);
            } else if (c == 4) {
                System.out.print("Enter the task you want to delete:");
                String l = sc.next();
                delete(l, t);
            }
            else if(c==5)
            {
                System.exit(0);
            }
        }

    }
}
