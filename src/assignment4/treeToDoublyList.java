package assignment4;

import java.util.Stack;

public class treeToDoublyList {

    public static void main(String[] args) {
        Node head = new Node(-10);
        Node node1 = new Node(-3);
        Node node2 = new Node(0);

        head.left = node1;
        head.right = node2;

        treeToDoublyList(head);
    }

    public static Node treeToDoublyList(Node root) {
        if(root == null){
            return root;
        }

        Stack<Node> stack = new Stack<Node>();   // to store elements when reading the given root node.

        Node stem = new Node();
        Node cur = stem;

        while(root != null || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            } else {
                Node top = stack.pop();
                cur.right = top;
                top.left = cur;
                cur = cur.right;
                root = top.right;
            }
        }

        cur.right = stem.right;
        stem.right.left = cur;  // stem node makes reading processing easier.

        return stem.right;
    }

}
