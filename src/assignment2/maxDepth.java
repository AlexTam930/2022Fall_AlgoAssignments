package assignment2;

public class maxDepth {
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

        System.out.println("Maximal depth is " + maxDepth(root));
    }

    private static int depth = 1;
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        calcDepth(root, 1);
        return depth;
    }
    private static void calcDepth(TreeNode root, int dp) {
        if(root == null) return;
        if(root.left != null || root.right != null) {
            dp++;
            if(dp > depth) {
                depth = dp;
            }

            calcDepth(root.left, dp);
            calcDepth(root.right, dp);
        }
    }


}
