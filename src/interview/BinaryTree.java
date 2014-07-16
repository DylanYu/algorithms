package interview;

import java.util.ArrayList;

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
}
