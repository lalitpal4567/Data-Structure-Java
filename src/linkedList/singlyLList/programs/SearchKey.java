package linkedList.singlyLList.programs;

import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class SearchKey {
    Node head;

    // insert node at the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);

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

    public boolean search(int key){
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

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        SearchKey obj = new SearchKey();
        obj.addFirst(30);
        obj.addFirst(20);
        obj.addFirst(10);
        obj.addLast(50);
        obj.addLast(60);

        System.out.print("Enter the key to be searched: ");
        int key = input.nextInt();

        if(obj.search(key)){
            System.out.println("key found");
        }
        else{
            System.out.println("not found");
        }
    }
}
