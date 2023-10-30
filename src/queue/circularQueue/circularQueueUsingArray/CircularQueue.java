package queue.circularQueue.circularQueueUsingArray;

public class CircularQueue {
    int front;
    int rear;
    int[] queue;
    CircularQueue(int size){
        front = -1;
        rear = -1;
        queue = new int[size];
    }

    // enqueue operation
    public void enqueue(int data){
        if(isFull()){
            System.out.println("overflow");
            return;
        }
        if(isEmpty()){
            front = rear = 0;
            queue[rear] = data;
            return;
        }
        rear = (rear + 1) % getSize();
        queue[rear] = data;
    }

    // dequeue operation
    public int dequeue(){
        if(isEmpty()) throw new RuntimeException("underflow");

        int result = queue[front];
        if(front == rear){
            front = rear = -1;
            return result;
        }
        front = (front + 1) % getSize();
        return result;
    }

    // getFirst operation
    public int getFirst(){
        if (isEmpty()) throw new RuntimeException("queue is empty");
        return queue[front];
    }

    // getLast operation
    public int getLast(){
        if(isEmpty()) throw new RuntimeException("queue is empty");
        return queue[rear];
    }

    // isEmpty operation
    public boolean isEmpty(){
        return (front == -1 && rear == -1);
    }

    // isFull operation
    public boolean isFull(){
        return ((front == 0 && rear == getSize() - 1) || (front == rear + 1));
    }

    // getSize operation
    public int getSize(){
        return queue.length;
    }

    // display operation
    public void display(){
        if(isEmpty()){
            System.out.println("[]");
            return;
        }
        int temp = front;
        StringBuilder str = new StringBuilder();
        str.append("[");
        while(temp != rear){
            str.append(queue[temp]);
            str.append(", ");
            temp = (temp + 1) % getSize();
        }
        str.append(queue[temp]);
        str.append("]");
        System.out.println(str);
    }

    public static void main(String[] args) {
        CircularQueue obj = new CircularQueue(3);
        obj.enqueue(10);
        obj.enqueue(20);
        obj.enqueue(30);
//        obj.enqueue(40);
//        obj.dequeue();
//        obj.dequeue();
//        obj.dequeue();
//        obj.dequeue();
        System.out.println(obj.getFirst());
        System.out.println(obj.getLast());
        System.out.println(obj.isFull());
        System.out.println(obj.isEmpty());

        obj.display();

    }
}
