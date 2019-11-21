public class PriorityQueue {
    int front = -1;
    int rear = -1;
    int[] arr = new int[8];
    public static final int MAX = 1000;

    void enqueue(int item) {
        if (isFull())
            System.out.println("Overflow");
        else {
            if (front == -1)
                front = 0;
            rear = rear + 1;
            arr[rear] = item;
        }
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("UnderFlow");
            return 0;
        } else {
            int priority = MAX;
            int temp = 0;
            while (front != rear + 1)
            {
                if (priority > arr[front])
                {
                    priority = arr[front];
                    temp = front ;
                    front = front + 1;
                } else front = front + 1;
            }
            arr[temp] = arr[rear];
            rear = rear - 1;
            front = 0;
            return priority;
        }
    }
    boolean isEmpty(){
        if(front== rear + 1 || front == -1)
            return true;
        else
            return false;
    }
    boolean isFull(){
        if(rear==arr.length)
            return true;
        else
            return false;
    }
    void printQueue(){
        System.out.println("[");
        while(front!=rear+1){
            System.out.println(dequeue()+"");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        PriorityQueue que=new PriorityQueue();
        que.enqueue(3);
        que.enqueue(7);
        que.enqueue(1);
        que.enqueue(8);
        que.enqueue(4);
        que.enqueue(11);
        que.enqueue(6);
        que.enqueue(12);

        System.out.println("Queue Element with the highest priority is "+ que.dequeue());
        System.out.println("queue Element with 2nd highest priority is "+que.dequeue());
        System.out.println("elements with the order of their priorities...");
        que.printQueue();

    }

}
