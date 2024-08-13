import java.util.*;
import java.io.*;

public class MyList {
    Node head;

    MyList() {
        this.head = null;
    }
    
    public boolean isEmpty() {
        return this.head == null;
    }
    
    public void clear() {
        this.head = null;
    }
    
    void traverse_Recursion(Node p){ // Hàm đệ quy lun có tham số
        if (p == null) { //base case
            
            return;
        }
        else{ // p != null
            // in p ra màn hình 
            System.out.print(p.info + " ");
            traverse_Recursion(p.next); // inductive case
        }
    }
    
    void traverse_Recursion2(Node p){ // Hàm đệ quy lun có tham số
        if (p == null) { //base case
           return;
        }
        else{ // p != null
            // in p ra màn hình 
            traverse_Recursion2(p.next); // inductive case
             System.out.print(p.info + " ");
        }
    }
    
    void traverse(){
        // hay viet lai ham traverse bang de quy
        traverse_Recursion(head); // call to Recursion
        System.out.println("\n");
//        traverse_Recursion2(head); // đảo chiều 
    }
    
    void loadData(int k) {
        for(int i = 0; i < k; i++) 
        {
            Random generator = new Random();
            int number = generator.nextInt(1000) + 1;
            addFirst(number);
        }
    }
     
    void addFirst(int n) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
		head = new Node(n, head);
        
        
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
    }
    
    
    void f1(){
        System.out.print("Linked list:   ");
        this.traverse();
    }
    
    Node addLast(Node p, int n){
        if (p == null) { // list rỗng
            p = new Node(n);
            return p;
        }
        if (p.next == null) { // list có 1 node duy nhất
            p.next = new Node(n);
            return p;
        }
        else{                   // gọi đệ quy 
            addLast(p.next, n);
            return p ;
        }
        
    }
    
    // f2: ham addLast ==> du lieu nhap tu ban phim
    void f2(){
        System.out.print("Before:   ");
        this.traverse();
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        addLast(head, 72);

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        System.out.print("After:    ");
        this.traverse();
    }
    
    // f3: find Max
    Node FindMax_Recursion (Node p ){
        if (p == null || p.next == null) {
            return p;
        }
        
        Node maxNode = FindMax_Recursion(p.next);
        
        return (p.info > maxNode.info ) ? p : maxNode;
        
    }
    void f3(){
        System.out.print("List:   ");
        this.traverse();
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

       
        Node maxNode = FindMax_Recursion(head);
        if (maxNode!= null ) {
            System.out.println("Maximum value " + maxNode.info);
        } else
        System.out.println("Empty value");
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
    }
    
    // f4: compute sum
     int ComputeSum_Recursion(Node p){
        if (p == null) {
            return 0;
        }
        else{
            return (p.info + ComputeSum_Recursion(p.next));
        }
    }
    void f4() {
        System.out.print("List:   ");
        this.traverse();
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        int sum =ComputeSum_Recursion(head);
        System.out.println("Sum " + sum);

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
    }
	
    // f5: count Node
    int count_Recursion(Node p){
        if (p == null) {
            return 0;
        }
        else{
            return (1 + count_Recursion(p.next));
        }
    }
    
    void f5() throws Exception {
        System.out.print("List:   ");
        this.traverse();
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

       int size = count_Recursion(head);

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
    }
}

