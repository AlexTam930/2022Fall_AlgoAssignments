import java.util.ArrayList;

public class InsertSortedList {

    public static void main(String[] args) {

        Node node1 = new Node(3);
        Node node2 = new Node(4);
        Node node3 = new Node(1);
        Node node4 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        insert(node1, 2);

        ArrayList<Integer> vals = new ArrayList<Integer>();
    }


    /**
     * Insert Node into sorted list and remain the list sorted as well.
     * @param head
     * @param insertVal
     * @return
     */
    public static Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        } else {
            Node last = head;
            while(last.next != head) {
                if(last.val < last.next.val && insertVal >= last.val && insertVal <= last.next.val) {
                    break;
                } else if(last.val > last.next.val && (insertVal >= last.val || insertVal <= last.next.val)) {
                    break;
                } else {
                    last = last.next;
                }
            }
            Node node = new Node(insertVal);
            Node nextNode = last.next;
            last.next = node;
            node.next = nextNode;
            return head;

        }
    }


}
