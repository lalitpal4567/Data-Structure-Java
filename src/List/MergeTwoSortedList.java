package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedList {
    public static ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2){
        ArrayList<Integer> list3 = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i < list1.size() && j < list2.size()){
            if(list1.get(i) <= list2.get(j))
                list3.add(list1.get(i++));
            else
                list3.add(list2.get(j++));
        }
        while(i < list1.size()) list3.add(list1.get(i++));
        while(j < list2.size()) list3.add(list2.get(j++));
        return list3;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 7, 9, 11, 13));
        List<Integer> list3 = merge(list1, list2);
        System.out.println(list3);
    }
}
