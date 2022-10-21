package assignment3;

import java.util.ArrayList;
import java.util.List;

public class subsets {

    public static void main(String[] args) {
        int[] test = {1, 2, 3};
        List<List<Integer>> result = subsets(test);

        printListInList(result);
    }

    private static void printListInList(List<List<Integer>> list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            printArray(list.get(i));
        }
        System.out.print("]");
    }

    private static void printArray(List<Integer> array) {
        System.out.print("[");
        for (int i : array) {
            System.out.print(i + ",");
        }
        System.out.print("]");
    }

    private static List<List<Integer>> resultList = new ArrayList<List<Integer>>();

    private static List<List<Integer>> subsets(int[] nums) {
        resultList.add(new ArrayList<Integer>());
        getList(resultList, nums, 0);
        return resultList;
    }

    private static void getList(List<List<Integer>> result, int[] nums, int count) {
        if(count == nums.length) {
            return;
        }

        List<Integer> nList = new ArrayList<Integer>();
        nList.add(nums[count]);
        result.add(nList);

        for (int p = count; p > 0; p--) {
            int end = nums[p-1];
            for (int i = result.size() - 1; i >= 0; i--) {
                List<Integer> item = result.get(i);
                if (item.size() > 0 && item != null) {
                    if (result.get(i).get(result.get(i).size() - 1) == end) {
                        List<Integer> newList = new ArrayList<Integer>();
                        newList.addAll(result.get(i));
                        newList.add(nums[count]);
                        result.add(newList);
                    }
                }

            }
        }
        count++;  // a factor to count at every time when a given Array is analysed from left to right.
        getList(result, nums, count);
    }

}
