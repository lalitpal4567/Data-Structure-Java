package sortings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionSort {
    private static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    public static void insertionSort1(int[] arr){
        for(int i = 0; i < arr.length - 1 ; i++){
            for(int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
    public static void insertion_sort ( int A[ ])
    {
        for( int i = 0 ;i < A.length ; i++ ) {
    /*storing current element whose left side is checked for its
             correct position .*/

            int temp = A[ i ];
            int j = i;

       /* check whether the adjacent element in left side is greater or
            less than the current element. */

            while(  j > 0  && temp < A[ j -1]) {

                // moving the left side element to one position forward.
                A[ j ] = A[ j-1];
                j= j - 1;

            }
            // moving current element to its  correct position.
            A[ j ] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 1, 5};
        insertionSort1(arr);
//        insertion_sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
