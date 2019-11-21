class BinaryTraversalPost{
    int top = -1;
    int top2 = -1;
    int index = 0;
    final int MAX = 100;
    char[] tree = new char[MAX];			// This will hold the tree elements
    char[] stack = new char[MAX];
    char[] stackFinal = new char[MAX];		// 2nd Stack for holding the Final Result

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

    // Push elements to the Final Stack
    void push_stackFinal(char item){
        if(top2 == MAX-1)
            System.out.println("Overflow!! Tree size is full");
        else{
            top2 = top2+1;
            stackFinal[top2] = item;
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

    // Pop elements from the Final Stack
    char pop_stackFinal(){
        if(top2 == -1){
            System.out.println("Underflow!! Tree is Empty");
            return '\0';
        }
        else{
            char temp = stackFinal[top2];
            top2 = top2 - 1;
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

    // Post-Order Traversal - Non Recursive
    void post_nrec(int index){
        char item;
        push_stack(tree[index]);
        while(!stack_empty()){			// Till Stack is not empty
            for(int i = 1; i <= tree.length-1; i++){
                if(stack[top] == tree[i])
                    index = i;
            }
            item = pop_stack();
            push_stackFinal(item);					// Push element into another stack
            if(tree[getLeftChild(index)] != '\0')		// Left Child
                push_stack(tree[getLeftChild(index)]);
            if(tree[getRightChild(index)] != '\0')		// Right Child
                push_stack(tree[getRightChild(index)]);
        }
        while(top2 != -1)
            System.out.print(pop_stackFinal()+" ");
        System.out.println();
    }

    public static void main(String[] args){
        BinaryTraversalPost traverse = new BinaryTraversalPost();
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
        System.out.print("Post-Order traversal of the given tree is: ");
        traverse.post_nrec(1);

    }
}