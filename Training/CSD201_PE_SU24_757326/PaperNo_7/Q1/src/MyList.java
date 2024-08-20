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

        Node newNode = new Node(newBrick);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

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
        Node nodeX = new Node(x);
        nodeX.next = head.next;
        head.next = nodeX;

        Node nodeY = new Node(y);
        nodeY.next = nodeX.next;
        nodeX.next = nodeY;

        Node nodeZ = new Node(z);
        Node p = head;
        for (int i = 0; i < 4; i++) {
            p = p.next;
        }
        nodeZ.next = p.next;
        p.next = nodeZ;

        // Update the size variable manually, if necessary
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        //---------------------------------------1---------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void swapEandG(Node current) {
        if (current == null) {
            return;
        }

        Node eNode = findNode(current, "E");
        Node gNode = findNode(current, "G");

        if (eNode != null && gNode != null) {
            Brick temp = eNode.info;
            eNode.info = gNode.info;
            gNode.info = temp;
        }
    }

    Node findNode(Node current, String place) {
        if (current == null) {
            return null;
        }
        if (current.info.place.equals(place)) {
            return current;
        }
        return findNode(current.next, place);
    }

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
        swapEandG(head);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    Node sortBeforeNOde(Brick x,Node first, Node last) {
        if (first == null || first == last) {
            return first;
        }
        first.next = sortBeforeNOde(first.next, last);
        if (first.next != last && first.info.price > first.next.info.price) {
            first = swapNodes(first, first.next);
        }
        return first;
    }

    Node swapNodes(Node node1, Node node2) {
        node1.next = node2.next;
        node2.next = node1;
        return node2;
    }

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
        Node p = findNode(head, "I");
        if (p != null) {
            head = sortBeforeNOde(head, p);
        }
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
