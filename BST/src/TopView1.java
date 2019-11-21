public class TopView1 {
    public void topView (NodeTree root) {
        if(root == null) return;
        //This will take care of left side and the top node (Grand Parent Node)
        leftSide(root);
        if(root.right != null){
            rightSide(root.right);
        }
    }
     void leftSide(NodeTree leftRoot){
        if(leftRoot.left != null){
            leftSide(leftRoot.left);
        }
        System.out.print(leftRoot.data + " ");
        return;
    }
     void rightSide(NodeTree rightRoot) {
        System.out.print(rightRoot.data + " ");
        if (rightRoot.right != null) {
            rightSide(rightRoot.right);
        }
        return;
    }


    public int maxDepth(NodeTree root) {
        if(root == null) return 0;
        int x = 0;
        int y = 0;
        x += (root.left != null) ? leftSide(root, x) : 0;
        y += (root.right != null) ? rightSide(root, y) : 0;
        return (x > y) ? x : y;
    }

    public int leftSide(NodeTree root, int counter){
        return (root.left != null) ? leftSide(root.left, counter++) : counter;
    }
    public int rightSide(NodeTree root, int counter){
        return (root.right != null) ? rightSide(root.right, counter++) : counter;
    }
}

