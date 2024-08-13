
import java.util.*;
import java.io.*;

class MyTree {

    Node root;

    // Constructor
    MyTree() {
        this.root = null;
    }

    public void load() {
        root = new Node(50);
        root.left = new Node(15);
        root.right = new Node(70);
        root.left.left = new Node(5);
        root.left.right = new Node(40);
        root.right.left = new Node(35);
        root.right.right = new Node(20);
        root.right.right.left = new Node(30);
        root.left.right.left = new Node(60);
        root.left.right.left.right = new Node(100);
    }

    public int countNode_Rec(Node p){
        if(p==null){
            return 0;
        }
        return(1+countNode_Rec(p.left)+countNode_Rec(p.right));
    }
    
    public int ComputeHeight(Node p){
        if (p == null) {
            return 0;
        }
        int leftHeight = ComputeHeight(p.left);
        int rightHeight = ComputeHeight(p.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public int computeSum(Node p){
        if (p == null) {
            return 0 ;
        } 
        return (p.info + computeSum(p.left) + computeSum(p.right)) ;
    }
    
    public int countLeafNodes(Node p) {
        if (p == null) {
            return 0;
        }
        if (p.left == null && p.right == null) {
            return 1;
        }
        return countLeafNodes(p.left) + countLeafNodes(p.right);
    }
    
    public int findMaxRecursion(Node p) {
    
    if (p == null) {
        return Integer.MIN_VALUE;
    }
    
    int leftMax = findMaxRecursion(p.left);
    int rightMax = findMaxRecursion(p.right);
    
    return Math.max(p.info, Math.max(leftMax, rightMax));
}
    
    public int f1() {
        return ComputeHeight(root);
    }

    public int f2() {
        
        return countNode_Rec(root);
    }

    public int f3() {
        return countLeafNodes(root);
    }

    public int f4() {
        return computeSum(root);
    }
    
    public int f5(){
        return findMaxRecursion(root);
    }

}
