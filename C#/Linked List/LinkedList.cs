// public class LinkedList{
//     Node head;
//     class Node {
//         int data;
//         Node next;
//     }
//     // Contructor for creating a new LinkedList
//     Node(int d) {
//         data = d;
//         next = null;
//     }
// } Java Style

namespace Linked{
/* A Singly Linked list Node*/
public class LinkedList{
    Node head;
    public int data;
    public Node next;
    public Node(int d) { data = d; next = null; }
}

/* Insert new node a front of the list */
public void push(int New_Data){
    Node New_Node = new Node(New_Data); // tạo node mới và đưa dữ liệu vào 
    New_Node.next = head; //đặt node mới tiếp theo làm đầu  
    head = New_Node; // di chuyển đầu để trỏ tới node mới 
}

/* Inserts a new node after the given prev_node. */
public void insertAfter(int prev_node, int New_Data){
    //1. Check if the given node is null
    if(prev_node == null){
        System.Console.WriteLine("The given previous node"
                          + " cannot be null");
        return;
    }

    Node New_Node = new Node(New_Data);//Tạo node mới và đưa dữ liệu vào 
    New_Node.next = prev_node.next; // Đật node mới làm node tiếp theo của node trước
    prev_node.next = new_Node; // Lấy node prev làm node mới 
}

/* Appends a new node at the end. This method is
defined inside LinkedList class shown above */
public void append(int New_Data){
    Node New_Node = new Node(New_Data);

    //Ktra Linked List is empty 
    if(head == null){
        head = New_Node(New_Data);
        return;
    }

    New_Node.next = null;

    Node last = head; 
    while(last.next != null)
        last = last.next;

    last.next = New_Node ;
    return

}


/* Method to print the LinkedList */
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Test the append method
        list.append(6);
        list.printList();

        // Test the push method
        list.push(7);
        list.push(1);
        list.printList();

        // Test the insertAfter method
        list.insertAfter(list.head.next, 8);
        list.printList();
    }
}