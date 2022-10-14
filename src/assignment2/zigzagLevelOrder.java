package assignment2;

import java.util.ArrayList;
import java.util.List;

public class zigzagLevelOrder {

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

        zigzagLevelOrder(root);
    }

    private static List<List<Integer>> result;
    private static int depth = 0;

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        result = new ArrayList<List<Integer>>();

        if(root == null) return result;

        traverseTree(root, 0);

        return result;
    }

    private static void traverseTree(TreeNode node, int dp) {
        if(node == null) return;

        dp++;
        List<Integer> list;
        if(depth < dp) {
            depth = dp;
            list = new ArrayList<Integer>();
            result.add(list);
        } else {
            list = result.get(dp - 1);
        }

        if(dp % 2 == 0) {
            list.add(0, node.val);
        } else {
            list.add(node.val);
        }

        if(node.left != null || node.right != null) {
            traverseTree(node.left, dp);
            traverseTree(node.right, dp);
        }
    }

}
