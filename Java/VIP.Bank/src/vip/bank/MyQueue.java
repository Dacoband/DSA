package vip.bank;


import Model.Customer;
import Model.Employee;
import java.util.*;
import java.io.*;

public class MyQueue {

    Node head, tail;

    public MyQueue() {
        this.head = this.tail = null;
    }

    // Method to add an key to the queue.
    void enqueue(int key) {
        Node newNode = new Node(key);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Method to remove an key from queue.
    void dequeue() {

        if (head == null) {
            System.out.println("Queue is empty");
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }

    }

    // Utility function to check if the stack is empty or
    // not
    public boolean isEmpty() {
        return head == null;
    }

    // Utility function to return top element in a stack
    public int front() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return head.info;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.next;
        }
        System.out.println();
    }

    void enqueueWithPriority(Customer customer, List<Employee> employees) {
        if (customer.getCardType().equals("Vip")) {
     
            for (Employee employee : employees) {
                if (employee.getPosition().equals("Quản lí") && employee.getStatus().equals("rảnh")) {
                    System.out.println("Quản lí " + employee.getId() + " is serving VIP customer " + customer.getID());
                    employee.setStatus("bận");
                    return;
                }
            }


            for (Employee employee : employees) {
                if (employee.getPosition().equals("Nhân viên") && employee.getStatus().equals("rảnh")) {
                    System.out.println("Nhân viên " + employee.getId() + " is serving VIP customer " + customer.getID());
                    employee.setStatus("bận");
                    return;
                }
            }


            for (Employee employee : employees) {
                if (employee.getPosition().equals("Nhân viên") && employee.getStatus().equals("bận")) {
                    System.out.println("Nhân viên " + employee.getId() + " stops serving a normal customer and serves VIP customer " + customer.getID());
                    return;
                }
            }
        } else {

            for (Employee employee : employees) {
                if (employee.getPosition().equals("Nhân viên") && employee.getStatus().equals("rảnh")) {
                    System.out.println("Nhân viên " + employee.getId() + " is serving normal customer " + customer.getID());
                    employee.setStatus("bận");
                    return;
                }
            }
        }
        // If no one is free, enqueue the customer
        enqueue(customer.getID());
    }
}
