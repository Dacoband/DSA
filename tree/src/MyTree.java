
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

    public int countNode_Rec(Node t){
        if(t==null){
            return 0;
        }
        return(1+countNode_Rec(t.left)+countNode_Rec(t.right));
    }
    
    public int f1() {
        return 0;
    }

    public int f2() {
        return 0;
    }

    public int f3() {
        return 0;
    }

    public int f4() {
        return 0;
    }

}
