package interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public static TreeNode createTree(int height) {
        TreeNode root = new TreeNode(0);
        ArrayList<TreeNode> level = new ArrayList<TreeNode>();
        /*
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(18);
        root.left.right.left = new TreeNode(7);
        root.right.left.right = new TreeNode(12);
        root.left.right.left.left = new TreeNode(6);
        */
        level.add(root);
        int h = 0;
        int n = 1;
        while (h < height) {
        	ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
        	for (TreeNode e : level) {
        		e.left = new TreeNode(n++);
        		e.right = new TreeNode(n++);
        		tmp.add(e.left);
        		tmp.add(e.right);
        	}
        	level = tmp;
        	h++;
        }
        return root;
    }
    
    public static void show(TreeNode root) {
        if (root == null) return;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode tail = queue.getLast();
            TreeNode cur = queue.removeFirst();
            while (true) {
                System.out.print(cur.val + " ");
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
                if (cur == tail) break;
                cur = queue.removeFirst();
            }
            System.out.println();
        }
    }
}
