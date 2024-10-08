package BST;

import java.util.LinkedList;
public class Queue {
    

    LinkedList<Object> head;

    public Queue() {
        head = new LinkedList<>();
    }

    public void enqueue(Object obj) {
        head.addLast(obj);
    }

    public boolean isEmpty() {
        return head.isEmpty();
    }

    public Object dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            return head.removeFirst();
        }
    }

    public Object front() {
        if (isEmpty()) {
            return null;
        } else {
            return head.getFirst();
        }
    }

    public void clear() {
        head = null;
    }
}
