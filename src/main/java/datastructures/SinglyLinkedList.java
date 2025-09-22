/**
 * SinglyLinkedList.java
 * @author Gerardo Jaramillo (https://gerardojaramillo.dev)
 * 
 * This example is using just a head node to handle all the operations, there is no tail no length for this implementation.
 * 
 * Operations: 
 * insertAtHead(T data) -> O(1)
 * insertAtTail(T data) -> O(n)
 * insertAt(int index, T data)
 * deleteAt(int index)
 * deleteByValue(T data)
 * search(T data)
 * reverse()
 * length()
 * toString()
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

    /** length Big O o(n) */
    int length() {
        int counter = 0;
        var temp = head;
        while (temp != null) {
            temp = temp.next;
            counter++;
        }
        return counter;
    }

    /** insertAtHead Big O o(1) */
    void insertAtHead(T data) {
        var newNode = new Node<T>(data);
        newNode.next = head;
        head = newNode;
    }

    /** insertAtTail Big O o(n) */
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

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        var curr = head;
        while (curr != null) {
            b.append(curr);
            curr = curr.next;
        }
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
        var sll = new SinglyLinkedList<Integer>();
        sll.insertAtTail(5);
        sll.insertAtTail(6);
        sll.insertAtTail(7);
        sll.insertAtHead(3);
        sll.insertAtHead(1);
        sll.insertAtHead(9);
        out.println(String.format("sll length: %d", sll.length()));
        out.println(sll.toString());
    }

}
