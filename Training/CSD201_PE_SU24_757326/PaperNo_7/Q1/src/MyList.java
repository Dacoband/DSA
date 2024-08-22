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
    void addLast(String xPlace, int xPrice, int xType) {
        //You should write here appropriate statements to complete this function.
        if (xPlace.charAt(0) == 'A') {
            return;
        }
        Brick newBrick = new Brick(xPlace, xPrice, xType);
        Node newNode = new Node(newBrick, null);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    //You do not need to edit this function. Your task is to complete the addLast function above only.
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
        Brick x, y, z;
        x = new Brick("X", 1, 2);
        y = new Brick("Y", 2, 3);
        z = new Brick("Z", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        addInPosition(1, x);
        addInPosition(2, y);
        addInPosition(5, z);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void addInPosition(int p, Brick newBrick) {
        Node current = head;
        Node newNode = new Node(newBrick);
        if (p == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        while (current != null && p > 1) {
            current = current.next;
            p--;
        }
        newNode.next = current.next;
        current.next = newNode;
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
        Node ENode = findNode("E");
        Node GNode = findNode("G");
        if (ENode != null && GNode != null) {
            Brick temp = ENode.info;
            ENode.info = GNode.info;
            GNode.info = temp;
        }

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    Node findNode(String xplace) {
        Node current = head;
        while (current != null) {
            if (current.info.place.equals(xplace)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    void sort() {
        Node INode = findNode("I");
        Node pi, pj;
        Brick x;
        pi = head;
        while (pi != null && pi.next != INode) {
            pj = pi.next;
            while (pj != null && pj != INode) {
                if (pj.info.price < pi.info.price) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
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
        sort();
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
