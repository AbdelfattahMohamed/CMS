/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course;

import java.io.*;
import java.util.*;

/**
 *
 * @author abdelfattah
 */
public class Instructor extends Person implements Serializable {

    private static final long serialVersionUID = 3505021587872211745L;

    public Instructor(String name, int id, String courseName, String password, String username) {
        super(name, id, courseName, password, username);

    }

    private double salary;
    private final String FilePath = "Course.bin";
    private ArrayList<Course> x = new ArrayList<>();
    private fileManager fManager = new fileManager();

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void AddGrade(int Cid, int Sid, double grade) {
        LoadFile();
        int C_index = -1, S_index = -1;
        C_index = SearchCourse(Cid);
        if (C_index != -1) {
            S_index = SearchStudent(C_index, Sid);
            if (S_index != -1) {
                x.get(C_index).grades.add(S_index, grade);

            } else {
                System.out.println("student not found");
            }
        } else {
            System.out.println("course not found");
        }
        WriteAgain();

        //    print(C_index,S_index);
    }

    public void LoadFile() {
        x = (ArrayList<Course>) fManager.read(FilePath);
    }

    public boolean WriteAgain() {
        return fManager.write(FilePath, x);
    }

    public int SearchCourse(int Cid) {
        int i;
        for (i = 0; i < x.size(); i++) {
            if ((x.get(i).getId()) == Cid) {
                return i;
            }
        }
        return -1;
    }

    public int SearchStudent(int C_index, int Sid) {
        int j;
        for (j = 0; j < (x.get(C_index).students.size()); j++) {
            if ((x.get(C_index).students.get(j).getId()) == Sid) {
                return j;
            }
        }

        return -1;
    }
//    
//    public void print(int cindex , int sindex)
//    {
//        double z = (x.get(cindex).grades.get(sindex));
//        System.out.println(z);
//    }

}
