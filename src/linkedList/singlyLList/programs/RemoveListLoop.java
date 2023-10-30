package linkedList.singlyLList.programs;
class Node10{
    int data;
    Node10 next;
    Node10(int data){
        this.data = data;
        next = null;
    }
}

public class RemoveListLoop {
    Node10 head;

    public void createLoop(){
        Node10 newNode1 = new Node10(10);
        Node10 newNode2 = new Node10(20);
        Node10 newNode3 = new Node10(30);
        Node10 newNode4 = new Node10(40);
        Node10 newNode5 = new Node10(50);
        Node10 newNode6 = new Node10(60);

        head = newNode1;
        newNode1.next = newNode2;
        newNode2.next = newNode3;
        newNode3.next = newNode4;
        newNode4.next = newNode5;
        newNode5.next = newNode6;
        newNode6.next = newNode4;
    }
    public void removeLoop(){
        if(head == null){
            return;
        }

        Node10 slowPtr = head;
        Node10 fastPtr = head;

        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if(slowPtr == fastPtr){
                getStartingNode(slowPtr);
            }
        }
    }

    // starting node of the loop
    private void getStartingNode(Node10 slowPtr){
        Node10 temp = head;

        while(slowPtr.next != temp.next){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = null;
    }

    // displaying the list nodes
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node10 current = head;

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
        RemoveListLoop obj = new RemoveListLoop();
        obj.createLoop();
        obj.removeLoop();
        obj.printList();
    }
}

