class CircularLLDemo
{
    Node tail;
    void insertAtBeg(int item)
    {
        Node newnode=new Node();
        newnode.data=item;
        if (tail==null)
        {
            newnode.next = newnode;
            tail = newnode;
        }
        else
        {
            newnode.next=tail.next;
            tail.next=newnode;
        }
    }
    void deleteAtBeg()                             /* © Jaspreet Singh */
    {
        Node temp=tail.next;
        tail.next=temp.next;
        temp.next=null;
    }
    void deleteAtLast()
    {
        Node temp=tail.next;
        Node temp2=tail.next;
        while(temp.next!=tail)
        {
            temp=temp.next;
        }
        temp.next=temp2;
        tail.next=null;
        tail=temp;
    }
    void printlist()
    {
        Node temp=tail.next;
        while(temp!=tail)
        {
            System.out.println("-->"+temp.data);
            temp=temp.next;
        }

    }

    public static void main(String[] args)
    {
        CircularLLDemo list =new CircularLLDemo();
        list.insertAtBeg(20);
        list.insertAtBeg(30);
        list.insertAtBeg(40);
        list.insertAtBeg(50);
        list.insertAtBeg(60);
        list.insertAtBeg(70);
        list.insertAtBeg(80);
        list.insertAtBeg(90);
        list.insertAtBeg(100);

        System.out.println("My Circular List :");
        list.printlist();
        System.out.println("List After Deletion at beginnig: ");
        list.deleteAtBeg();
        list.printlist();
        System.out.println("List After Deletion at last: ");
        list.deleteAtLast();
        list.printlist();
    }

}