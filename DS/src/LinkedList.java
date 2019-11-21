import java.util.*;
public class LinkedList {
    Node head;

    void insertAtBeginning(int item) {
        Node newnode = new Node();
        newnode.data = item;
        newnode.next = head;
        head = newnode;
    }

    void deleteAtBeginning() {
        Node temp = head;
        head = head.next;
        temp.next = null;
    }

    void insertAtMiddle(int ab, int item) {
        Node temp = head;
        while (temp.data!= ab)
        {
            temp = temp.next;
        }

        Node newNode = new Node();
        newNode.data = item;
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void printlist() {
        Node temp = head;
        while (temp != null) {
            System.out.println("-->" + temp.data);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtBeginning(10);
        list.insertAtBeginning(20);
        list.insertAtBeginning(30);
        list.insertAtBeginning(40);
        list.insertAtBeginning(50);
        list.insertAtBeginning(60);
        System.out.println("Our Linked List");
        list.printlist();
        list.deleteAtBeginning();
        System.out.println("List after deleting one element ");
        list.printlist();
        System.out.println("List after ");
        list.insertAtMiddle(40, 5000);
        list.printlist();
    }
}

