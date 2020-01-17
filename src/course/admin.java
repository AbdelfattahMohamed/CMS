package course;
import java.util.*;
import java.io.*;


/**
 *
 * @author abdelfattah
 */
public class admin extends Person implements Serializable, Runnable{
   
    private static final long serialVersionUID = 497656015416450021L;
    // super from class person   
    public admin(String name, int id, String courseName, String pass, String username){
        super(name, id, courseName, pass, username);
    }
   fileManager Fmanger = new fileManager();
   //Default constructor
    public admin() {
        
    }
//__________________________________Student_____________________________________
    // ArrayList include all students data in binary file Student.bin
   ArrayList <Student> Students = new ArrayList<Student>();
   private final String StudentFileName = "Student.bin";
   // Load FROM file = LoadStF , this to read from it
   public void LoadStF(){
        Students = (ArrayList<Student>) Fmanger.read(StudentFileName);
   }
   // SaveStF is for Write in bin file
   public boolean SaveStF(){
        return Fmanger.write(StudentFileName,Students);         
   }
   // forloop on all studetns by id and return i or -1 
   public  int getStudentId(int id){
        for(int i=0;i<Students.size();i++){
            if(Students.get(i).getId()==id){
                return i;
            }
        }
        return -1;
   }
//______________________________METHODS FOR STUDENT_____________________________
//______________________________METHODS FOR STUDENT_____________________________
   // first is add student method
public boolean AddStudent(String name, int id, String courseName , String password , String username){
   Student st =new Student(name, id, courseName, password, username);   //Object
   LoadStF();                   //load data from file
   Students.add(st);            //add object 
   return SaveStF();
   }  
//------------------------------------------------------------------------------
   // second is search
public Student SearchStudent(int id){
        LoadStF();
        int index = getStudentId(id);
        if(index != -1){
                return Students.get(index);
        }
        else{ 
                return null;
        }
   }
//------------------------------------------------------------------------------
    // third is delete student
public void DeleteStudent(int id){
    LoadStF();
    int index = getStudentId(id);
    if (index != -1 ){
        Students.remove(index);
        System.out.println("\nDeleted Successfully");
        SaveStF();
    }else {
        System.out.println("\nFailed to Deleted");
    }
    }
//------------------------------------------------------------------------------   
    // fourth update student
public void UpdateStudent(int oldid,Student x){
    LoadStF();
    int index = getStudentId(oldid);
    if (index != -1){
        Students.set(index, x);
        System.out.println(Students.get(index).toString()+"Updated Successfully");
        SaveStF();
    }
    else{
        System.out.println("Failed to updated");
    }
    }   
//------------------------------------------------------------------------------   
    // fifth list student
public ArrayList<Student>listStudents(){
    LoadStF();
    return Students;
} 
//__________________________________ Instructor ________________________________
// ArrayList include all Instructor data in binary file Instructor.bin
   ArrayList <Instructor> Instructors = new ArrayList<Instructor>();
   private final String InstructorFileName = "Instructor.bin";
   public void LoadInF(){
        Instructors = (ArrayList<Instructor>) Fmanger.read(InstructorFileName);
   }
   
   public boolean SaveInF(){
        return Fmanger.write(InstructorFileName,Instructors);         
   }
   
