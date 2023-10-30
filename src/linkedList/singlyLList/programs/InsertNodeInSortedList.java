package linkedList.singlyLList.programs;

class Node6{
    int data;
    Node6 next;
    Node6(int data){
        this.data = data;
        this.next = null;
    }
}

public class InsertNodeInSortedList {
    Node6 head;

    // insert node at the beginning of the list
    public void addFirst(int data) {
        Node6 newNode = new Node6(data);

        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Insert at the end of the list
    public void addLast(int data) {
        Node6 newNode = new Node6(data);

        if (head == null) {
            head = newNode;
            return;
        }
        Node6 current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // insert a node in sorted list
    public void insertNodeInList(int data){
        Node6 newNode = new Node6(data);

        if(head == null){
            head = newNode;
            return;
        }
        Node6 current = head;
        Node6 temp = null;

        while(current != null && current.data < newNode.data){
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        if (temp != null) {         // throws NullPointerException
            temp.next = newNode;
        }
    }

    // displaying the list nodes
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node6 current = head;

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

    public void method(Node6 temp){
        if(temp == null){
            return;
        }
        method(temp.next);
        System.out.println(temp.data);
    }

    public static void main(String[] args) {
        InsertNodeInSortedList obj = new InsertNodeInSortedList();
        obj.addLast(2);
        obj.addLast(3);
        obj.addLast(4);
        obj.addLast(6);
        obj.addLast(7);
        obj.addLast(9);

        obj.printList();
//        obj.insertNodeInList(5);
//        obj.printList();
        obj.method(obj.head);
    }
}
