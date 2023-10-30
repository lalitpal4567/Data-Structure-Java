package linkedList.singlyLList.programs;

class Node4{
    int data;
    Node4 next;

    Node4(int data){
        this.data = data;
        next = null;
    }
}
public class NthNodeFromEnd2 {
    Node4 head;

    // insert node at the beginning of the list
    public void addFirst(int data) {
        Node4 newNode = new Node4(data);

        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Insert at the end of the list
    public void addLast(int data) {
        Node4 newNode = new Node4(data);

        if (head == null) {
            head = newNode;
            return;
        }
        Node4 current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // nth node from the end
    public Node4 getNthNodeFromEnd(int nthNodePositionFromEnd){
        if(head == null){
            return null;
        }
        if(nthNodePositionFromEnd > getLength() || nthNodePositionFromEnd <= 0){
            throw new IllegalArgumentException("invalid value: " + nthNodePositionFromEnd);
        }

        Node4 mainPtr = head;
        Node4 refPtr = head;

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

    // length of list
    private int getLength(){
        Node4 current = head;
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

        Node4 current = head;

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

    public static void main(String[] args){
        NthNodeFromEnd2 obj = new NthNodeFromEnd2();
        obj.addFirst(400);
        obj.addFirst(300);
        obj.addFirst(200);
        obj.addFirst(100);
        obj.addLast(600);

        obj.printList();
        Node4 node = obj.getNthNodeFromEnd(6);
        System.out.println(node.data);
    }
}
