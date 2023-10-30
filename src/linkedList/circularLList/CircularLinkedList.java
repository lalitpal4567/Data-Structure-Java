package linkedList.circularLList;

import java.util.NoSuchElementException;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}

public class CircularLinkedList {
    Node lastNode;

    // insert a node at the beginning
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(lastNode == null){
            lastNode = newNode;
            lastNode.next = lastNode;
            return;
        }

        newNode.next = lastNode.next;
        lastNode.next = newNode;
    }

    // insert a node at the end
    public void addLast(int data){
        Node newNode = new Node(data);

        if(lastNode == null){
            lastNode = newNode;
            newNode.next = lastNode;
            return;
        }

        newNode.next  = lastNode.next;
        lastNode.next = newNode;
        lastNode = newNode;
    }

    // remove a node from the beginning
    public int removeFirst(){
        if(lastNode == null){
            throw new NoSuchElementException("[]");
        }

        Node temp = lastNode.next;
        if(lastNode.next == lastNode){
            lastNode = null;
            return temp.data;
        }
        lastNode.next = temp.next;
        temp.next = null;
        return temp.data;
    }

    // remove a node from the end
    public int removeLast(){
        if(lastNode == null){
            throw new NoSuchElementException("[]");
        }
        Node temp = lastNode.next;
        if(lastNode.next == lastNode){
            lastNode = null;
            return temp.data;
        }
        while(temp.next != lastNode){
            temp = temp.next;
        }
        Node temp2 = lastNode;
        temp.next = lastNode.next;
        lastNode = temp;
        return temp2.data;
    }

    // display the whole list
    public void printList(){
        if(lastNode == null){
            System.out.println("[]");
            return;

        }
        Node firstNode = lastNode.next;
        while(firstNode != lastNode) {
            System.out.println(firstNode.data);
            firstNode = firstNode.next;
        }
        System.out.println(firstNode.data);
    }

    public static void main(String[] args) {
        CircularLinkedList obj = new CircularLinkedList();
//        obj.addLast(10);
//        obj.addLast(20);
//        obj.addLast(30);

        obj.addFirst(50);
        obj.addFirst(79);
        obj.addFirst(55);
        obj.addFirst(44);
        obj.addFirst(35);
//        System.out.println(obj.removeFirst().data);
//        obj.removeFirst();
        obj.removeLast();
        obj.printList();
    }
}
