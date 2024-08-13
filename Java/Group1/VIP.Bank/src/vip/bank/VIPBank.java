/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vip.bank;

import Model.Customer;
import Model.Employee;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bolic
 */
public class VIPBank {

    
    public static void main(String[] args) {
       List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Nhân viên", "rảnh"));
        employees.add(new Employee(2, "Nhân viên", "rảnh"));
        employees.add(new Employee(3, "Nhân viên", "rảnh"));
        employees.add(new Employee(5, "Quản lí", "rảnh"));
        employees.add(new Employee(6, "Quản lí", "rảnh"));

        MyQueue queue = new MyQueue();

        // TestCase 1: VIP customer and Normal customer arrive
        System.out.println("TH1:");
        queue.enqueueWithPriority(new Customer(1, "Vip"), employees); 
        queue.enqueueWithPriority(new Customer(2, "Normal"), employees);  

        // TestCase 2: Two VIP customers arrive simultaneously
        System.out.println("TH2:");
        queue.enqueueWithPriority(new Customer(3, "Vip"), employees);  
        queue.enqueueWithPriority(new Customer(4, "Vip"), employees); 

        // TestCase 3: All employees are busy and a VIP arrives
        System.out.println("TH3:");
        queue.enqueueWithPriority(new Customer(5, "Vip"), employees); 
        
        System.out.println("TH4:");
        queue.enqueueWithPriority(new Customer(6, "Vip"), employees); 
        queue.enqueueWithPriority(new Customer(7, "Normal"), employees); 
        queue.enqueueWithPriority(new Customer(8, "Normal"), employees); 
        queue.enqueueWithPriority(new Customer(9, "Vip"), employees);
    }
    
}
