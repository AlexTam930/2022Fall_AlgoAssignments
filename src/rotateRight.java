import java.util.ArrayList;

public class rotateRight {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        rotateRight(node1, 2);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }

        ArrayList<ListNode> nodes = new ArrayList<ListNode>();

        ListNode st = head;
        while(st!=null) {
            ListNode node = new ListNode(st.val);
            nodes.add(node);
            st = st.next;
        }

        k = k % nodes.size();

        if(k == 0 || k > nodes.size()){
            return head;
        }else {
            ListNode h = nodes.get(nodes.size() - k);
            ListNode stem = h;
            for(int i = nodes.size() - k + 1; i < nodes.size(); i ++) {
                stem.next = nodes.get(i);
                stem = stem.next;
            }
            for(int p = 0; p < nodes.size() - k; p ++ ){
                stem.next = nodes.get(p);
                stem = stem.next;
            }
            return h;
        }
    }

}
