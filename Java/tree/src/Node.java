class Node {

    int info;
    Node left, right;

    Node(int x, Node l, Node r) {
        info = x;
        left = l;
        right = r;
    }

    Node(int x) {
        this(x, null, null);
    }
}