/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void clear() {
        root = null;
    }

    void visit(Node p) {
        System.out.print("p.info: ");
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void breadth(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }

    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }

    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
   
    Node insertRec(Node p, String xPlace, int xWeight, int xColor) {
        if (p == null) {
            return new Node(new Cat(xPlace, xWeight, xColor));
        }
        if (xWeight == p.info.weight) {
            return p; // Do not insert duplicate weights
        }
        if (xWeight < p.info.weight) {
            p.left = insertRec(p.left, xPlace, xWeight, xColor);
        } else {
            p.right = insertRec(p.right, xPlace, xWeight, xColor);
        }
        return p;
    }

    void insert(String xPlace, int xWeight, int xColor) {
        //---------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        if (xPlace.charAt(0) == 'N') {
            return;
        }  
            root = insertRec(root, xPlace, xWeight, xColor);
        //--------------------------------------- 
    }

//Do not edit this function. Your task is to complete insert function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void preOrderLeft(Node p, RandomAccessFile f) throws Exception{
        if (p == null) {
            return;
        }
        if (p.info.color != 4) {
            fvisit(p, f);
        }
        preOrderLeft(p.left, f);
        preOrderLeft(p.right, f);
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
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        if (root != null && root.left != null) {
            preOrderLeft(root.left, f);
        }
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
//=============================================================
    
    void decesdingOrder(Node p, RandomAccessFile f) throws Exception{
        if (p == null) {
            return;
        }
        decesdingOrder(p.right, f);
        fvisit(p, f);
        decesdingOrder(p.left, f);
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
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        decesdingOrder(root, f);
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void preOrderLeafNode(Node p, RandomAccessFile f) throws Exception{
        if (p == null) { // lấy ra những node lá
            return;
        }
        if (p.left == null && p.right == null && p.info.color < 7 ) {
            fvisit(p, f);
        }
        preOrderLeafNode(p.left, f);
        preOrderLeafNode(p.right, f);
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
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        preOrderLeafNode(root, f);
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
//=============================================================

    int countInternalNode(Node p){
        if (p == null) {
            return 0;
        }
        if (p.left == null && p.right == null) {
            return 0;
        }
        return 1 + countInternalNode(p.left) + countInternalNode(p.right);
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
        inOrder(root, f);
        f.writeBytes("\r\n");
        int result = 0;
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        result = countInternalNode(root);
        // hint: you should create a function named "countNode()",  
        // then just call "result = this.countNode()" to complete this requirement 
        //------------------------------------------------------------------------------------
        f.writeBytes(result + "\r\n");
        f.close();
    }
}
