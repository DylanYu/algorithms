package interview;

import java.util.ArrayList;

/**
 * Print a binary tree line by line
 * 
 * @author Dongliang Yu
 *
 */
public class PrintBinaryTree {
	// work for node.val less than 100
	public static void printTree(TreeNode node) {
		int height = height(node);
		int indent = (int) Math.pow(2, height-1);
		int h = 0;
		ArrayList<TreeNode> level = new ArrayList<TreeNode>();
		level.add(node);
		while (h < height) {
			ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
			for (int i = 0; i < indent-1; i++)
				System.out.print("  ");
			for (TreeNode e : level) {
				if (e != null) {
					System.out.print(String.format("%2d", e.val));
					tmp.add(e.left);
					tmp.add(e.right);
				} else {
					System.out.print("  ");
					tmp.add(null);
					tmp.add(null);
				}
				for (int i = 0; i < indent*2-1; i++)
					System.out.print("  ");
			}
			level = tmp;
			System.out.println();
			indent /= 2;
			h++;
		}
	}
	
	private static int height(TreeNode node) {
		if (node == null) return 0;
		int leftHeight = 1 + height(node.left);
		int rightHeight = 1 + height(node.right);
		return Math.max(leftHeight, rightHeight);
	}
	
	public static void main(String[] args) {
		TreeNode root = BinaryTree.createTree(3);
		printTree(root);
	}
}
