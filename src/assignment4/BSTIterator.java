package assignment4;

import java.util.LinkedList;

public class BSTIterator {

    private static TreeNode tree;
    private static LinkedList<Integer> list;        // storing all nodes in it.

    public BSTIterator(TreeNode root) {
        tree = root;
        list = new LinkedList<>();
        traverse(root);
    }

    private static int next() {
        return list.poll();
    }

    private static boolean hasNext() {
        return list.size() > 0;
    }

    private static void traverse(TreeNode node) {
        if(node == null){
            return;
        }

        traverse(node.left);
        list.offer(node.val);
        traverse(node.right);
    }

}
