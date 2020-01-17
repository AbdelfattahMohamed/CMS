package course;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author abdelfattah
 */
public abstract class Person implements Serializable
{
    public Person(){}   //________________ DEFUALT CONSTRUCTOR
    
 private static final long serialVersionUID = 3005645886341408326L;

        protected String name ; 
        protected int id;
        protected String courseName;
        protected String password;
        protected String username;
        
        
   public Person(String name, int id, String courseName , String password , String username )
   {
      System.out.println("Inside Person Constructor");
      this.name = name;
      this.id = id;
      this.courseName = courseName;
      this.password = password;
      this.username = username;
   }
//____________________________GROUP OF GETTERS__________________________________
    public int getId(){
     return this.id;
    }
    
    public String getUserName(){
     return this.username;
    }

    public void setPassword(String newPassword){
       this.password = newPassword;
    }
    public void setUserName(String newUsername){
       this.username = newUsername;
    }
    
    public String getPassword(){
        return this.password;
    }
//____________________________GROUP OF GETTERS__________________________________    
//____________________________GROUP OF SETTERS__________________________________    
    public void setName(String newName){
       this.name = newName;
    }
      
    public String getName(){
     return this.name;
    }
    
    public void setcourseName(String newcourseName){
       this.courseName = newcourseName;
    }
        
    public String getcourseName(){
     return this.courseName;
    }
    public void setId(int id){
        this.id = id;
    }
//____________________________GROUP OF SETTERS__________________________________        
//____________________________GROUP OF SETTERS__________________________________
//____________________________METHODS___________________________________________

    public static int login(String username, String password)
     {
        fileManager FM = new fileManager();
        ArrayList<admin> admins = new ArrayList<>();
        admins = (ArrayList <admin>) FM.read("Admin.bin");
        
        //____________ STUDENT FILE__________________________
        ArrayList<Student> students = new ArrayList<>();
        students = (ArrayList <Student>) FM.read("Student.bin");
        
        //____________ courseManager FILE__________________________
        ArrayList<CourseManager> courseManagers = new ArrayList<>();
        courseManagers = (ArrayList <CourseManager>) FM.read("CourseManager.bin");
        
        //____________ instructor FILE__________________________
        ArrayList<Instructor> instructors = new ArrayList<>();
        instructors = (ArrayList <Instructor>) FM.read("Instructor.bin");
        
        //___________FOR EACH____________
        for(admin forAdmin:admins){
            if(forAdmin.getUserName().equals(username)){
                if(forAdmin.getPassword().equals(password)){
                    return 0;
                }
            }
        }
        //_____________________________FOR EACH FOR ADMINS END__________________
        //____________FOR EACH___________________
        try{
        for(Student forStudent:students){
            if(forStudent.getUserName().equals(username)&&forStudent.getPassword().equals(password)){       
                    return 1;
            }
        }}catch(Exception e){
            System.out.print("error");
        }
         //_____________________________FOR EACH FOR ADMINS END__________________
        //____________FOR EACH___________________
        for(CourseManager forCourseManager:courseManagers){
            if(forCourseManager.getUserName().equals(username)){
                if(forCourseManager.getPassword().equals(password)){
                    return 2;
                }
            }
        }
        //_____________________________FOR EACH FOR ADMINS END__________________
        for(Instructor forInstructor:instructors){
            if(forInstructor.getUserName().equals(username)){
                if(forInstructor.getPassword().equals(password)){
                    return 3;
                }
            }
        }
        return 4;

    
}

// INTERFACE
    



}