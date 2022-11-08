package assignment4;

public class sortedListToBST {

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        ListNode node1 = new ListNode(-3);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        sortedListToBST(head);
    }

    private static ListNode rootStem;

    public static TreeNode sortedListToBST(ListNode head) {
        rootStem = head;
        ListNode stem = head;

        int sum = 0;
        while(stem != null) {
            stem = stem.next;
            ++sum;
        }
        return traverse(0, sum - 1);
    }

    private static TreeNode traverse(int start, int end) {
        if(start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode left = traverse(start, mid - 1);

        TreeNode root = new TreeNode(rootStem.val);
        rootStem = rootStem.next;
        root.left = left;

        TreeNode right = traverse(mid + 1, end);
        root.right = right;
        return root;
    }

}
