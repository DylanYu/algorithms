package interview;

/**
 * Given a binary tree, find the lowest common ancestor of two given nodes in the tree.
 * 
 * @author Dongliang Yu
 *
 */
public class LowestCommonAncestor {
    public static TreeNode LCA(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || node1 == null || node2 == null) return null;
        if (node1 == node2) return node1;
        int n = contain(root.left, node1, node2);
        if (n == 1) return root;
        else if (n == 2) return LCA(root.left, node1, node2);
        else return LCA(root.right, node1, node2);
    }
    
    private static int contain(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null) return 0;
        if (root == n1 || root == n2) return 1 + contain(root.left, n1, n2) + contain(root.right, n1, n2);
        else return contain(root.left, n1, n2) + contain(root.right, n1, n2);
    }
    
    public static void main(String[] args) {
        TreeNode root = BinaryTree.createTree(3);
        BinaryTree.show(root);
        TreeNode n3 = root.left.left;
        TreeNode n6 = root.right.right;
        TreeNode n9 = root.left.right.left;
        TreeNode n10 = root.left.right.right;
        System.out.println(LCA(root, n3, n6).val == 0);
        System.out.println(LCA(root, n3, n10).val == 1);
        System.out.println(LCA(root, n9, n10).val == 4);
        System.out.println(LCA(root, root, n9).val == 0);
        System.out.println(LCA(root, n6, n6).val == 6);
    }
}
