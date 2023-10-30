package linkedList.singlyLList.programs;


class Node5{
    int data;
    Node5 next;

    Node5(int data){
        this.data = data;
        next = null;
    }
}
public class RemoveDuplicateFromSortedList {
    Node5 head;

    // insert node at the beginning of the list
    public void addFirst(int data) {
        Node5 newNode = new Node5(data);

        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Insert at the end of the list
    public void addLast(int data) {
        Node5 newNode = new Node5(data);

        if (head == null) {
            head = newNode;
            return;
        }
        Node5 current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // remove duplicate from sorted list
    public void removeDuplicate(){
        if(head == null || head.next == null){
            return;
        }

        Node5 current = head;
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

        Node5 current = head;

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
        RemoveDuplicateFromSortedList obj = new RemoveDuplicateFromSortedList();
        obj.addLast(100);
        obj.addLast(200);
        obj.addLast(200);
        obj.addLast(800);
        obj.addLast(900);
        obj.addLast(900);
        obj.addLast(1000);

        System.out.println("before removing duplicates");
        obj.printList();
        System.out.println("after removing duplicates");
        obj.removeDuplicate();
        obj.printList();

    }

}
