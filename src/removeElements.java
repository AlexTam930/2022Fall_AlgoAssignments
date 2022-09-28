public class removeElements {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        removeElements(node1, 2);
    }

    public static ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return head;
        }

        ListNode emptyNo = new ListNode(-1);
        ListNode pre = emptyNo;
        ListNode cur = head;
        emptyNo.next = head;

        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            }else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return emptyNo.next;

    }
}
