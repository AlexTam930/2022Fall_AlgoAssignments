package assignment4;

public class recoverTree {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(-10);
        TreeNode node1 = new TreeNode(-3);
        TreeNode node2 = new TreeNode(0);
        head.left = node1;
        head.right = node2;

        recoverTree(head);
    }

    private static TreeNode node1;
    private static TreeNode node2;
    private static TreeNode prev;

    private static void recoverTree(TreeNode root) {
        traverse(root);

        int stem = node1.val;
        node1.val = node2.val;
        node2.val = stem;
    }

    private static void traverse(TreeNode node) {
        if(node == null) {
            return;
        }

        traverse(node.left);

        if(prev != null) {
            if(node1 == null && prev.val >= node.val) {
                node1 = prev;
            }
            if (node1 != null && prev.val >= node.val) {
                node2 = node;
            }
        }

        prev = node;
        traverse(node.right);

    }

}
