package stack.stackUsingLinkedList;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        next = null;
    }
}
public class StackUsingList {
    Node top;
    int length;
    StackUsingList(){
        top = null;
        length = 0;
    }

    // push a node in the stack
    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        length++;
    }
    public int pop(){
        if(top == null){
            throw new EmptyStackException();
        }
//        or
//        if(isEmpty()) throw new EmptyStackException();

        Node temp = top;
        top = top.next;
        temp.next = null;   // optional, garbage collected
        length--;
        return temp.data;
    }

    // peak operation, top of the stack
    public int peak(){
        if(top == null) throw new EmptyStackException();

        return top.data;
    }

    // size of the stack
    public int size(){
        return length;
    }

    // stack is empty or not
    public boolean isEmpty(){
        return length == 0;
    }

    // display stack elements
    public void peek(){
        if(isEmpty()){
            System.out.println("[]");
            return;
        }

        Node current = top;
        StringBuilder str = new StringBuilder();
        str.append("[");
        while(current != null){
            str.append(current.data);
            if(current.next != null) str.append(", ");
            current = current.next;
        }
        str.append("]");
        System.out.println(str);
    }

    public static void main(String[] args) {
        StackUsingList obj = new StackUsingList();
        obj.push(10);
        obj.push(20);
        obj.push(30);
        obj.push(40);
        obj.push(50);

        obj.peek();
        System.out.println(obj.peak());
    }
}
