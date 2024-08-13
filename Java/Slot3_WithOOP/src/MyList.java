 import java.util.*;
import java.io.*;

public class MyList {
    Node head, tail;
    int size;

    MyList() {
        this.head = null;
        this.tail=null;
        this.size = 0;
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while(p != null) {
            f.writeBytes(p.info.name + "-" + p.info.price + "     "); // write data in the node p to the file f
            p = p.next;
        }
        
        f.writeBytes("\r\n");
    }
    
    void loadData(int k) {
        String [] a = Lib.readLineToStrArray("data.txt", k);
        String [] b = Lib.readLineToStrArray("data.txt", k+1);
        int n = a.length;
        for(int i = 0; i < n; i++) 
        {
            int p = Integer.parseInt(b[i]);
            
            addLast(a[i], p);
        }
    }
    
    void addFirst(String n, int p){
        Phone data = new Phone(n, p);
        Node newNode = new Node(data, head);
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }
     
    void addLast(String n, int p) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Phone data = new Phone(n,p);
        Node tmp_Node = new Node(data);

           
       if (head == null)
       {
           head = tail = tmp_Node;
       }
       else
       {
           tail.next = tmp_Node;
           tail = tail.next;
       }
       size++;
        
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
    }
    
    void computeSum(){
        int sum = 0;
        Node p = head;
        for(int i =0; i < size - 1; i++){
            sum = sum + p.info.price;
            p = p.next;
        }
        System.out.print("Sum price: " + sum);
    }
    
    void RemoveMax(){
        if (head == null) {
            return;
        }
        Node p = head;
        Node maxNode = head;
        Node prev = null;
        Node prevMax = null;
        while(p != null){
            if (p.info.price > maxNode.info.price) {
                maxNode = p;
                prevMax = prev; 
            }
            prev = p;
            p = p.next;
        }
        if (prevMax == null) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            prevMax.next = maxNode.next;
            if (maxNode == tail) {
                tail = prevMax;
            }
        }
        size--;
    }
    
    void discountAllPhonesWithS() {
        Node p = head;
        while (p != null) {
            if (p.info.name.startsWith("S")) {
                p.info.price = (int)(p.info.price*0.9); 
            }
            p = p.next;
        }
    }
    
	// f1: ham nay se goi ham addLast nhieu lan
    void f1() throws Exception {
        clear();
        loadData(0);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
        ftraverse(f);
        f.close();
    }
    
	// f2: ham addFirst ==> du lieu nhap tu ban phim
    void f2() throws Exception {
        clear();
        loadData(0);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
        ftraverse(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name " );
        String name = sc.nextLine();
        System.out.print("Enter price ");
        int price = sc.nextInt();
        
        addFirst(name, price);

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
    // f3: ham computeSum ==> tinh tong gia tri cua tat ca cac Phone co trong list
    void f3() throws Exception {
        clear();
        loadData(0);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
        ftraverse(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        computeSum();
        

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
	// f4: remove the most expensive Phone
    void f4() throws Exception {
        clear();
        loadData(0);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
        ftraverse(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        
        RemoveMax();

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
	
	// f5: discount all Phone 'S' with 10%
	 void f5() throws Exception {
        clear();
        loadData(0);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
        ftraverse(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        discountAllPhonesWithS();

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
  
}

