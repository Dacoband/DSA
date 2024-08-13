
import java.util.*;
import java.io.*;

class MyTree {

    Node root;

    MyTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node p, int value) {
        if (p == null) {
            p = new Node(value);
        } else if (value < p.info) {
            p.left = insertRec(p.left, value);
        } else if (value > p.info) {
            p.right = insertRec(p.right, value);
        }
        return p;
    }

    public void load() {
        insert(20);
        insert(10);
        insert(30);
        insert(5);
        insert(15);
        insert(25);
        insert(35);
        insert(100);

    }

    int search(Node p, int x) {
        if (p == null) {
            return 0;
        }
        if (p.info == x) {
            return 1;
        }
        if (x < p.info) {
            return (search(p.left, x));
        } else {
            return (search(p.right, x));
        }
    }
    
    int computeHeight(Node p){
        if (p == null) {
            return 0;
        }
        return 1 + Math.max(computeHeight(p.left), computeHeight(p.right));
    }

    public int f1() {
        return computeHeight(root);
    }
    
    int countNode(Node p){
        if (p == null) {
            return 0;
        }
        return 1 + countNode(p.left) + countNode(p.right);
    }

    public int f2() {
        return countNode(root);
    }
    
    int countLeafNode(Node p){
        if (p == null) {
            return 0;
        }
        if (p.left == null || p.right == null) {
            return 1;
        }
        return countLeafNode(p.left) + countLeafNode(p.right);
    }
    
    public int f3() {
        return countLeafNode(root);
    }
    
    int computeSumNode(Node p){
        if (p == null) {
            return 0;
        }
        return p.info + computeSumNode(p.left) + computeSumNode(p.right);
    }

    public int f4() {
        return computeSumNode(root);
    }

    void visit(Node p) {
        System.out.print(p.info + "  ");
    }

    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    void f5() {
        preOrder(root);
    }

    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    void f6() {
        inOrder(root);
    }

    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    void f7() {
        postOrder(root);
    }

    int f8(int n) {
        return search(root, n);
    }

}
