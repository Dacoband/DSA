/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

class MyList {

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

    void loadData(int k) //do not edit this function
    {
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
    void addLast(String xType, int xCapacity, int xPrice) {
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        if (xPrice < 1000) {
            return;
        }
        Plane newPlane = new Plane(xType, xCapacity, xPrice);
        Node newNode = new Node(newPlane);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        //------------------------------------------------------------------------------------		
    }

    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
         */
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
        Plane x = new Plane("Boeing747", 400, 1500);
        Plane y = new Plane("AirbusA300", 300, 2000);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node newNode = new Node(y, head);
        head = newNode;

        Node xNode = new Node(x);

        tail.next = xNode;
        Plane temp = tail.info;
        tail.info = xNode.info;
        xNode.info = temp;

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

        // Hoán đổi vị trí 0 (Head) với pos 4 
        if (head == null || head.next == null) {
            return;
        }
        Node p = head;
        for (int i = 0; i < 4; i++) {
            if (p.next != null) {
                p = p.next;
            } else {
                return;
            }
        }
        Plane temp = head.info;
        head.info = p.info;
        p.info = temp;
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
        Node current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        if (count < 6) {
            f.close();
            return; // Not enough elements to reverse the last 5
        }
        // Navigate to the 2nd element
        Node first = head;
        Node prev = head;
        current = head.next;
        for (int i = 1; i < 2; i++) {
            prev = current;
            current = current.next;
        }
        // đảo ngược 5 phần tử cuối
        Node next = null;
        Node tail = current;
        Node newHead = null;
        for (int i = 0; i < 5 && current != null; i++) {
            next = current.next;
            current.next = newHead;
            newHead = current;
            current = next;
        }
        prev.next = newHead;
        tail.next = current;

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
