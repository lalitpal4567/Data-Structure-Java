package queue.dequeUsingArray;

public class Deque {
    int front;
    int rear;
    int[] deque;
    Deque(int size){
        front = -1;
        rear = -1;
        deque = new int[size];
    }

    // addFirst operation
    public void addFirst(int data){
        if(isFull()){
            System.out.println("overflow");
            return;
        }
        if(isEmpty()){
            front = rear = 0;
            deque[front] = data;
            return;
        }
        if(front == 0){
            front = size() - 1;
            deque[front] = data;
            return;
        }
        deque[--front] = data;
    }

    // addLast operation
    public void addLast(int data){
        if(isFull()){
            System.out.println("overflow");
            return;
        }
        if(isEmpty()){
            front = rear = 0;
            deque[rear] = data;
            return;
        }
        if(rear == size() - 1){
            rear = 0;
            deque[rear] = data;
            return;
        }
        deque[++rear] = data;
    }

    // removeFirst operation
    public int removeFirst(){
        if(isEmpty()) throw new RuntimeException("underflow");

        int result = deque[front];
        if(front == rear){
            front = rear = -1;
            return result;
        }
        if(front == size() - 1){
            front = 0;
            return result;
        }
        front++;
        return result;
    }

    // removeLast operation
    public int removeLast(){
        if(isEmpty()) throw new RuntimeException("underflow");

        int result = deque[rear];
        if(front == rear){
            front = rear = -1;
            return result;
        }
        if(rear == 0){
            rear = size() - 1;
            return result;
        }
        rear--;
        return result;
    }

    // getFirst operation
    public int getFirst(){
        if(isEmpty()) throw new RuntimeException("deque is empty");
        return deque[front];
    }

    // getLast operation
    public int getLast(){
        if(isEmpty()) throw new RuntimeException("deque is empty");
        return deque[rear];
    }

    // isEmpty operation
    public boolean isEmpty(){
        return (front == -1 && rear == -1);
    }

    // isFull operation
    public boolean isFull(){
        return (front == 0 && rear == size() - 1) || (front == rear + 1);
    }

    // size operation
    public int size(){
        return deque.length;
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
        while(temp <= rear){
            str.append(deque[temp]);
            temp = (temp + 1) % size();

            if(temp != rear) str.append(", ");
        }
        str.append(deque[temp]).append("]");
        System.out.println(str);
    }

    public static void main(String[] args) {
        Deque obj = new Deque(5);
    }
}
