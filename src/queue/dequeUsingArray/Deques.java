package queue.dequeUsingArray;

import java.util.ArrayDeque;

public class Deques {
    int front;
    int rear;
    int[] deque;
    Deques(int size){
        this.front = -1;
        this.rear = -1;
        deque = new int[size];
    }

    // addFirst operation
    public void addFirst(int data){
        if((front == 0 && rear == size() - 1) || (front == rear + 1)) {
            System.out.println("overflow");
        }else if(front == -1 && rear == -1){
            front = rear = 0;
            deque[front] = data;
        }else if(front == 0){
            front = size() - 1;
            deque[front] = data;
        }else{
            deque[--front] = data;
        }
    }

    // addLast operation
    public void addLast(int data){
        if((front == 0 && rear == size() - 1) || (front == rear + 1)){
            System.out.println("overflow");
        }else if(front == -1 && rear == -1){
            front = rear = 0;
            deque[rear] = data;
        }else if(rear == size() - 1){
            rear = 0;
            deque[rear] = data;
        }else{
            deque[++rear] = data;
        }
    }

    // removeFirst operation
    public void removeFirst(){
        if(front == -1 && rear == -1){
            System.out.println("underflow");
        }else if(front == rear){
            front = rear = -1;
        }else if(front == size() - 1){
            front = 0;
        }else{
            front++;
        }
    }

    // removeLast operation
    public void removeLast(){
        if(front == -1 && rear == -1){
            System.out.println("underflow");
        }else if(front == rear){
            front = rear = -1;
        }else if(rear == 0){
            rear = size() - 1;
        }else{
            rear--;
        }
    }

    // getFirst operation
    public int getFirst(){
        if(isEmpty()) throw new RuntimeException("deque is empty");
        return deque[front];
    }

    // getLast operation
    public int getLast(){
        if(front == -1 && rear == -1) throw new RuntimeException("deque is empty");
        return deque[rear];
    }

    // size of deque
    public int size(){
        return deque.length;
    }

    // isFull operation
    public boolean isFull(){
        return ((front == 0 && rear == size() - 1) || (front == rear + 1));
    }

    // isEmpty operation
    public boolean isEmpty(){
        return rear == -1 && front == -1;
    }

    // display deque elements
//    public void display(){
//        if(front == -1 && rear == -1){
//            System.out.println("[]");
//            return;
//        }
//        int temp = front;
//        while(temp != rear){
//            System.out.println(deque[temp]);
//            temp = (temp + 1) % size();
//        }
//        System.out.println(deque[temp]);
//    }

    // display deque elements
    public void display(){
        if(front == -1 && rear == -1){
            System.out.println("[]");
            return;
        }
        int temp = front;
        StringBuilder str = new StringBuilder();
        str.append("[");
        while(temp != rear){
            str.append(deque[temp]);
            temp = (temp + 1) % deque.length;
            str.append(", ");
        }
        str.append(deque[temp]);
        str.append("]");
        System.out.println(str);
    }

    public static void main(String[] args) {
        Deques obj = new Deques(5);
        obj.addFirst(10);
        obj.addFirst(20);
//        obj.addFirst(30);
//        obj.addFirst(40);
//        obj.addFirst(50);
//        obj.addFirst(60);
        obj.addLast(100);
        obj.addLast(200);

//        obj.removeFirst();
//        obj.removeFirst();
//        obj.removeFirst();
//        obj.removeFirst();
//        obj.removeFirst();

//        obj.addFirst(100);
//        obj.addFirst(200);
        System.out.println(obj.front + " " + obj.rear);
        obj.display();

        ArrayDeque<Integer> obj2 = new ArrayDeque<>();
    }
}

