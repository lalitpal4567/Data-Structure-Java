package linkedList.singlyLList.programs;

// using length
class Node3{
    int data;
    Node3 next;
    Node3(int data){
        this.data = data;
        next = null;
    }
}

public class NthNodeFromEnd {
    Node3 head;

    public void addFirst(int data) {
        Node3 newNode = new Node3(data);

        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Insert at the end of the list
    public void addLast(int data) {
        Node3 newNode = new Node3(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node3 current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // return Nth node from the end using length
    public Node3 nthNodeFromEnd(int nthNodeFromEnd){
        Node3 current = head;
        int length  = getLength();

        int nthNodeFromBeg = length - nthNodeFromEnd;
        int count = 0;
        Node3 temp = head;

        while(count < nthNodeFromBeg){
            temp = temp.next;
            count++;
        }
        return temp;
    }

    // length of list
    private int getLength(){
        Node3 current = head;
        int length = 0;

        while(current != null){
            current = current.next;
            length++;
        }
        return length;
    }

    // displaying the list nodes
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node3 current = head;

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
        NthNodeFromEnd obj = new NthNodeFromEnd();
        obj.addFirst(100);
        obj.addFirst(200);
        obj.addFirst(500);
        obj.addLast(600);
        obj.addLast(700);
        obj.addLast(900);

        obj.printList();
        Node3 nthNode = obj.nthNodeFromEnd(2);
        System.out.println(nthNode.data);
    }
}
