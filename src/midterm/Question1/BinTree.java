package midterm.Question1;

public class BinTree <T> {
    public Node<T> root;

    public BinTree() {

    }

    public void populateNextRight(){
        findNextLeft(root);
    }

    private static Node findNextLeft(Node root) {
        if(root == null) {
            return root;
        }
        // read the Node in level order and populate nextLeft pointer from every right-node to left-node.
        if(root.right != null) {
            root.right.nextLeft = root.left;
        }
        if(root.left != null) {
            if(root.nextLeft != null) {
                root.left.nextLeft = root.nextLeft.right;
            } else {
                root.left.nextLeft = null;
            }
        }

        findNextLeft(root.right);
        findNextLeft(root.left);

        return root;
    }

}