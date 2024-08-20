package BinarySearchTree;

class MyTree {
    Node root;

    MyTree(){
       this.root  = null;
    }

    Node insertRec(Node p, int x){
        if (p == null) {
            p = new Node(x);
        } else if(x < p.x){
            insertRec(p.left, x);
        } else if(x > p.x){
            insertRec(p.right, x);
        }
        return p;
    }

    Node insert(int x){
        root = insertRec(root, x);
        return root;
    }

    public void load() {
        insert(8);
        insert(3);
        insert(10);
        insert(1);
        insert(6);
        insert(14);
        insert(4);
        insert(7);
        insert(13);
    }

    int search(Node p, int x){
        if (p == null) {
            return 0;
        }
        if (p.x == x) {
            return 1;
        }
        if (x < p.x) {
            return search(p.left, x);
        } else {
            return search(p.right, x);
        }
    }

    Node minValue(Node p){
        Node current = p;
        while(current.left != null){
            current = current.left;
        }
        return current;
    }
    Node deleteRec(Node p, int x){
        if (p == null) {
            return p;
        }
        if (x < p.x) {
            root.left = deleteRec(p.left, x);
        } else if(x > p.x){
            root.right = deleteRec(p.right, x);
        } else{
            if(p.left == null){
                return p.right;
            } else if(p.right == null){
                return p.left;
            }

            p.x = minValue(p.right).x;
            p.right = deleteRec(p.right, p.x);
        }
        return p;
    }
    void inorder(Node p) {
        if (p != null) {
            inorder(p.left);
            System.out.print(p.x + " ");
            inorder(p.right);
        }
    }

    public static void main(String[] args) {
        MyTree tree = new MyTree();
        tree.load();

        System.out.print("Cây BST sau khi chèn: ");
        tree.inorder(tree.root);
        tree.root = tree.deleteRec(tree.root, 3);
        tree.root = tree.deleteRec(tree.root, 14);

        System.out.print("\nCây BST sau khi xóa: ");
        tree.inorder(tree.root); // In ra cây sau khi xóa
    }
}

// Hàm in mảng
public static void printArray(int[] arr) {
    for (int num : arr) {
        System.out.print(num + " ");
    }
    System.out.println();
}

public static void main(String[] args) {
    int[] arr = {64, 34, 25, 12, 22, 11, 90};
    System.out.println("Mảng ban đầu:");
    printArray(arr);

    bubbleSort(arr);

    System.out.println("Mảng sau khi sắp xếp:");
    printArray(arr);
}