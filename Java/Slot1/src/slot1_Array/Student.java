/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slot1_Array;

/**
 *
 * @author bolic
 */
public class Student {
        private String Name;
        private String Country;
        private double GPA;

    public Student(String Name, String Country, double GPA) {
        this.Name = Name;
        this.Country = Country;
        this.GPA = GPA;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student{" + "Name=" + Name + ", Country=" + Country + ", GPA=" + GPA + '}';
    }
                   
}
