package queue.priorityQueueUsingLinkedList.orderedLinkedList;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class PriorityQueue {
    Node front;
    Node rear;
    PriorityQueue(){
        front = null;
        rear = null;
    }

    // enqueue operation
    public void enqueue(int data){
        Node newNode = new Node(data);
        if(front == null && rear == null){
            front = newNode;
            rear = newNode;
            return;
        }
        if(newNode.data < front.data){
            newNode.next = front;
            front = newNode;
            return;
        }
        Node temp = front;
        while(temp != rear){
            if(newNode.data > temp.data){
                Node temp2 = temp.next;
                newNode.next = temp;


            }
                temp = temp.next;
        }
    }
    public static void main(String[] args) {

    }
}
