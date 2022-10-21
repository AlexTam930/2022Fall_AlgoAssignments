package assignment3;

import java.util.ArrayList;
import java.util.List;

public class permute {
    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5};
        List<List<Integer>> result = permute(test);

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

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();

        getPermutations(result, list, nums);
        return result;
    }

    private static void getPermutations(List<List<Integer>> result, List<Integer> list, int[] nums) {
        if(list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])) continue;

            list.add(nums[i]);
            getPermutations(result, list, nums);
            list.remove(list.size() - 1);
        }
    }

}
