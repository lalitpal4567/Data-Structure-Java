package sortings;

import java.util.Arrays;

public class MergeSort {
    public static int[] merge(int[] arr1, int[] arr2){
        int[] arr3 = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < arr1.length && j < arr2.length){
            if(arr1[i] <= arr2[j]) arr3[k++] = arr1[i++];
            else arr3[k++] = arr2[j++];
        }

        while(i < arr1.length) arr3[k++] = arr1[i++];
        while(j < arr2.length) arr3[k++] = arr2[j++];
        return arr3;
    }
    public static int[] mergeSort(int[] arr){
        if(arr.length == 1) return arr;
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        arr = mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
