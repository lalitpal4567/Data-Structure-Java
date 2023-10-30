package queue.queueUsingArray;

public class Queue {
    int front;
    int rear;
    int[] queue;
    Queue(int size){
        front = -1;
        rear = -1;
        queue = new int[size];
    }

    // insert element in the queue, enqueue operation
    public void enqueue(int data){
//        if(isFull()){
//            System.out.println("overflow");
//            return;
//        }

        if(rear == queue.length - 1){
            System.out.println("overflow");
            return;
        }
        if(rear == -1){
            rear = front = 0;
            queue[rear] = data;
        }else{
            queue[++rear] = data;
        }
    }

    // remove element from the queue (from front), dequeue operation
    public int dequeue(){
        if(front == -1) throw new RuntimeException("underflow");

        int result = queue[front];
        if(front == rear){
            front = rear = -1;
        } else front++;
        return result;
    }

    // check whether a queue is empty or not
    public boolean isEmpty(){
        return front == -1;
    }

    // isFull
    public boolean isFull(){
        return rear == queue.length -1;
    }

    // display queue elements
    public void display(){
        if(front == -1){
            System.out.println("[]");
            return;
        }
        StringBuilder str = new StringBuilder();
        str.append("[");
        int temp = front;
        while(temp <= rear){
            str.append(queue[temp]);
            if(temp != rear) str.append(", ");
            temp++;
        }
        str.append("]");
        System.out.println(str);
    }

    public static void main(String[] args) {
        Queue obj = new Queue(7);
        obj.enqueue(10);
        obj.enqueue(20);
        obj.enqueue(30);
        obj.enqueue(40);
        obj.enqueue(60);
        obj.enqueue(70);
        obj.enqueue(80);
        obj.enqueue(90);

        obj.display();
        obj.dequeue();
        obj.dequeue();
        obj.dequeue();
        obj.dequeue();
        obj.dequeue();
        obj.dequeue();
        obj.dequeue();
        obj.display();
    }
}
