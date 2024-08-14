
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
            if (computeHeight(p.left) - computeHeight(p.right) == 2) {
                if (value < p.left.info) {
                    p = rotationWithLeftChild(p);
                } else {
                    p = doubleRotateWithLeftChild(p);
                }
            }
        } else if (value > p.info) {
            p.right = insertRec(p.right, value);
            if (computeHeight(p.right) - computeHeight(p.left) == 2) {
                if (value > p.right.info) {
                    p = rotationWithRightChild(p);
                } else {
                    p = doubleRotateWithRightChild(p);
                }
            }
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

    public void delete(int value) {
        root = deleteRec(root, value);
    }

    private Node deleteRec(Node p, int value) {
        if (p == null) {
            return p; // Không tìm thấy node để xóa
        }

        // Nếu giá trị cần xóa nhỏ hơn giá trị của node hiện tại, tìm ở cây con trái
        if (value < p.info) {
            p.left = deleteRec(p.left, value);
        } // Nếu giá trị cần xóa lớn hơn giá trị của node hiện tại, tìm ở cây con phải
        else if (value > p.info) {
            p.right = deleteRec(p.right, value);
        } // Nếu giá trị cần xóa bằng giá trị của node hiện tại, thực hiện xóa node
        else {
            // Node có một hoặc không có con
            if (p.left == null) {
                return p.right;
            } else if (p.right == null) {
                return p.left;
            }

            // Node có hai con, tìm node thay thế
            p.info = maxValue(p.left);
            p.left = deleteRec(p.left, p.info);
        }
        if (p != null) {
            if (computeHeight(p.left) - computeHeight(p.right) == 2) {
                if (computeHeight(p.left.left) >= computeHeight(p.left.right)) {
                    p = rotationWithLeftChild(p);
                } else {
                    p = doubleRotateWithLeftChild(p);
                }
            } else if (computeHeight(p.right) - computeHeight(p.left) == 2) {
                if (computeHeight(p.right.right) >= computeHeight(p.right.left)) {
                    p = rotationWithRightChild(p);
                } else {
                    p = doubleRotateWithRightChild(p);
                }
            }
        }

        return p;
    }

    private int maxValue(Node p) {
        int maxValue = p.info;
        while (p.right != null) {
            maxValue = p.right.info;
            p = p.right;
        }
        return maxValue;
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

    int computeHeight(Node p) {
        if (p == null) {
            return 0;
        }
        return 1 + Math.max(computeHeight(p.left), computeHeight(p.right));
    }

    static Node rotationWithLeftChild(Node k2) {
        Node k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }

    static Node rotationWithRightChild(Node k1) {
        Node k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }

    static Node doubleRotateWithLeftChild(Node k3) {
        k3.left = rotationWithRightChild(k3.left);
        return rotationWithLeftChild(k3);
    }

    static Node doubleRotateWithRightChild(Node k1) {
        k1.right = rotationWithRightChild(k1.right);
        return rotationWithRightChild(k1);
    }

    public int f1() {
        return computeHeight(root);
    }

    int countNode(Node p) {
        if (p == null) {
            return 0;
        }
        return 1 + countNode(p.left) + countNode(p.right);
    }

    public int f2() {
        return countNode(root);
    }

    int countLeafNode(Node p) {
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

    int computeSumNode(Node p) {
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
