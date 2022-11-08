package assignment4;

public class isValidBST {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(-10);
        TreeNode node1 = new TreeNode(-3);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(5);

        head.left = node1;
        head.right = node2;
        node1.left = node3;
        node2.right = node4;

        System.out.print("The result = " + isValidBST(head));
    }

    private static boolean flag = false;
    private static boolean result = true;
    private static int max;

    private static boolean isValidBST(TreeNode root) {
        traverse(root);
        return result;
    }

    /**
     * The key to define whether it is a valid BST, is to find out whether value of every single node is greater than last one,
     * when reading the tree with inorder traversal.
     * @param node
     */
    private static void traverse(TreeNode node) {
        if(node == null) {
            return;
        }

        traverse(node.left);
        if(!flag) {
            max = node.val;
            flag = true;
        } else {
            if(node.val <= max) {
                result = false;
                return;
            } else {
                max = node.val;
            }
        }
        traverse(node.right);
    }

}
