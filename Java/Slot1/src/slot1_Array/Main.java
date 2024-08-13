/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slot1_Array;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bolic
 */

public class Main {
    
    public static void main(String[] args) {
        ClassRoom classRoom = new ClassRoom();

        // Create list of 10 students
        List<Student> students = new ArrayList<>();
        students.add(new Student("John Doe", "Hanoi", 3.9));
        students.add(new Student("Jane Doe", "Danang", 3.8));
        students.add(new Student("Jim Beam", "HCM", 3.7));
        students.add(new Student("Lucy Smith", "Hue", 3.6));
        students.add(new Student("Michael Brown", "Can Tho", 3.5));
        students.add(new Student("Emily Davis", "Nha Trang", 3.4));
        students.add(new Student("Daniel Joke", "Quang Nam", 3.1));
        students.add(new Student("Sophia Taylor", "Vung Tau", 3.2));
        students.add(new Student("James Moore", "HCM", 3.1));
        students.add(new Student("Olivia White", "Binh Dinh", 3.0));
        students.add(new Student("Daniel Wilson", "Quang Nam", 3.3));
        students.add(new Student("Sophia Ben", "HCM", 3.81));
        students.add(new Student("Ben Javue", "HCM", 3.21));
        students.add(new Student("Olivia White", "Binh Dinh", 3.0));

        classRoom.addStudent(students);

        List<Student> top10NonHCMStudents = classRoom.GetTop10StudenNonHCM();
        for (Student student : top10NonHCMStudents) {
            System.out.println(student);
        }
    }

}
