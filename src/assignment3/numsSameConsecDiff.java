package assignment3;

import java.util.ArrayList;
import java.util.List;

public class numsSameConsecDiff {

    public static void main(String[] args) {
        int[] result = numsSameConsecDiff(3, 7);
        printArray(result);
    }

    private static void printArray(int[] array) {
        System.out.print("[");
        for (int i : array) {
            System.out.print(i + ",");
        }
        System.out.print("]");
    }

    private static int[] numsSameConsecDiff(int n, int k) {
        List<Integer> resList = new ArrayList<>();

        for(int i = 0 ; i<= 9 ;i++) {
            dfs(1,n,i,k,resList);
        }

        int [] resArr = new int[resList.size()];

        int i = 0 ;
        for(int val:resList){
            resArr[i++] = val;
        }

        return resArr;
    }

    private static void dfs(int n, int N, int cur , int k , List<Integer> resList){
        if(n == N){
            resList.add(cur);
            return;
        }

        if(n>0 && cur == 0){
            return;
        }

        int p1 = cur % 10 + k;
        int p2 = cur % 10 - k;

        if(p1!=p2){
            if (p1 >= 0 && p1 <= 9) {
                dfs(n + 1, N, cur * 10 + p1, k, resList);
            }
        }

        if (p2 >= 0 && p2 <= 9) {
            dfs(n + 1, N, cur * 10 + p2, k, resList);
        }
    }

}
