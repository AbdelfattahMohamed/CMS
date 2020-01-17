
package course;
import java.io.Serializable;
import java.util.*;
/**
 *
 * @author abdelfattah
 */
public class Course implements Serializable {
  private final String courseFileName = "Course.bin";
  private int id;
  private String name;
  private Instructor instructor;
  private String room;
  private String branch;
  ArrayList<Double> grades = new ArrayList<>();
  ArrayList<Student> students = new ArrayList<>();
  private double price;
  private Date dayOfStart;
  private Date dayOfEnd;
  private int dayOfCourse;
  private Course parentCourse;
  private double parentCoursePrice;
  public Course(int id, String name, Instructor instructor, String room, String branch, double price, Date dayOfStart, Date dayOfEnd, int dayOfCourse, Course parentCourse, double parentCoursePrice)
  { 
      this.id = id;
      this.name = name;
      this.instructor = instructor;
      this.room = room;
      this.branch = branch; 
      this.price = price;
      this.dayOfCourse = dayOfCourse;
      this.dayOfEnd = dayOfEnd;
      this.dayOfStart = dayOfStart;
      this.parentCourse = parentCourse;
      this.parentCoursePrice = parentCoursePrice;
       
  }
  //____________________________---GROUP OF GETTERS &SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDayOfStart() {
        return dayOfStart;
    }

    public void setDayOfStart(Date dayOfStart) {
        this.dayOfStart = dayOfStart;
    }

    public Date getDayOfEnd() {
        return dayOfEnd;
    }

    public void setDayOfEnd(Date dayOfEnd) {
        this.dayOfEnd = dayOfEnd;
    }

    public int getDayOfCourse() {
        return dayOfCourse;
    }

    public void setDayOfCourse(int dayOfCourse) {
        this.dayOfCourse = dayOfCourse;
    }

    public Course getParentCourse() {
        return parentCourse;
    }

    public void setParentCourse(Course parentCourse) {
        this.parentCourse = parentCourse;
    }

    public double getParentCoursePrice() {
        return parentCoursePrice;
    }

    public void setParentCoursePrice(double parentCoursePrice) {
        this.parentCoursePrice = parentCoursePrice;
    }
    public String getCourseName()
    {
        return name;
    }
    public void setCourseName(String name)
    {
        this.name = name;
    }
}