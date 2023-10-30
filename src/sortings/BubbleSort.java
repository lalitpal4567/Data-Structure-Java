package sortings;

import java.util.Arrays;

public class BubbleSort {
    private static void swap(int[] arr, int smallIndex, int largeIndex){
        int temp = arr[smallIndex];
        arr[smallIndex] = arr[largeIndex];
        arr[largeIndex] = temp;
    }
    public static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{5,4,3,2,1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
