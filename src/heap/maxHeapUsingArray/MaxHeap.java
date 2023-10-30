package heap.maxHeapUsingArray;

import java.util.Arrays;

public class MaxHeap {
    static int[] heap;
    int heapSize;
    MaxHeap(int size){
        heap = new int[size];
        heapSize = 0;
    }

    // insert operation
    public void insert(int data){
        heapSize++;
        int index = heapSize;
        heap[index] = data;

        while(index > 1){
            int parent = index / 2;
            if(heap[index] > heap[parent]) {
                swap(index, parent);
                index = parent;
            }
            else break;
        }
    }

    // swap function
    private static void swap(int child, int parent){
        int temp = heap[child];
        heap[child] = heap[parent];
        heap[parent] = temp;
    }

    // delete function
    public void delete(){
        if(heapSize == 0){
            System.out.println("underflow");
            return;
        }
        heap[1] = heap[heapSize];
        heap[heapSize] = 0;
        heapSize--;

        int i = 1;
        while(i < heapSize){
            int leftChild = 2 * i;
            int rightChild = 2 * i + 1;

            if(heap[leftChild] > heap[rightChild]){
                swap(i, leftChild);
                i = leftChild;
            }
            else if(heap[leftChild] < heap[rightChild]){
                swap(i, rightChild);
                i = rightChild;
            }
            else{
                break;
            }
        }
    }
    // print operation
    public void display(){
        for(int index = 1; index <= heapSize; index++){
            System.out.print(heap[index] + "\t");
        }
    }

    public static void main(String[] args) {
        MaxHeap obj = new MaxHeap(100);
        obj.insert(50);
        obj.insert(40);
        obj.insert(55);
        obj.insert(30);
        obj.insert(70);
        obj.insert(35);
        obj.insert(40);
        obj.insert(39);
        obj.insert(80);

        obj.delete();
        obj.delete();

        obj.display();
    }

}
