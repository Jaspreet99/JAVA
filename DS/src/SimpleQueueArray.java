class SimpleQueueArray {
    int front = -1;
    int rear = -1;
    int[] arr = new int[6];

    void enqueue(int item) {
        if (isFull()) {
            System.out.println("OverFlow!! Queue is Full");
        } else {
            if (front == -1) ;
            front = 0;
            rear = rear + 1;
            arr[rear] = item;

        }
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("UnderFlow!! Queue is Empty");
            return 0;

        } else {
            int temp = arr[front];
            front = front + 1;
            return temp;
        }
    }

    boolean isEmpty() {
        if (front == rear + 1)
            return true;
        else {
            return false;
        }
        }

    boolean isFull() {
        if (rear == arr.length - 1)
            return true;
        else{
            return false;
        }
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("UnderFlow Queue is Empty");
            return 0;

        }
        else
            {


            return arr[front];
        }
    }


    void DisplayQueue() {
        int temp = front;
        System.out.println("[");
        while (temp != rear + 1) {
            System.out.println(arr[temp] + "");
            temp = temp + 1;
        }
        System.out.println("]");
    }


    public static void main(String[] args) {
        SimpleQueueArray queue = new SimpleQueueArray();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        System.out.println("Element deleted " +queue.dequeue());
        System.out.println("Elements  at the front is" +queue.peek());
        System.out.println();
        System.out.println("Elements remaining inside the queue are:");
        queue.DisplayQueue();


    }
}
