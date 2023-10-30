package sortings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionHackerrank {
    public static void show(List<Integer> arr){
        for(Integer value : arr){
            System.out.print(value + " ");
        }
        System.out.println();
    }
    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        int temp = arr.get(n - 1);
        int i = 0;
        for(i = n - 2; i >= 0; i--){
            if(arr.get(i) > temp) {
                arr.set(i+1,arr.get(i));
            }else{
                System.out.println("hi");
                arr.set(i + 1,temp);
                break;
            }
            show(arr);
        }
        arr.set(i + 1,temp);
        show(arr);
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2,3,4,5,6,7,8,9,10,1));
        System.out.println(list);
        insertionSort1(10, list);
        System.out.println(list);
    }
}
