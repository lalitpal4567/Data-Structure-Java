package stack.stackUsingArray;

import java.util.EmptyStackException;

public class Stack {
    int top;
    int[] arr;

    Stack(int size){
        top = -1;
        arr = new int[size];
    }

    // push element into the stack
    public void push(int data){
        if(size() == arr.length){
            System.out.println("overflow");
            return;
        }
        top++;
        arr[top] = data;
    }

    // removing element from the stack pop operation
    public int pop(){
        if(isEmpty()) throw new EmptyStackException();

        int result = arr[top];
        top--;
        return result;
    }

    // check whether a stack is empty or not
    public boolean isEmpty(){
        return top == -1;
    }

    // size of stack
    public int size(){
        return top + 1;
    }

    // peak operation
    public int peak(){
        if(isEmpty()) throw new EmptyStackException();

        return arr[top];
    }

    // peek
    public void peek(){
        if(isEmpty()){
            System.out.println("[]");
            return;
        }

        StringBuilder str = new StringBuilder();
        str.append("[");
        for(int index = top; index >= 0; index--){
            str.append(arr[index]);

            if(index != 0) str.append(", ");
        }
        str.append("]");
        System.out.println(str);
    }

    public static void main(String[] args) {
        Stack obj = new Stack(7);
        obj.push(10);
        obj.push(20);
        obj.push(30);
        obj.push(40);
        obj.push(50);
        obj.push(60);

        obj.peek();
        System.out.println(obj.size());

        obj.push(70);
        obj.peek();
        System.out.println(obj.size());

        obj.push(80);
        obj.pop();
        obj.peek();
    }
}
