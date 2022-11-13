package midterm.Question4;


public class Main {

    // Sorted insert in a Link list.
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.head = new Node(1);
        linkList.head.next = new Node(2);
        linkList.head.next.next = new Node(5);

        linkList.insert(3);
    }



}