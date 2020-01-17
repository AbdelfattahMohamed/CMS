/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course;

import GUI.loginFrame;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author abdelfattah
 */
public class main {
    private static Object dir;
    public static void main(String[] args)
    {
        //this for solve a problem and error
        String projectpath = System.getProperty("user.dir");
        System.out.print("Pro path"+ projectpath);
        File currentDir = new File(projectpath);
        //checkDirectoryContents(currentDir);
        fileManager fm=new fileManager();
          CourseManager cm=new CourseManager("abd", 0, "mm","12345", "ef");
          Course addedCourse=new Course(0, "pl", null,"" , "", 60, null, null, 0,null , 0);
          cm.addCourse(addedCourse);
          
          //Thread____________BOUNS*******************************Eng.Ahmed Adel
          admin x1 = new admin();
          Student x2= new Student();
          new Thread(x1).start();
          new Thread((Runnable) x2).start();
          
          
          // Mean Class
          loginFrame p = new loginFrame();
          p.setVisible(true);
          
    }
    /*private static void checkDirectoryContents(File currentDir) {
        File[] files = dir.listFiles();
        boolean studentFile = true;
        
        for(File file : files){
            if(file.getName().contains("Students.bin")){
                studentFile = false
        }
        }
        
    }*/
    
}
