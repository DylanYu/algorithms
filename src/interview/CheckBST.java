package interview;

import java.util.Iterator;

import algs.LinkedQueue;

public class CheckBST {
    private static class Node {
        int val;
        Node left;
        Node right;
        
        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * Inorder traverse the tree and check the resulting queue
     */
    public static boolean isBST(Node node) {
        LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
        inorder(node, queue);
        Iterator<Integer> iterator = queue.iterator();
        int prev = iterator.hasNext() ? iterator.next() : -1;
        while (iterator.hasNext()) {
            int now = iterator.next();
            if (now <= prev)
                return false;
            prev = now;
        }
        return true;
    }
    
    public static void inorder(Node node, LinkedQueue<Integer> queue) {
        if (node != null) {
            inorder(node.left, queue);
            queue.enqueue(node.val);
            inorder(node.right, queue);
        }
    }
    
    /**
     * Check with BST definition 
     */
    public static boolean isBSTTediously(Node node) {
        if (node == null)
            return true;
        else {
            int maxLeft = max(node.left);
            if (node.left != null && maxLeft >= node.val)
                return false;
            int minRight = min(node.right);
            if (node.right != null && minRight <= node.val)
                return false;
        }
        return isBSTTediously(node.left) && isBSTTediously(node.right);
    }
    
    public static int max(Node node) {
        if (node == null)
            return Integer.MIN_VALUE;
        int leftMax = max(node.left);
        int rightMax = max(node.right);
        return Math.max(node.val, Math.max(leftMax, rightMax));
    }
    
    public static int min(Node node) {
        if (node == null)
            return Integer.MAX_VALUE;
        int leftMin = min(node.left);
        int rightMin = min(node.right);
        return Math.min(node.val, Math.min(leftMin, rightMin));
    }
    
    public static Node createTree() {
                    Node root = new Node(10);
            root.left = new Node(5);
                                    root.right = new Node(15);
        root.left.left = new Node(4);
                root.left.right = new Node(9);
                                root.right.left = new Node(11);
                                        root.right.right = new Node(18);
        return root;
    }
    
    public static void main(String[] args) {
        Node root = createTree();
        System.out.println(isBST(root));
        //System.out.println(isBSTTediously(root));
    }
}
