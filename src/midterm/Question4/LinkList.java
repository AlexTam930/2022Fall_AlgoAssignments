package midterm.Question4;

import java.util.LinkedList;

public class LinkList  {

    public Node head;

    public int length = 0;

    public LinkList() {
        head = null;
    }

    public void insert(Integer data){
        // Insert in sorted manner
        // data of Nodes is in ascending order.
        Node node = new Node(data);

        if (node.data <= head.data) {
            node.next = head;
            return;
        }

        Node stem = head;

        while (stem != null) {
            if (stem.next != null) {
                if (node.data >= stem.data && node.data <= stem.next.data) {
                    stem.next = node;
                    node.next = stem.next;
                } else if (stem.next == null && node.data >= stem.data) {
                    stem.next = node;
                }
            }

            stem = stem.next;
        }

    }

}
