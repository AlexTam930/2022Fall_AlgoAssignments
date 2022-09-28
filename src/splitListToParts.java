public class splitListToParts {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(8);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        splitListToParts(node1, 2);
    }

    public static ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode stem = head;

        while (stem != null) {
            length++;
            stem = stem.next;
        }

        int partLen = length / k;
        int np = length % k;

        ListNode[] results = new ListNode[k];
        ListNode cur = head;

        for (int i = 0; i < k && cur != null; i++) {
            results[i] = cur;
            int size = partLen;
            if(i < np) {
                size = partLen + 1;
            }

            for (int j = 1; j < size; j++) {
                cur = cur.next;
            }

            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return results;
    }

}
