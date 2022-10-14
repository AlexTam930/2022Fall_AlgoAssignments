package assignment2;

import java.util.ArrayList;
import java.util.List;

public class widthOfBinaryTree {

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

        System.out.println("The width of the binary tree is" + widthOfBinaryTree(root));
    }

    private static int width = 1;

    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        List<Integer> startOfLevel = new ArrayList<Integer>();
        traverse(root, 0, 1, startOfLevel);

        return width;
    }

    public static void traverse(TreeNode root, int level, int index, List<Integer> list) {
        if (root == null) return;

        if (level == list.size()){
            list.add(index);
        }

        width = Math.max(width, index + 1 - list.get(level));
        traverse(root.left, level + 1, index * 2, list);
        traverse(root.right, level + 1, index * 2 + 1, list);
    }


}
