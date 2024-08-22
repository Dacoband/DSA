/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
    void addLast(String xPlace, int xWeight, int xColor) { //f1
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        Bike xBike = new Bike(xPlace, xWeight, xColor);
        Node xNode = new Node(xBike);
        if (xWeight < 0) {
            return;
        }
        if (isEmpty()) {
            head = tail = xNode;
        } else {
            tail.next = xNode;
            tail = xNode;
        }
        //---------------------------------------------------------
    }

    //==================================================================
    //You do not need to edit this function. Your task is to complete 
    //the addLast function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        head = head.next.next.next;

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        
        //Di chuyển phần tử thứ 3 về cuối
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        Node prev = head;
        Node current = head.next;
        Node third = current.next; // có thể chỉnh ở đây để muốn di chuyển element nào 

        if (third.next != null) {
            current.next = third.next;
        } else 
        {
            current.next = null;
        }
        tail.next = third;
        tail = third;
        third.next = null;
//------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        
        // đếm những Node có xColor > 0
        int result = 0;
        result = CountColor(0);
        f.writeBytes(result + "");

        //------------------------------------------------------------------------------------
        f.close();
    }
    int CountColor(int value){
        int count = 0;
        Node current = head;
        while (current != null) {            
            if (current.info.color > value ) {
                count++;
            }
            current = current.next;
        }
        return count;
    }

//==================================================================
    
    void sortByWeight(){
        if (isEmpty()) {
            return;
        }
        boolean sorted;
        do {            
            sorted = true;
            Node current = head;
            Node nextNode = current.next;
            while (nextNode != null) {                
                if (current.info.weight <  nextNode.info.weight) {
                    Bike temp =  current.info;
                    current.info = nextNode.info;
                    nextNode.info = temp;
                    sorted = false;
                }
                current = nextNode;
                nextNode = current.next;
            }
        } while (!sorted);
    }
    void f5() throws Exception {
        clear();
        loadData(17);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        
        //Xóa nốt đầu và sort weight từ lớn tới nhỏ
        if (head != null) {
            head = head.next;
        }
        sortByWeight();
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
