/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTVN;

/**
 *
 * @author bolic
 */
public class MyList {
    Node head;

    MyList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void clear() {
        this.head = null;
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            System.out.print(p.info + " ");
            p = p.next;
        }
        System.out.println();
    }

    void addFirst(int n) {
        Node newNode = new Node(n, head);
        head = newNode;
    }

    void addLast(int n) {
        Node newNode = new Node(n, null);
        if (head == null) {
            head = newNode;
        } else {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = newNode;
        }
    }

    int sum() {
        int sum = 0;
        Node p = head;
        while (p != null) {
            sum += p.info;
            p = p.next;
        }
        return sum;
    }

    int findMax() {
        if (head == null) return Integer.MIN_VALUE;
        int max = head.info;
        Node p = head.next;
        while (p != null) {
            if (p.info > max) {
                max = p.info;
            }
            p = p.next;
        }
        return max;
    }

    int findMin() {
        if (head == null) return Integer.MAX_VALUE;
        int min = head.info;
        Node p = head.next;
        while (p != null) {
            if (p.info < min) {
                min = p.info;
            }
            p = p.next;
        }
        return min;
    }

    void removeMax() {
        int max = findMax();
        Node p = head;
        Node prev = null;
        while (p != null) {
            if (p.info == max) {
                if (prev == null) {
                    head = p.next;
                } else {
                    prev.next = p.next;
                }
                return;
            }
            prev = p;
            p = p.next;
        }
    }

    void removeEven() {
        Node p = head;
        Node prev = null;
        while (p != null) {
            if (p.info % 2 == 0) {
                if (prev == null) {
                    head = p.next;
                } else {
                    prev.next = p.next;
                }
            } else {
                prev = p;
            }
            p = p.next;
        }
    }

    void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
}
