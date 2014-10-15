package interview;

/**
 * Convert binary search tree to doubly linked list. You should not use any extra space.
 * (Treat the TreeNode's left and right link as prev and next in doubly linked list in conversion)
 * 
 * @author Dongliang Yu
 *
 */
public class ConvertBSTToDoublyLinkedList {
    public static TreeNode convert(TreeNode root) {
        if (root == null) return null;
        TreeNode[] head = new TreeNode[1]; // tricky
        TreeNode[] prev = new TreeNode[1];
        convert(root, head, prev);
        return head[0];
    }
    
    private static void convert(TreeNode node, TreeNode[] head, TreeNode[] prev) {
        if (node == null) return;
        convert(node.left, head, prev);
        if (prev[0] == null) head[0] = node;
        else {
            node.left = prev[0];
            prev[0].right = node;
        }
        prev[0] = node; //
        convert(node.right, head, prev);
    }
    
    public static void main(String[] args) {
        TreeNode root = BinaryTree.createTree(2);
        BinaryTree.show(root);
        System.out.println("------");
        TreeNode head = convert(root);
        TreeNode p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.right;
        }
    }
}
