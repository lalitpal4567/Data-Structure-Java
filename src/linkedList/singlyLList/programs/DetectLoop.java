package linkedList.singlyLList.programs;

class Node8{
    int data;
    Node8 next;

    Node8(int data){
        this.data = data;
        next = null;
    }
}

public class DetectLoop {
    Node8 head;
    public void createLoop(){
        Node8 node1 = new Node8(10);
        Node8 node2 = new Node8(20);
        Node8 node3 = new Node8(30);
        Node8 node4 = new Node8(40);
        Node8 node5 = new Node8(50);
        Node8 node6 = new Node8(60);

        head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node4;
    }

    public boolean detectLoop(){
        if(head == null){
            return false;
        }

        Node8 slowPtr = head;
        Node8 fastPtr = head;

        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if(slowPtr == fastPtr){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectLoop obj = new DetectLoop();
        obj.createLoop();
        boolean isLoopDetected = obj.detectLoop();
        System.out.println(isLoopDetected);
    }
}
