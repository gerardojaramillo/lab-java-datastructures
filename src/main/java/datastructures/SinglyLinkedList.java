/**
 * SinglyLinkedList.java
 * @author Gerardo Jaramillo (https://gerardojaramillo.dev)
 * 
 * This example is using just a head node to handle all the operations, there is no tail no length for this implementation.
 * 
 * Operations: 
 * insertAtHead(T data) -> O(1) 👍🏻
 * insertAtTail(T data) -> O(n) 👍🏻
 * insertAt(int index, T data) -> O(n) 👍🏻
 * deleteAt(int index) -> O(n) 👍🏻
 * deleteByValue(T data) -> O(n) 👍🏻
 * search(T data)
 * reverse()
 * length() 👍🏻
 * toString() 👍🏻
 * 
 */

package datastructures;

import static java.lang.System.out;

public class SinglyLinkedList<T> {

    Node<T> head;

    public SinglyLinkedList() {
        super();
    }

    public SinglyLinkedList(T data) {
        head = new Node<T>(data);
    }

    /** length O(n) */
    int length() {
        int counter = 0;
        var temp = head;
        while (temp != null) {
            temp = temp.next;
            counter++;
        }
        return counter;
    }

    /** insertAtHead O(1) */
    void insertAtHead(T data) {
        var newNode = new Node<T>(data);
        newNode.next = head;
        head = newNode;
    }

    /** insertAtTail O(n) */
    void insertAtTail(T data) {
        var newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
            return;
        }
        var curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    /** insertAt(int index, T data) */
    void insertAt(int index, T data) {
        if (index < 0 || index > length() - 1)
            throw new IndexOutOfBoundsException(index);
        if (index == 0) {
            insertAtHead(data);
            return;
        }
        var curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        var newNode = new Node<T>(data);
        newNode.next = curr.next;
        curr.next = newNode;
    }

    /** deleteAt(int index) O(n) */
    void deleteAt(int index) {
        if (index < 0 || index > length()) {
            throw new IndexOutOfBoundsException(index);
        }
        if (head == null) {
            throw new IndexOutOfBoundsException("SinglyLinkedList is Empty");
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        var curr = head;
        /** Move forward to the previous node that we want to delete. */
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
    }

    /** deleteByValue(T data) O(n) */
    void deleteByValue(T data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        var curr = head;
        while (curr.next != null &&
                curr.next.data != data) {
            curr = curr.next;
        }
        if (curr.next != null) {
            curr.next = curr.next.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("SinglyLinkedList: [");
        var curr = head;
        while (curr != null) {
            b.append(curr);
            curr = curr.next;
        }
        b.append(']');
        return b.toString();
    }

    class Node<U> {

        Node<U> next;

        U data;

        public Node(U data) {
            this.data = data;
        }

        @Override
        public String toString() {
            StringBuilder b = new StringBuilder();
            b.append(data).append(',');
            return b.toString();
        }

    }

    public static void main(String[] args) {
        var sll = new SinglyLinkedList<Character>();
        sll.insertAtTail('d');
        sll.insertAtTail('e');
        sll.insertAtTail('f');
        sll.insertAtTail('g');
        sll.insertAtHead('b');
        sll.insertAtHead('a');
        sll.insertAt(2, 'c');
        sll.insertAt(0, '3');
        out.println(sll.toString());
        sll.deleteAt(0);
        out.println(sll.toString());
        sll.deleteAt(2);
        out.println(sll.toString());
        sll.deleteByValue('g');
        out.println(sll.toString());
        sll.deleteByValue('d');
        out.println(sll.toString());

        out.println(String.format("sll length: %d", sll.length()));
    }

}
