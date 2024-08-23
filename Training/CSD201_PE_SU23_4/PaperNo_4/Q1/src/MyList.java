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
    void addLast(String xSea, int xSail, int xPaddle) {
        //You should write here appropriate statements to complete this function.
        if (xSea.charAt(0) == 'A') {
            return;
        }
        Boat newBoat = new Boat(xSea, xSail, xPaddle);
        Node newNode = new Node(newBoat, null);
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
    void addInPosition(int p, Boat newBoat) { //thêm vào vị trí nào đó 
        Node current = head;
        Node newNode = new Node(newBoat);
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
        Boat x, y, z;
        x = new Boat("X", 1, 2);
        y = new Boat("Y", 2, 3);
        z = new Boat("Z", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        addInPosition(1, x);
        addInPosition(3, y);
        addInPosition(4, z);
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
        // Step 1: Find the maximum paddle value
        Node p = head;
        int maxPaddle = Integer.MIN_VALUE;
        while (p != null) {
            if (p.info.paddle > maxPaddle) {
                maxPaddle = p.info.paddle;
            }
            p = p.next;
        }

        // Step 2: Identify the second node with the maximum paddle value
        p = head;
        Node prev = null;
        Node firstMax = null;
        Node secondMax = null;
        while (p != null) {
            if (p.info.paddle == maxPaddle) {
                if (firstMax == null) {
                    firstMax = p;
                } else {
                    secondMax = p;
                    break;
                }
            }
            prev = p;
            p = p.next;
        }

        // Step 3: Move the second node to the tail if it exists
        if (secondMax != null) {
            if (secondMax == tail) {
                // Already at the tail, no need to move
            } else {
                // Unlink the secondMax node
                prev.next = secondMax.next;
                // Add secondMax node to the tail
                tail.next = secondMax;
                tail = secondMax;
                tail.next = null;
            }
        }

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
        if (count < 8) {
            f.close();
            return; // Not enough elements to reverse the last 8
        }
        // Navigate to the 2nd element
        Node first = head;
        Node prev = head;
        current = head.next;
        for (int i = 1; i < 2; i++) {
            prev = current;
            current = current.next;
        }
        // Extract the 5 elements
        Node[] nodes = new Node[5];
        for (int i = 0; i < 5; i++) {
            nodes[i] = current;
            current = current.next;
        }
        // Sort the array
        Arrays.sort(nodes, (a, b) -> a.info.paddle - b.info.paddle);
        // sắp xếp paddle info từ bé tới lớn 
        for (int i = 0; i < 5; i++) {
            prev.next = nodes[i];
            prev = nodes[i];
        }
        prev.next = current;

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
