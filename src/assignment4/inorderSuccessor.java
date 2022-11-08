package assignment4;

public class inorderSuccessor {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(0);
        TreeNode node1 = new TreeNode(-3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(2);


        head.left = node1;
        head.right = node2;
        node2.left = node3;

        inorderSuccessor(head, node2);
    }


    private static TreeNode prev;
    private static TreeNode result;

    private static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        traverse(root, p);
        return result;
    }

    private static void traverse(TreeNode node, TreeNode target) {
        if(node == null) {
            return;
        }

        traverse(node.left, target);

        if(prev != null && prev.val == target.val) {
            result = node;
        }
        prev = node;

        traverse(node.right, target);

    }

}
