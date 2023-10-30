package queue.queueUsingLinkedList;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class Queue {
    Node front;
    Node rear;
    Queue(){
        front = null;
        rear = null;
    }

    // enqueue operation
    public void enqueue(int data){
        Node newNode = new Node(data);
        if(front == null){
            front = newNode;
            rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    // dequeue operation
    public int dequeue(){
        if(front == null) throw new RuntimeException("underflow");

        int result = front.data;
//        if(front == rear){
//            front = rear = null;
//        }else{
//            front = front.next;
//        }

        if(front == rear){
            front = rear = null;
            return result;
        }
        front = front.next;
        return result;
    }

    // isEmpty method
    public boolean isEmpty(){
        return front == null;
    }

    // size of queue
    public int size(){
        if(front == null) return 0;

        Node temp = front;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    // display operation
    public void display(){
        if(front == null){
            System.out.println("[]");
            return;
        }
        Node current = front;
        StringBuilder str = new StringBuilder();
        str.append("[");
        while(current != null){
            str.append(current.data);
            current = current.next;

            if(current != null){
                str.append(", ");
            }
        }
        str.append("]");
        System.out.println(str);
    }

    public static void main(String[] args) {
        Queue obj = new Queue();
        obj.enqueue(10);
        obj.enqueue(20);
        obj.enqueue(30);
        obj.display();

        obj.dequeue();
        System.out.println(obj.isEmpty());
        obj.dequeue();
        obj.display();
        System.out.println(obj.isEmpty());

        obj.dequeue();
        System.out.println(obj.isEmpty());
        obj.display();
        obj.enqueue(100);;
        obj.display();
    }
}
