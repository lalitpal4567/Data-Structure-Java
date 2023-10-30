package linkedList.singlyLList.programs;

class Node2{
    int data;
    Node2 next;
    Node2(int data){
        this.data = data;
        this.next = null;
    }
}

public class MiddleNode {
    Node2 head;

    // insert node at the beginning of the list
    public void addFirst(int data) {
        Node2 newNode = new Node2(data);

        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Insert at the end of the list
    public void addLast(int data) {
        Node2 newNode = new Node2(data);

        if (head == null) {
            head = newNode;
            return;
        }
        Node2 current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // find the middle node of the list
    public Node2 middleNode(){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }

        Node2 slowPtr = head;
        Node2 fastPtr = head;

        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        slowPtr.next = null;    // dereferencing
        return slowPtr;
    }
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node2 current = head;

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

    public static void main(String[] args) {
        MiddleNode obj = new MiddleNode();
        obj.addFirst(100);
        obj.addFirst(200);
        obj.addFirst(300);
        obj.addLast(400);
        obj.addLast(500);

        obj.printList();
        Node2 middleNode = obj.middleNode();
        System.out.println(middleNode.data);
    }

}
