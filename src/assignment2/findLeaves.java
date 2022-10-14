package assignment2;

import java.util.ArrayList;
import java.util.List;

public class findLeaves {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.right = node4;

        findLeaves(root);
    }

    public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        traverse(result, root);

        return result;
    }

    private static int traverse(List<List<Integer>> list, TreeNode root) {
        if (root == null) {
            return -1;
        }

        int left = traverse(list, root.left);
        int right = traverse(list, root.right);
        int curr = Math.max(left, right) + 1;

        if (list.size() <= curr) {
            list.add(new ArrayList<Integer>());
        }

        list.get(curr).add(root.val);

        return curr;
    }

}
