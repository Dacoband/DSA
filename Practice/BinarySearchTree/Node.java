package BinarySearchTree;

public class Node {
    int x;
    Node left, right ;

    Node(int x, Node l, Node r){
        this.x = x;
        left = l;
        right = r;
    }

    public Node(int x){
        this.x = x;
        left = right = null;
    }

}
