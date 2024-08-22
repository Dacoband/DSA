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
    void insert(String xPlace, int xPrice, int xType) {
        //You should insert here statements to complete this function
        if (xPlace.charAt(0) == 'A') {
            return;
        }
        Brick newBrick = new Brick(xPlace, xPrice, xType);
        Node newNode = new Node(newBrick);
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node pre = null;
        while (current != null) {
            if (xType < current.info.type) {
                pre = current;
                current = current.left;
            } else if (xType > current.info.type) {
                pre = current;
                current = current.right;
            } else if (xType == current.info.type) {
                return;
            }
        }
        if (pre.info.type > xType) {
            pre.left = newNode;
        } else {
            pre.right = newNode;
        }
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
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
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
        preOrder2(root, f);
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    void preOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if (p.left != null || p.right != null) {
            fvisit(p, f);
        }
        preOrder2(p.left, f);
        preOrder2(p.right, f);
    }

//=============================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
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
        inOrder2(root, f);
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    Node parent(Node p) {
        Node current = root;
        Node parent = null;
        while (current != null) {
            if (current.info.type == p.info.type) {
                break;
            }
            parent = current;
            if (p.info.type < current.info.type) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return parent;
    }
    int count = 0;

    void inOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder2(p.left, f);
        count++;
        if (count == 4) {
            deleteByCopy(p);
        }
//        System.out.println(count);
//        fvisit(p, f);
        inOrder2(p.right, f);
    }

    void deleteByCopy(Node n) {
        if (n == null) {
            return;
        }
        if (n.left == null && n.right == null) {
            deleteLeafNode(n);
        } else if (n.left == null || n.right == null) {
            deleteLeafWithOneChild(n);
        } else {
            Node rightMost = n.left;
            while (rightMost.right != null) {
                rightMost = rightMost.right;
            }
            n.info = rightMost.info;
            deleteLeafNode(rightMost);
        }
    }

    void deleteLeafWithOneChild(Node n) {
        Node p = parent(n);
        if (n == null) {
            return;
        }
        Node child = (n.left != null) ? n.left : n.right;
        if (p == null) {
            root = child;
            return;
        }
        if (n == p.left) {
            p.left = child;
        } else {
            p.right = child;
        }
    }

    void deleteLeafNode(Node n) {
        Node p = parent(n);
        if (p == null) {
            root = null;
            return;
        }
        if (p.left == n) {
            p.left = null;
        } else {
            p.right = null;
        }
    }

//=============================================================
    void f4() throws Exception {
        clear();
        loadData(13);;
        String fname = "f4.txt";
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
        preOrder3(root, f);
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    int count2 = 0;

    void preOrder3(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if (p.right != null) {
            count2++;
            if (count2 == 3) {
                rotateToleft(p);
            }
        }
        preOrder3(p.left, f);
        preOrder3(p.right, f);
    }

    void rotateToleft(Node n) {
        if (n == null || n.right == null) {
            return;
        }
        Node parent = parent(n);
        if (parent == null) {
            return;
        }
        if (n == parent.right) {
            parent.right = n.right;
            n.right.left = n;
            n.right = null;
        } else {
            parent.left = n.right;
            n.right.left = n;
            n.right = null;
        }
    }

}
