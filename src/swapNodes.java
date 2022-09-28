import java.util.ArrayList;

public class swapNodes {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        swapNodes(node1, 2);
    }


    public static ListNode swapNodes(ListNode head, int k) {
        if(head == null) {
            return head;
        }

        ArrayList<Integer> vals = new ArrayList<Integer>();

        ListNode stem = head;
        while(stem != null) {
            vals.add(stem.val);
            stem = stem.next;
        }

        if(k > vals.size()) {
            return head;
        } else {
            int st = vals.get(k-1);
            vals.set(k-1,vals.get(vals.size() - k));
            vals.set(vals.size() - k, st);
            ListNode mHead = new ListNode(vals.get(0));
            ListNode ste = mHead;
            for(int i = 1; i < vals.size(); i++){
                ste.next = new ListNode(vals.get(i));
                ste = ste.next;
            }
            return mHead;
        }
    }

}
