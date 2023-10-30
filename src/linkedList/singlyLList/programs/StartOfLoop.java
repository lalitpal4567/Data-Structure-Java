package linkedList.singlyLList.programs;

class Node9{
    int data;
    Node9 next;
    Node9(int data){
        this.data = data;
        next = null;
    }
}

public class StartOfLoop {
    Node9 head;

    public void createLoop(){
        Node9 newNode1 = new Node9(10);
        Node9 newNode2 = new Node9(20);
        Node9 newNode3 = new Node9(30);
        Node9 newNode4 = new Node9(40);
        Node9 newNode5 = new Node9(50);
        Node9 newNode6 = new Node9(60);

        head = newNode1;
        newNode1.next = newNode2;
        newNode2.next = newNode3;
        newNode3.next = newNode4;
        newNode4.next = newNode5;
        newNode5.next = newNode6;
        newNode6.next = newNode4;
    }
    public Node9 detectLoop(){
        if(head == null){
            return null;
        }

        Node9 slowPtr = head;
        Node9 fastPtr = head;

        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if(slowPtr == fastPtr){
                return getStartingNode(slowPtr);
            }
        }
        return null;
    }

    // starting node of the loop
    private Node9 getStartingNode(Node9 slowPtr){
        Node9 temp = head;

        while(slowPtr != temp){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        temp.next = null;
        return temp;
    }

    // displaying the list nodes
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node9 current = head;

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
        StartOfLoop obj = new StartOfLoop();
        obj.createLoop();
        Node9 startingNode = obj.detectLoop();
        System.out.println(startingNode.data);
        obj.printList();
    }
}
