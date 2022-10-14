package assignment2;

import java.util.ArrayList;
import java.util.List;

public class rightSideView {

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

        rightSideView(root);
    }

    private static int depth = 1;
    private static List<Integer> list;
    public static List<Integer> rightSideView(TreeNode root) {
        list = new ArrayList<Integer>();

        if(root == null) return list;

        list.add(root.val);

        calcDepthAdd(root, 1);

        return list;
    }

    private static void calcDepthAdd(TreeNode node, int dp) {
        if(node == null) return;

        if(node.right != null || node.left != null) {
            dp++;
            if(depth < dp) {
                depth = dp;

                if(list.size() < depth) {
                    if(node.right != null) {
                        list.add(node.right.val);
                    } else {
                        list.add(node.left.val);
                    }
                }
            }

            calcDepthAdd(node.right, dp);
            calcDepthAdd(node.left, dp);
        }
    }

}
