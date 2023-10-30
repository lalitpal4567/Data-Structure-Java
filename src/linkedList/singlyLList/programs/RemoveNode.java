package linkedList.singlyLList.programs;

class Node7{
    int data;
    Node7 next;
    Node7(int data){
        this.data = data;
        next = null;
    }
}

public class RemoveNode {
    Node7 head;

    public void addFirst(int data) {
        Node7 newNode = new Node7(data);

        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Insert at the end of the list
    public void addLast(int data) {
        Node7 newNode = new Node7(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node7 current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // remove a node from the list
    public void removeNode(int key){
        if(head == null){
            return;
        }

        if(head.data == key){
            head = head.next;
            return;
        }

        Node7 current = head;
        Node7 temp = null;

        while(current != null && current.data != key){
            temp = current;
            current = current.next;
        }
        if(current == null) return;
        temp.next = current.next;
        current.next = null;
    }

    // displaying the list nodes
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node7 current = head;

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
        RemoveNode obj = new RemoveNode();
        obj.addFirst(21);
        obj.addFirst(25);
        obj.addFirst(15);
        obj.addLast(32);
        obj.addLast(15);
        obj.addLast(33);

        obj.printList();
        obj.removeNode(31);
        obj.printList();
    }
}
