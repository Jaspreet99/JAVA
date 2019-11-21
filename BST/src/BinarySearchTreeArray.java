public class BinarySearchTreeArray {
    final int MAX = 100;
    int[] tree = new int[MAX];
    int index = 0;
    int top = -1;
    int[] stack = new int[MAX];
    static int[] keys = {1, 2, 3, 4, 5, 6, 7, 8};
    private Node root;

    void insertKey(int key){
        if(index == 0){
            index = index+1;
            tree[index] = key;
        }
        else{
            while(tree[index] != 0){
                if(key < tree[index])
                    index = index*2;
                else
                    index = index*2+1;
            }
            tree[index] = key;
            index = 0;
        }

    }

    void push_stack(int item){
        if(top == MAX-1)
            System.out.println("Overflow! Tree size is full");
        else{
            top = top+1;
            stack[top] = item;
        }
    }

    int pop_stack(){
        if(top == -1){
            System.out.println("Underflow! Tree is Empty");
            return 0;
        }
        else{
            int temp = stack[top];
            top = top - 1;
            return temp;
        }
    }

    boolean stack_empty(){
        if(top == -1)
            return true;
        else
            return false;
    }

        void topView() {
            this.root = root;
            if(root == null) return;
            leftSide(root);

            if(root.right != null){
                rightSide(root.right);
            }
        }
        void leftSide(Node leftRoot){
            if(leftRoot.left != null){
                leftSide(leftRoot.left);
            }
            System.out.print(leftRoot.data + " ");
            return;
        }
        void rightSide(Node rightRoot){
            System.out.print(rightRoot.data + " ");
            if(rightRoot.right != null){
                rightSide(rightRoot.right);
            }
            return;
        }




    public static void main(String[] args){
        BinarySearchTreeArray btree = new BinarySearchTreeArray();
        System.out.println();
        System.out.print("Elements inserted into Binary Search Tree are: ");
        for(int i = 0; i <= keys.length-1; i++){
            System.out.print(keys[i]+" ");
            btree.insertKey(keys[i]);
        }
        System.out.println();
        System.out.print("Top View is ");
        btree.topView();
    }

}

