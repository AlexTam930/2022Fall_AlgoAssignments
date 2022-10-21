package assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum {

    public static void main(String[] args) {
        int[] test = {2, 3, 6, 7};
        List<List<Integer>> result = combinationSum(test, 7);

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


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);

        dfs(target, candidates[0], candidates, result, list, 0);

        return result;
    }

    private static void dfs(int diff, int curVal, int[] arrays,
                     List<List<Integer>> result, List<Integer> list, int index) {
        if(diff == 0) {
            result.add(new ArrayList<>(list));
            return;
        } else if(diff < curVal) {
            return;
        } else {
            for(int i = index; i < arrays.length; i++) {
                list.add(arrays[i]);
                dfs(diff - arrays[i], arrays[i], arrays, result, list, i);

                list.remove(list.size() - 1);
            }
        }
    }

}
