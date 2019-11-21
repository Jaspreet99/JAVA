public class BinaryTraversalInorder{
    int top = -1;
    int index = 0;
    final int MAX = 100;
    char[] tree = new char[MAX];				// This will hold all the tree elements
    char[] stack = new char[MAX];				// We will take a stack for iteration

    void insertNode(char item){
        if(index >= tree.length-1){
            System.out.println("Overflow!! Can't add more Nodes.. Tree is full");
        }
        else{
            index = index + 1;
            tree[index] = item;
        }
    }

    // Push elements in a binary tree
    void push_stack(char item){
        if(top == MAX-1)
            System.out.println("Overflow!! Tree size is full");
        else{
            top = top+1;
            stack[top] = item;
        }
    }

    // Pop elements in a binary tree
    char pop_stack(){
        if(top == -1){
            System.out.println("Underflow!! Tree is Empty");
            return '\0';
        }
        else{
            char temp = stack[top];
            top = top - 1;
            return temp;
        }
    }

    // Check if the Stack is empty
    boolean stack_empty(){
        if(top == -1)
            return true;
        else
            return false;
    }

    int getRightChild(int index)
    {
        // index is not null
        // and the result must lie within the number of nodes for a complete binary tree
        if(tree[index]!='\0' && ((2*index)+1)<=MAX)
            return (2*index)+1;
        // right child doesn't exist
        return -1;
    }

    int getLeftChild(int index)
    {
        // index is not null
        // and the result must lie within the number of nodes for a complete binary tree
        if(tree[index]!='\0' && (2*index)<=MAX)
            return 2*index;
        // left child doesn't exist
        return -1;
    }

    // In-Order Traversal - Non Recursive
    void in_nrec(int index){
        char item;
        while(true){

            // Go to the left extreme
            while(tree[index] != '\0'){
                push_stack(tree[index]);
                index = getLeftChild(index);
            }
            if(top != -1){
                for(int i = 1; i <= tree.length-1; i++){
                    if(stack[top] == tree[i])
                        index = i;
                }
            }
            if(top == -1)
                break;					// Break out from the while loop
            // Pop and print the element at the top of the Stack
            item = pop_stack();
            System.out.print(item+" ");
            // Now add elements to the right
            index = getRightChild(index);
        }
        System.out.println();
    }

    public static void main(String[] args){
        BinaryTraversalInorder traverse = new BinaryTraversalInorder();
        traverse.insertNode('A');
        traverse.insertNode('D');
        traverse.insertNode('H');
        traverse.insertNode('M');
        traverse.insertNode('T');
        traverse.insertNode('K');
        traverse.insertNode('P');
        traverse.insertNode('S');
        traverse.insertNode('F');
        traverse.insertNode('Q');
        traverse.insertNode('U');
        traverse.insertNode('C');
        System.out.println();
        System.out.print("In-Order traversal of the given tree is: ");
        traverse.in_nrec(1);

    }
}
