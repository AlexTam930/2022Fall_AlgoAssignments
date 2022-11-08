package assignment4;

public class rangeSumBST {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(0);
        TreeNode node1 = new TreeNode(-3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(2);


        head.left = node1;
        head.right = node2;
        node2.left = node3;

        System.out.print("The sum is " + rangeSumBST(head, -10, 10));
    }

    private static int sum = 0;

    public static int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) {
            return sum;
        }

        if(root.val >= low) {
            rangeSumBST(root.left, low, high);
        }

        if(root.val >= low && root.val <= high) {
            sum += root.val;
        }

        if(root.val <= high) {
            rangeSumBST(root.right, low, high);
        }

        return sum;
    }

}
