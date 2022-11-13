package midterm.Question2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Node test = new Node(1);

        traverse(test, null);

    }

    private static void traverse(Node node, Node parent) {
        if (node == null) {
            return;
        }

        node.parent = parent;

        traverse(node.left, node);
        traverse(node.right, node);
    }

}