package linkedList.singlyLList.programs;

class Node1{
    int data;
    Node1 next;

    Node1(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseList {
    Node1 head;

    // insert node at the beginning of the list
    public void addFirst(int data) {
        Node1 newNode = new Node1(data);

        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Insert at the end of the list
    public void addLast(int data) {
        Node1 newNode = new Node1(data);

        if (head == null) {
            head = newNode;
            return;
        }
        Node1 current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void reverse(){
        Node1 current = head;
        Node1 next = null;
        Node1 previous = null;

        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node1 current = head;

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
        ReverseList obj = new ReverseList();

        obj.addLast(40);
        obj.addLast(50);
        obj.addLast(60);
        obj.addFirst(30);
        obj.addFirst(20);

        obj.printList();
        obj.reverse();
        obj.printList();
    }
}
