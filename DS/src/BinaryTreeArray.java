class BinaryTreeArray{
    char[] tree = new char[11];
    int index = 0;
    void insertNode(char item){
        if(isFull()){
            System.out.println("Overflow!! Can't add more Nodes.. Tree is full");
        }
        else{
            index = index + 1;
            tree[index] = item;
        }
    }

    char deleteNode(int position){
        if(isEmpty()){
            System.out.println("Underflow!!! Tree is Empty");
            return 0;
        }
        else{
            char temp = tree[position];
            tree[position] = tree[index];			// Replace deleted node with the last node
            index = index - 1;
            return temp;
        }
    }

    void displayTree(){
        int i = 1;
        while(i <= index)
            System.out.print(tree[i++]+" ");
        System.out.println();
    }

    char getLeftChild(int k){
        int left = k*2;
        return tree[left];
    }

    char getRightChild(int k){
        int right = (k*2) + 1;
        return tree[right];
    }

    boolean isFull(){
        if(index >= tree.length-1)
            return true;
        else
            return false;
    }

    boolean isEmpty(){
        if(index <= 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        BinaryTreeArray btree = new BinaryTreeArray();
        btree.insertNode('A');
        btree.insertNode('D');
        btree.insertNode('B');
        btree.insertNode('J');
        btree.insertNode('X');
        btree.insertNode('U');
        btree.insertNode('T');
        btree.insertNode('H');
        btree.insertNode('E');


        System.out.print("Elements inside Binary Tree are: ");
        btree.displayTree();

        System.out.println("Left Child of Node at index 3 is: "+btree.getLeftChild(3));

        System.out.println("Right Child of Node at index 4 is: "+btree.getRightChild(4));

        System.out.println("Node deleted at position 5 is: "+btree.deleteNode(5));

        System.out.print("Updated Tree is: ");
        btree.displayTree();

        btree.insertNode('Y');
        btree.insertNode('Z');

        System.out.print("Tree after adding new nodes: ");
        btree.displayTree();

        System.out.println();
        btree.insertNode('G');
    }
}