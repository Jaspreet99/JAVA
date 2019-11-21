class CircularList {
    Node tail;
    void insertAtBeg(int item)
    {
        Node newnode=new Node();
        newnode.data=item;
        if (tail==null) {
            newnode.next = newnode;
            tail = newnode;
        }
            else{
            newnode.next=tail.next;
            tail.next=newnode;

            }
        }
    void deleteAtBeg()
    {
        Node temp=tail.next;
        tail.next=temp.next;
        temp.next=null;
    }
    void printlist()
    {
        Node temp=tail.next;
        while(temp!=tail){
            System.out.println("-->"+temp.data);
            temp=temp.next;
        }

    }

    public static void main(String[] args) {
        CircularList list =new CircularList();
        list.insertAtBeg(20);
        list.insertAtBeg(30);
        list.insertAtBeg(40);
        list.insertAtBeg(50);
        list.insertAtBeg(60);
        System.out.println("My Circular List :");
        list.printlist();
        System.out.println("List After Deletion from ");
        list.deleteAtBeg();
        System.out.println("Updated List");
        list.printlist();
    }
}
