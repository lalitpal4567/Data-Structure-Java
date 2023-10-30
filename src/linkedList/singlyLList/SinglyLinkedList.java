package linkedList.singlyLList;

import java.util.Scanner;

// Node
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    Node head;
    int length;

    SinglyLinkedList() {
        head = null;
        length = 0;
    }


    // Insert at the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        length++;

        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Insert at the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data);
        length++;

        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Insert at the specified position of the list
    public void insertAtPos(int data, int position) {
        if (position >= 0 && position < length + 1) {
            Node newNode = new Node(data);
            length++;

            if (position == 0) {
                newNode.next = head;
                head = newNode;
                return;
            }

            Node current = head;
            for (int index = 0; index < position - 1; index++) {
                current = current.next;
            }

//            int count = 0;
//            while(count < position - 1){
//                count++;
//                current = current.next;
//            }

            newNode.next = current.next;
            current.next = newNode;
        }
        else {
            System.out.println("Invalid position.");
        }
    }

    // delete from the beginning of the list
    public void deleteFirst()
    {
        if(head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
    }

//    public Node delFromBeg(){
//        if(head == null){
//            return null;
//        }
//        Node temp = head;
//        head = head.next;
//        temp.next = null;
//        return temp;
//    }


    // delete from the end of the list
    public void deleteLast()
    {
        if(head == null)
        {
            System.out.println("List is emtpy.");
            return;
        }

        // if only one node exists
        if(head.next  == null)
        {
            head = null;
            return;
        }

        Node previous = head;
        Node current = head.next;
        while(current.next != null)
        {
            current = current.next;
            previous = previous.next;
        }
        previous.next  = null;
    }

    // deletion from a specified location
    public void delFromPosition(int position){

    }
    // length of list
    public int getLength(){
        if(head == null){
            return 0;
        }

        int count = 0;
        Node current = head;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    // find the middle node of the list
    public Node middleNode(){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }

        Node slowPtr = head;
        Node fastPtr = head;

        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        slowPtr.next = null;    // dereferencing
        return slowPtr;
    }

    // reversing the list
    public void reverse(){
        Node current = head;
        Node next = null;
        Node previous = null;

        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    // search the key
    public boolean searchKey(int key){
        if(head == null){
            return false;
        }

        Node current = head;
        while(current != null){
            if(current.data == key){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // nth node from the end
    public Node getNthNodeFromEnd(int nthNodePositionFromEnd){
        if(head == null){
            return null;
        }
        if(nthNodePositionFromEnd > getLength() || nthNodePositionFromEnd <= 0){
            throw new IllegalArgumentException("invalid value: " + nthNodePositionFromEnd);
        }

        Node mainPtr = head;
        Node refPtr = head;

        int count = 0;
        while(count < nthNodePositionFromEnd){
            refPtr = refPtr.next;
            count++;
        }

        while(refPtr != null){
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        mainPtr.next = null;        // throws NullPointerException when n > length
        return mainPtr;
    }

    // return Nth node from the end using length
//    public Node getNthNodeFromEnd(int nthNodeFromEnd){
//        Node current = head;
//        int length  = getLength();
//
//        int nthNodeFromBeg = length - nthNodeFromEnd;
//        int count = 0;
//        Node temp = head;
//
//        while(count < nthNodeFromBeg){
//            temp = temp.next;
//            count++;
//        }
//        return temp;
//    }

    // remove duplicate from sorted list
    public void removeDuplicate(){
        if(head == null || head.next == null){
            return;
        }

        Node current = head;
        while(current != null && current.next != null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            }
            else{
                current = current.next;
            }
        }
    }

    // displaying the list nodes
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;

        StringBuilder str = new StringBuilder();
        str.append("[");
        while (current != null) {
            str.append(current.data);
            current = current.next;

            if (current != null) {
                str.append(", ");
            }
        }
        str.append("]");
        System.out.println(str);
    }

    // displaying the elements of list
//    public void printList(){
//        if (head == null) {
//            System.out.println("List is empty");
//            return;
//        }
//
//        Node current = head;
//        while(current != null){
//            System.out.print(current.data + " ");
//            current = current.next;
//        }
//    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SinglyLinkedList obj = new SinglyLinkedList();
        int choice;
        int value;
        int position;

        do {
            System.out.println("\nPress 1 to insert at beginning");
            System.out.println("Press 2 to insert at the end");
            System.out.println("Press 3 to insert at the specific position");
            System.out.println("Press 4 to delete from beginning");
            System.out.println("Press 5 to delete from the end");
            System.out.println("Press 6 to delete from the specified position");
            System.out.println("Press 7 to find the length of list");
            System.out.println("Press 8 to find the key");
            System.out.println("Press 9 to reverse the list");
            System.out.println("Press 10 to find the middle node");
            System.out.println("Press 11 to find nth node from end");
            System.out.println("Press 12 to remove duplicate elements");
            System.out.println("Press 13 to print list");
            System.out.println("Press 0 to exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the value to be inserted: ");
                    value = input.nextInt();
                    obj.addFirst(value);
                    obj.printList();
                }
                case 2 -> {
                    System.out.print("Enter the value to be inserted: ");
                    value = input.nextInt();
                    obj.addLast(value);
                    obj.printList();
                }
                case 3 -> {
                    System.out.print("Enter the value to be inserted: ");
                    value = input.nextInt();
                    System.out.print("Enter the position of the value: ");
                    position = input.nextInt();
                    obj.insertAtPos(value, position);
                    obj.printList();
                }
                case 4 -> obj.deleteFirst();
                case 5 -> obj.deleteLast();
                case 6 -> {
                    System.out.print("Enter the position of the value: ");
                    position = input.nextInt();
//                    obj.delFromPosition(position);
                }
                case 7 -> System.out.println("Length: " + obj.getLength());
                case 8 -> {
                    System.out.print("Enter the key to be searched: ");
                    System.out.println(obj.searchKey(input.nextInt()));
                }
                case 9 -> obj.reverse();
                case 10 -> System.out.println(obj.middleNode().data);
                case 11 -> {
                    System.out.print("Enter the nth from the end: ");
                    position = input.nextInt();
                    Node newNode = obj.getNthNodeFromEnd(position);
                    System.out.println(newNode.data);
                }
                case 12 -> obj.removeDuplicate();
                case 13 -> obj.printList();
                case 0 -> {
                    System.out.println("Program exited");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option");
            }
        } while (true);
    }
}
