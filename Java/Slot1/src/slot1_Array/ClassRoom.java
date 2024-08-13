/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slot1_Array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import slot1_Array.Student;

/**
 *
 * @author bolic
 */
public class ClassRoom {
    private List<Student> students;

    public ClassRoom() {
        this.students = new ArrayList<>();
    }
    public void addStudent(List<Student>newStudents){
        if (students.size() + newStudents.size() <=35) {
            students.addAll(newStudents);
        } else{
            System.out.println("Adding limit pls!!!");
        }
    }
    
   public List<Student> GetTop10StudenNonHCM(){
       
       List<Student> nonStudentHCM =new ArrayList<>();
       for(Student student : students){
           if(!student.getCountry().equalsIgnoreCase("HCM")){
               nonStudentHCM.add(student);
           }
       }
       nonStudentHCM.sort(Comparator.comparingDouble(Student:: getGPA));
       
       if (nonStudentHCM.size() > 10) {
           return nonStudentHCM.subList(nonStudentHCM.size() - 1 ,nonStudentHCM.size()- 11);
       } else{
           return nonStudentHCM;
       }
   }
}
