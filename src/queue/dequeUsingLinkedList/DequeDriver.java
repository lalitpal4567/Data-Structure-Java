package queue.dequeUsingLinkedList;

class Node{
    Node previous;
    int data;
    Node next;
    Node(int data){
        previous = null;
        this.data = data;
        next = null;
    }
}
public class DequeDriver {
    Node front;
    Node rear;
    DequeDriver(){
        front = rear = null;
    }

    // addFirst operation
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            front = rear = newNode;
            return;
        }
        newNode.next = front;
        front.previous = newNode;
        front = newNode;
    }

    // addLast operation
    public void addLast(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            front = rear = newNode;
            return;
        }
        newNode.previous = rear;
        rear.next = newNode;
        rear = newNode;
    }

    // removeFirst operation
    public int removeFirst(){
        if(isEmpty()) throw new RuntimeException("underflow");

        int result = front.data;
        if(front == rear){
            front = rear = null;
            return result;
        }
        front = front.next;
        front.previous = null;
        return 0;
    }

    // removeLast operation
    public int removeLast(int data){
        if(isEmpty()) throw new RuntimeException("underflow");

        int result = rear.data;
        if(front == rear){
            front = rear = null;
            return result;
        }
        rear = rear.previous;
        rear.next = null;
        return result;
    }

    // getFirst operation
    public int getFirst(){
        if(isEmpty()) throw new RuntimeException("deque is empty");
        return front.data;
    }

    // getLast operation
    public int getLast(){
        if(isEmpty()) throw new RuntimeException("deque is empty");
        return rear.data;
    }

    // isEmpty operation
    public boolean isEmpty(){
        return (front == null || rear == null);
    }

    // getSize operation
    public int getSize(){
        if(isEmpty()) return 0;

        int count = 0;
        Node current = front;
        while(current != rear){
            count++;
            current = current.next;
        }
        return count;
    }

    // display operation
    public void display(){
        if(isEmpty()){
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

    // display elements in reverse order
    public void printReverse(){
        if(isEmpty()){
            System.out.println("[]");
            return;
        }
        Node current = rear;
        StringBuilder str = new StringBuilder();
        str.append("[");
        while(current != null){
            str.append(current.data);
            current = current.previous;

            if(current != null){
                str.append(",");
            }
        }
        str.append("]");
        System.out.println(str);
    }

    public static void main(String[] args) {
        DequeDriver obj = new DequeDriver();
        obj.addFirst(20);
        obj.addFirst(50);

        obj.display();
    }
}
