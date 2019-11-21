public class QueueDivisible
{
    int front= -1;
    int rear= -1;
    int[]arr=new int[6];

    void enqueue(int item)
    {
        if(isFull()){
            System.out.println("OverFlow!! Queue is Full");
        }
        else
        {
            if(front==-1);
            front=0;
            rear=rear+1;
            arr[rear]=item;
        }
    }
    int dequeue()                                        /* © Jaspreet Singh */
    {
        if(isEmpty())
        {
            System.out.println("UnderFlow!! Queue is Empty");
            return 0;
        }
        else
        {
            int temp=arr[front];
            front=front+1;
            return temp;
        }
    }
    void check()
    {
        int i=0;
        int flag=1;
        while(i<=arr.length-1)
        {
            if(arr[i]%3==0||arr[i]%5==0)
                i++;
            else
            {
                flag=0;
                break;
            }
        }
        if(flag==1)
            System.out.println("*all elements are divisible with 3 or 5*");
        else
            System.out.println("counter found");
    }
    boolean isEmpty()
    {
        if(front==rear+1)
            return true;
        else
            return false;
    }

    boolean isFull()
    {
        if(rear==arr.length-1)
            return true;
        else
            return false;
    }
    void DisplayQueue()
    {
        int temp=front;
        System.out.println("[");
        while(temp!=rear+1)
        {
            System.out.println(arr[temp]+"");
            temp=temp+1;
        }
        System.out.println("]");
    }
    public static void main(String[] args)
    {
        QueueDivisible queue =new QueueDivisible();
        queue.enqueue(3);
        queue.enqueue(25);
        queue.enqueue(9);
        queue.enqueue(50);
        queue.enqueue(30);
        queue.enqueue(55);
        queue.check();

    }
}