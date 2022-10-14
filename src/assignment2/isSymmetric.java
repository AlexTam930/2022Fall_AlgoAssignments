package assignment2;

public class isSymmetric {

    public void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.right = node4;
        System.out.println("Result is " + isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        return recurse(root.left, root.right);
    }
    private static boolean recurse(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) {
            return true;
        }

        if(node1 == null || node2 == null) {
            return false;
        }

        if(node1.val != node2.val) {
            return false;
        }

        return recurse(node1.left, node2.right) && recurse(node1.right, node2.left);
    }

}
