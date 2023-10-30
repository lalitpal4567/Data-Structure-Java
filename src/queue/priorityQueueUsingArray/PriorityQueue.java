package queue.priorityQueueUsingArray;

// Using ordered array (ascending or descending)
public class PriorityQueue {
    int[] queue;
    int front;
    int rear;

    PriorityQueue(int size){
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    public void enqueue(int data){
        if(isFull()) {
            System.out.println("overflow");
            return;
        }
        if(front == -1 && rear == -1){
            front = rear = 0;
            queue[front] = data;
            return;
        }

//        if(queue[rear] < data){
//            queue[++rear] = data;
//            return;
//        }

        int i = rear;
        while( i >= 0 && data < queue[i]){
            queue[i + 1] = queue[i];
            i--;
        }
        queue[i + 1] = data;
        rear++;
    }

    // dequeue operation
    public void dequeue(){
        if(isEmpty()){
            System.out.println("underflow");
            return;
        }
        if(front == rear){
            front = rear = -1;
            return;
        }
        front++;
    }

    // isEmpty operation
    public boolean isEmpty(){
        return front == -1 && rear == -1;
    }

    // isFull operation
    public boolean isFull(){
        return rear == queue.length - 1 ;
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
        PriorityQueue queue = new PriorityQueue(5);
        queue.enqueue(4);
        queue.enqueue(6);
        queue.enqueue(2);

        queue.display();
    }
}
