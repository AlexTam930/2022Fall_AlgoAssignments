package midterm.Question3;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // In a Binary search tree print values which are inside of range. Optimize it if possible
    // Given range between 5 and 8 it will print 6, 7, 8
    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();

        traverse(getBST(), result, 5, 8);

        printList(result);
    }

    private static void printList(List<Integer> list) {
        if (list == null || list.size() == 0) {
            System.out.print("[]");
        } else {
            System.out.print("[");

            for (int i : list) {
                System.out.print(i + ", ");
            }

            System.out.print("]");
        }
    }

    private static void traverse(Node node, List<Integer> list, int small, int great) {
        if (node == null) {
            return;
        }

        traverse(node.left, list, small, great);

        if ((int) node.data <= great && (int) node.data >= small) {
            list.add((int) node.data);
        }

        traverse(node.right, list, small, great);
    }

    // Given range between 5 and 8 it will print 6, 7, 8
    private static Node<Integer> getBST(){
        Node<Integer> root = new Node<>(8);
        root.parent = root;

        root.left = new Node<>(3);
        root.right = new Node<>(10);
        root.left.parent = root;
        root.right.parent = root;


        root.left.left = new Node<>(1);
        root.left.right = new Node<>(6);
        root.left.left.parent = root.left;
        root.left.right.parent = root.left;

        root.right.right = new Node<>(14);
        root.right.right.parent = root.right;

        root.left.right.left = new Node<>(4);
        root.left.right.right = new Node<>(17);
        root.left.right.left.parent = root.left.right;
        root.left.right.right.parent = root.left.right;


        root.right.right.left = new Node<>(13);
        root.right.right.left.parent = root.right.right;



        return root;
    }

}