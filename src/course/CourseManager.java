/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author abdelfattah
 */
public class CourseManager extends Person implements Serializable
{
    
    
    
      private static final long serialVersionUID = 2164807260672105854L;

    fileManager f=new fileManager();
    ArrayList<Course> courses=new ArrayList<>();
    ArrayList<Instructor> instructors = new ArrayList<>();

    CourseManager(int id, String name, Instructor instructor, String room, String branch, double price, String dayOfStart, String dayOfEnd, int dayOfCourse, Course parentCourse, double parentCoursePrice) {
        
    }

    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(ArrayList<Instructor> instructors) {
        this.instructors = instructors;
    }
    private final String coursename = "Course.bin";


    /*public CourseManager(String Id, int CreditHours, String coursename) {
        this.Id = Id;
        this.CreditHours = CreditHours;
        this.coursename = coursename;
    }*/

    public CourseManager(String name, int id, String courseName, String password, String username) {
        super(name, id, courseName, password, username);
    }


    public ArrayList<Course> getCourses() {
        return courses;
    }

    //HBD
    public void show_allstudents(){
        loadFromFile();
        for(Course x: courses)
            System.out.println(x.toString());
    }
    //HBD
    public void showall_Instructors(){
    loadFromFileOfInst();
    for(Course x:courses)
        System.out.println(x.toString());
}
    
    public void loadFromFile() {
        courses = (ArrayList<Course>) f.read(coursename);
    }
    
    public void loadFromFileOfInst()
    {
        instructors= (ArrayList<Instructor>) f.read("Instructor.bin");
    }
    
public boolean commitToFile() {
        return f.write(coursename, courses);
}
    
public boolean addCourse(Course addedCourse) {
        loadFromFile();
        courses.add(addedCourse);
        return commitToFile();
    }


private int getindex(int id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
}
public boolean delete_course(int ID){
    loadFromFile();
    int index=getindex(ID);
    if(index!=-1)
    {
        courses.remove(index);
        return commitToFile();
    }
    else 
        return false;
}
//HBD
public boolean update_course(int oldID,Course x)
{
    loadFromFile();
    int index=getindex(oldID);
    if(index!=-1)
    {
        courses.set(index, x);
        return commitToFile();
    }
    return false;
}



    //Function to returns the difference between two dates
    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit)
    {
    long diffInMillies = date2.getTime() - date1.getTime();
    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }

    
    //Ahmed's Function to display the courses near to end..
    public void nearToEnd()
    {
        fileManager FM = new fileManager();
        ArrayList<Course> courses = new ArrayList<>();
        courses = (ArrayList <Course>) FM.read(coursename);
        Date currentDate = new Date();
        long differnceBetweenTwoDates;
        for(Course curCourse:courses)
        {
            if((differnceBetweenTwoDates = getDateDiff(currentDate, curCourse.getDayOfEnd(), TimeUnit.DAYS)) < 7 && (differnceBetweenTwoDates = getDateDiff(currentDate, curCourse.getDayOfEnd(), TimeUnit.DAYS)) > 0)
            {
                System.out.println(curCourse.getCourseName());
            }
        }
    }
    
    
    //Ahmed's function to display the courses near to start
    public void nearToStart()
    {
        fileManager FM = new fileManager();
        ArrayList<Course> courses = new ArrayList<>();
        courses = (ArrayList <Course>) FM.read(coursename);
        Date currentDate = new Date();
        long differnceBetweenTwoDates;
        for(Course curCourse:courses)
        {
            if((differnceBetweenTwoDates = getDateDiff(currentDate, curCourse.getDayOfStart(), TimeUnit.DAYS)) < 7 && (differnceBetweenTwoDates = getDateDiff(currentDate, curCourse.getDayOfEnd(), TimeUnit.DAYS)) > 0)
            {
                System.out.println(curCourse.getCourseName());
            }
        }
    }
    
    //Function to add students to a specific course
     public void addStudentToCourse(Student student, Course course)
     {
         course.students.add(student);
         student.myCourses.add(course);
     }
}
