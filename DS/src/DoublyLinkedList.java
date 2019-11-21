public class DoublyLinkedList {
    DoublyNode head;

    void insertAtBeg(int item)
    {
        DoublyNode newnode = new DoublyNode();
        newnode.data = item;
        newnode.next = head;
        newnode.prev = null;
        if (head == null)
            head = newnode;
        else
            head.prev = newnode;
        head = newnode;
    }

    void deleteAtBeg()
    {
        DoublyNode temp=head;
        head=head.next;
        head.prev=null;
        temp.next=null;

    }
    void printlist()
    {
        DoublyNode temp=head;
        while (temp!=null){
            System.out.println("<--"+ temp.data+ "-->");
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list=new DoublyLinkedList();
        list.insertAtBeg(10);
        list.insertAtBeg(20);
        list.insertAtBeg(30);
        list.insertAtBeg(40);
        list.insertAtBeg(50);
        list.insertAtBeg(60);
        System.out.println("Doubly Linked List is");
        list.printlist();
        list.deleteAtBeg();
        System.out.println();
        System.out.println("List After The Deletion from Beginning");
        list.printlist();

    }
}