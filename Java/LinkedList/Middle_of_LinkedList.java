package LinkedList;
import java.util.ArrayList;
import java.util.Scanner;

public class Middle_of_LinkedList {

class Node{
    public int data;
    public Node next;
}

class NodeList{
    public void pushNode(Node[] headRef, int dataval){
    //Allocate node    
    Node newNode= new Node();
    // Put in the data array
    newNode.data = dataval;
    //Link the old list of the new node
    newNode.next = headRef[0];
    //move the head to point to the new node
    headRef[0] = newNode;
    }

}

//driver methods
   public static void main(String[] args) {

    // input the length of arrray
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the length of the Arrays: ");
    int length = scanner.nextInt();

    //create a new nodeList
    Node[] head = new Node[1];
    Middle_of_LinkedList.NodeList temp = new Middle_of_LinkedList().new NodeList();
    // for (int i = 5; i > 0; i--) {
    //     temp.pushNode(head, i);
    // }

    //Input array elements form the user
    System.out.println("Enter the elements of the array: ");
    for(int i = 0; i < length; i++) {
        int elements = scanner.nextInt();
        temp.pushNode(head, elements);
    }
    ArrayList<Integer> v = new ArrayList<Integer>();
    Node curr = head[0];
    while (curr != null) {
        v.add(curr.data);
        curr = curr.next;
    }

    System.out.print("Middle Value Of Linked List is : ");
    System.out.println(v.get(v.size() / 2));
}
   }