   private int getInstructorId(int id){
        for(int i=0;i<Instructors.size();i++){
            if(Instructors.get(i).getId()==id){
                return i;
            }
            }
        return -1;
   }
//______________________________METHODS FOR INSTRUCTOR _________________________
//______________________________METHODS FOR INSTRUCTOR _________________________
   // first is add INSTRUCTOR method
   public boolean AddSInstructor(String name, int id, String courseName , String password , String username){
        Instructor In =new Instructor(name, id, courseName, password, username);
        LoadInF();
        Instructors.add(In);
        return SaveInF();
       
   }  
//------------------------------------------------------------------------------   
    // SECOND Search INSTRUCTOR method
   public Instructor SearchInstructor(int id){
        LoadInF();
        int index = getInstructorId(id);
        if(index != -1){
            return Instructors.get(index);
        }else 
           return null;
   }
//------------------------------------------------------------------------------   
    // THIRD Delete Instructor  method    
   public void DeleteInstructor(int id){
    LoadInF();
    int index = getInstructorId(id);
    if (index != -1 ){
        Instructors.remove(index);
        System.out.println("\nDeleted Successfully");
        SaveInF();
    }else {
        System.out.println("\nFailed to Deleted");
    }
   }
//------------------------------------------------------------------------------   
    // fourth update Instructor method
    public void UpdateInstructor(int oldid,Instructor x){
        LoadInF();
        int index = getInstructorId(oldid);
        if (index != -1){
            Instructors.set(index, x);
            System.out.println(Instructors.get(index).toString()+"Updated Successfully");
            SaveInF();
        }else{
        System.out.println("Failed to updated");
        }   
    }
    //Load again for login and override because  i have 4 run method
    public ArrayList<Instructor> listInstructors() {
        LoadInF();
    return Instructors;
    }
    //OVERRIDE THREAD 
    @Override
    public void run() {
        login(username, password);
        for(int i=0;i<3;i++){
            System.out.print("Login_admin"+"\n");
        }
    }
 
//__________________________________ ADMIN ________________________________
// ArrayList include all ADMINS data in binary file Admin.bin 
   ArrayList <admin> Admins = new ArrayList<admin>();
   private final String AdminFileName = "Admin.bin";
   public void LoadAdF(){
        Admins = (ArrayList<admin>) Fmanger.read(AdminFileName);
   }
   public boolean SaveAdF(){
        return Fmanger.write(AdminFileName,Admins);         
   }
   private int getAdminId(int id){
        for(int i=0;i<Admins.size();i++){
            if(Admins.get(i).getId()==id){
                return i;
            }
        }
        return -1;
   }  
//______________________________METHODS FOR ADMIN ______________________________
//______________________________METHODS FOR ADMIN ______________________________
   // first is add ADMIN method
   public boolean AddAdmin(int id, String name, String courseName, String username, String pass){
        admin A =new admin(name, id, courseName, pass, username);
        admin b=new admin("ahmed", 1, "male", "12", "as");
        LoadAdF();
        Admins.add(A);
        return SaveAdF();    
   }  
   // SECOND is SEARCH ADMIN method
    public String SearchAdmin(int id){
        LoadAdF();
        int index = getAdminId(id);
        if(index != -1){
            return Admins.get(index).toString();
        }else 
            return "NotFound";
    }
    // THIRD is DELETE ADMIN method   
    public void DeleteAdmin(int id){
        LoadAdF();
        int index = getAdminId(id);
        if (index != -1 ){
            Admins.remove(index);
            System.out.println("\nDeleted Successfully");
            SaveAdF();
        }else {
            System.out.println("\nFailed to Deleted");
        }    
    }
    // FORTH is UPDATE ADMIN method
    public void UpdateAdmin(int oldid,admin x){
        LoadAdF();
        int index = getAdminId(oldid);
        if (index != -1){
            Admins.set(index, x);
            System.out.println(Admins.get(index).toString()+"Updated Successfully");
            SaveAdF();
        }else{
            System.out.println("Failed to updated");
        }    
    }    

//__________________________________ COURSEMANAGER _____________________________
    // ArrayList include all ADMINS data in binary file Admin.bin 
   ArrayList <CourseManager> CourseManagers = new ArrayList<CourseManager>();
   private final String CourseManagerFileName = "CourseManager.bin";
   public void LoadCMF(){
        CourseManagers = (ArrayList<CourseManager>) Fmanger.read(CourseManagerFileName);
   }
   
   public boolean SaveCMF(){
        return Fmanger.write(CourseManagerFileName,CourseManagers);         
   }
   
   private int getCourseManagerId(int id){

   for(int i=0;i<CourseManagers.size();i++){
        if(CourseManagers.get(i).getId()==id){
            return i;
        }
        }
   return -1;
   }
//______________________________ METHODS FOR COURSEMANAGER _____________________
//______________________________ METHODS FOR COURSEMANAGER _____________________
   // first is add COURSEMANAGER method
   public boolean AddCourseManager(int id, String name, Instructor instructor, String room, String branch, double price, String dayOfStart, String dayOfEnd, int dayOfCourse, Course parentCourse, double parentCoursePrice){
        CourseManager In =new CourseManager(id, name, instructor, room, branch,price,dayOfStart,dayOfEnd,dayOfCourse,parentCourse,parentCoursePrice);
        LoadCMF();
        CourseManagers.add(In);
        return SaveCMF();       
   }  
   // second is SEARCH COURSEMANAGER method
   public String SearchCourseManager(int id){
        LoadCMF();
        int index = getCourseManagerId(id);
        if(index != -1){
            return CourseManagers.get(index).toString();
        }else 
           return "NotFound";
   }
   // third is delete COURSEMANAGER method
   public void DeleteCourseManager(int id){
        LoadCMF();
        int index = getCourseManagerId(id);
        if (index != -1 ){
            CourseManagers.remove(index);
            System.out.println("\nDeleted Successfully");
            SaveCMF();
        }else {
            System.out.println("\nFailed to Deleted");
        }
    }
   // forth is update COURSEMANAGER method
    public void UpdateCourseManager(int oldid,CourseManager x){
        LoadCMF();
        int index = getCourseManagerId(oldid);
        if (index != -1){
            CourseManagers.set(index, x);
            System.out.println(CourseManagers.get(index).toString()+"Updated Successfully");
            SaveCMF();
        }else{
            System.out.println("Failed to updated");
        }
    }

//________________________________COPYRIGHT FOR "@abdelfattah" ______________________
   
    
  
}

