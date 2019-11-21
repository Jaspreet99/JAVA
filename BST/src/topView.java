

import java.util.*;
class solution
{

    static class Node {
        Node left;
        Node right;
        int data;
    };

    static class Pair {
        Node first;
        int second;
        Pair(Node n,int a)
        {
            first=n;
            second=a;
        }
    };

    static Node newNode(int key)
    {
        Node node = new Node();
        node.left = node.right = null;
        node.data = key;
        return node;
    }

    static void topView( Node root)
    {
        // Base case
        if (root == null) {
            return;
        }

        Node temp = null;

        Queue<Pair > q = new LinkedList<Pair>();

        Map<Integer, Integer> mp = new TreeMap<Integer, Integer>();

        q.add(new Pair( root, 0 ));

        // BFS
        while (q.size()>0) {

            temp = q.peek().first;
            int d = q.peek().second;
            q.remove();


            if (mp.get(d) == null) {mp.put(d, temp.data);
            }

            if (temp.left!=null) {
                q.add(new Pair( temp.left, d - 1 ));
            }

            if (temp.right!=null) {
                q.add(new Pair( temp.right, d + 1 ));
            }
        }
        for(Integer data:mp.values()){
            System.out.print( data + " ");
        }
    }

    // Driver Program to test above functions
    public static void main(String args[])
    {

        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.right = newNode(4);
        root.right.left = newNode(5);
        root.right.right = newNode(6);
        root.right.left.left=newNode(7);
        root.right.left.right=newNode(8);
        System.out.println( "Following are nodes in top view of Binary Tree\n");
        topView(root);
    }
}

