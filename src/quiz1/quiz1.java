package quiz1;

import assignment2.TreeNode;

import java.util.*;

public class quiz1 {


    public static void main(String[] args) {


    }

    // Given an array, rotate the array to the right by k steps, where k is non-negative.
    public static void rotateArray(int[] array, int k) {
        int k1 = k % array.length;

        int[] result = new int[array.length];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = array.length - k1; i < array.length; i++) {
            list.add(array[i]);
        }
        for (int p = 0; p < array.length - k1; p++) {
            list.add(array[p]);
        }
        for (int j = 0; j < list.size(); j++) {
            result[j] = list.get(j);
        }
    }

    // Given the roots of two binary trees p and q, write a function to check if they are the same or not.
    public static boolean checkSameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return node1 == node2;
        }

        if (node1.val != node2.val) {
            return false;
        }

        return node1.val == node2.val && checkSameTree(node1.left, node2.left) && checkSameTree(node1.right, node2.right);
    }


    // Binary Tree Level order traversal
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> itemList = new LinkedList<>();

            for (int i = 0; i < levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                itemList.add(queue.poll().val);
            }
            result.add(itemList);
        }
        return result;
    }

}
