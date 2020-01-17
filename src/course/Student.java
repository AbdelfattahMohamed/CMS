/**
 *
 * @author abdelfattah
 */
package course;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Person implements Serializable, Runnable
{
    private static String studentFileName = "Student.bin"; //Defualt constructor
    private static final long serialVersionUID = 3074300596991120136L;    //parameterized constructor
   
    private double GPA ;
    private ArrayList<Double> myGrades = new ArrayList<>();
    ArrayList<Course> myCourses = new ArrayList<>();
    fileManager fm=new fileManager();
    private int index ;
    
  
    
    public Student(String name , int id ,String courseName , String username, String password)
    {
        super(name, id, courseName, password, username);
      //  System.out.println("Inside Student Constructor");
  
    }
            ///_________________________________________________________________________________________
            ///_________________________________________________________________________________________
            ///_________________________________________________________________________________________

    public Student() {
        
    }
           
            public double getGrades(Course course)
            {   
                ArrayList<Course> arr=new ArrayList<>();
                arr=(ArrayList<Course>)fm.read("Course.bin");
                int i = 0,j=0;
                for(Course c:arr)
                {
                    if(c.getId() == course.getId())
                    {
                        for (Student s : arr.get(i).students) {
                            if(s.getId()==this.getId()){
                                return c.grades.get(j);
                            }
                            else {
                                System.out.println("student not found");
                            }
                            j++;
                        }
                    }
                    else {
                        System.out.println("course not found");
                    }
                    i++;
                }
                return -1;
            }
            ///_________________________________________________________________________________________
            ///_________________________________________________________________________________________
            ///_________________________________________________________________________________________
       
            
            public void survey()
            {
                
            }
            
            ///_________________________________________________________________________________________
            ///_________________________________________________________________________________________
            ///_________________________________________________________________________________________
            
            
            public ArrayList<Course> getCources()
            {
                
                return this.myCourses;
                
            ///_________________________________________________________________________________________
            ///_________________________________________________________________________________________
            ///_________________________________________________________________________________________
            }
            
            public void updateinfo(String updatedcourseName, String updatedName , String updatedPass)
            {
                this.setcourseName(updatedcourseName);
                this.setName(updatedName);
                this.setPassword(updatedPass);
            }
            
            ///_________________________________________________________________________________________
            ///_________________________________________________________________________________________
            ///_________________________________________________________________________________________        

    @Override
    public void run() {
        login(username, password);
        for(int i=0;i<3;i++){
            System.out.print("Login_admin"+"\n");
        }
    }
 
            
    
            
}

    
 