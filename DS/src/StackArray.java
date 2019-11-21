public class StackArray {
    int top=-1;
    int[] arr=new int[6];
    void push(int item){
        if(isFull()) {
            System.out.println("Overflow! No more space left");
        }
        else{
            top=top+1;
            arr[top]=item;
        }
    }
    int pop(){
        if(isEmpty()){
            System.out.println("Underflow! Stack is Empty");
            return 0;
        }
        else{
            int temp=arr[top];
            top=top-1;
            return temp;
        }
    }
    int peek(){
        if(isEmpty()){
            System.out.println("Underflow! Stack is Empty");
            return 0;
        }
        else
            return arr[top];



    }
    boolean isEmpty(){
        if(top<0)
            return true;
        else
            return false;
    }
    boolean isFull(){
        if(top >= arr.length)
            return true;
        else
            return false;
    }
    void printStack(){
        System.out.println("[");
        for(int i=top; i>=0; i--){
            System.out.println(pop()+"");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        StackArray stack=new StackArray();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);

        System.out.println("Top Element is " + stack.peek());
        System.out.println("Popped Element is " + stack.pop());
        stack.printStack();
        System.out.println();
        stack.pop();
    }
}
