package linkedList.doublyLList;

import java.util.LinkedList;
import java.util.NoSuchElementException;

class Node{
    int data;
    Node previous;
    Node next;

    Node(int data){
        this.data = data;
        previous = null;
        next = null;
    }
}

public class DoubleLinkedList {
    Node head;
    Node tail;
    DoubleLinkedList(){
        head = null;
        tail = null;
    }

    // insert a node at the beginning
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = head;
        head.previous = newNode;
        head = newNode;
    }

    // insert a node at the end
    public void addLast(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.previous = tail;
        tail = newNode;
    }

    // remove a node from the beginning
    public int removeFirst(){
        if(isEmpty()) throw new NoSuchElementException("List is empty");

        Node temp = head;
        if(head == tail){
            head = null;
            tail = null;
            return temp.data;
        }

        head = head.next;
        head.previous = null;
        temp.next = null;   // dereferencing the node
        return temp.data;
    }

    // remove a node from the end
    public int removeLast(){
        if(isEmpty()) throw new NoSuchElementException("List is empty");

        Node temp = tail;
        if(head == tail){
            head = null;
            tail = null;
            return temp.data;
        }

        tail = tail.previous;
        tail.next = null;
        temp.previous = null;   // dereferencing the node
        return temp.data;
    }

    // getFirst operation
    public int getFirst(){
        if(isEmpty()) throw new RuntimeException("deque is empty");
        return head.data;
    }

    // getLast operation
    public int getLast(){
        if(isEmpty()) throw new RuntimeException("deque is empty");
        return tail.data;
    }

    // isEmpty operation
    public boolean isEmpty(){
        return (head == null || tail == null);
    }

    // getSize operation
    public int getSize(){
        if(isEmpty()) return 0;

        int count = 0;
        Node current = head;
        while(current != tail){
            count++;
            current = current.next;
        }
        return count;
    }

    // display the elements in forward order
    public void printForward(){
        if(head == null){
            System.out.println("[]");
            return;
        }
        Node current = head;
        StringBuilder str = new StringBuilder();
        System.out.print("[");

        while(current != null){
            str.append(current.data);
            if(current.next != null){
                str.append(",");
            }
            current = current.next;
        }
        str.append("]");
        System.out.println(str);
    }

    // display elements in reverse order
    public void printReverse(){
        if(head == null){
            System.out.println("[]");
            return;
        }
        Node current = tail;
        StringBuilder str = new StringBuilder();
        str.append("[");

        while(current != null){
            str.append(current.data);

            if(current.previous != null){
                str.append(",");
            }
            current = current.previous;
        }
        str.append("]");
        System.out.println(str);
    }

    public static void main(String[] args) {
        DoubleLinkedList obj = new DoubleLinkedList();
        obj.addFirst(50);
//        obj.addFirst(40);
//        obj.addFirst(30);
//        obj.addFirst(20);
//        obj.addFirst(10);
//        obj.addLast(60);
//        obj.addLast(70);
        System.out.println(obj.removeFirst());
//        System.out.println(obj.removeLast());

        obj.printForward();
//        obj.printReverse();
//        System.out.println(obj.isEmpty());
//        System.out.println(obj.size());
    }
}
