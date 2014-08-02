package interview;

import java.util.LinkedList;
import java.util.List;

import test.util.Generator;

/**
 * http://leetcode.com/2010/09/serializationdeserialization-of-binary.html
 * 
 * @author Dongliang Yu
 *
 */
public class BinaryTreeToString {
    public static String levelorderSerialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        //if (root == null) return sb.toString(); // not necessary because we should print "#" for null root
        List<TreeNode> level = new LinkedList<TreeNode>();
        level.add(root);
        while (level.size() > 0) {
            List<TreeNode> nextLevel = new LinkedList<TreeNode>();
            for (TreeNode node : level) {
                if (node == null)  sb.append("# ");
                else {
                    sb.append(node.val);
                    sb.append(' ');
                    nextLevel.add(node.left);
                    nextLevel.add(node.right);
                }
            }
            level = nextLevel;
        }
        return sb.toString().trim();
    }
    
    public static TreeNode levelorderDeserialize(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '#') return null;
        String[] nodeVals = s.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(nodeVals[0]));
        List<TreeNode> level = new LinkedList<TreeNode>();
        level.add(root);
        int index = 1;
        while (index < nodeVals.length) {
             List<TreeNode> nextLevel = new LinkedList<TreeNode>();
            for (TreeNode node : level) {
                if (nodeVals[index].equals("#")) node.left = null;
                else {
                    node.left = new TreeNode(Integer.parseInt(nodeVals[index]));
                    nextLevel.add(node.left);
                }
                index++;
                if (nodeVals[index].equals("#")) node.right = null;
                else {
                    node.right = new TreeNode(Integer.parseInt(nodeVals[index]));
                    nextLevel.add(node.right);
                }
                index++;
            }
            level = nextLevel;
        }
        return root;
    }
    
    
    public static String preorderSerialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        preorderSerialize(root, sb);
        return sb.toString();
    }
    
    private static void preorderSerialize(TreeNode node, StringBuffer sb) {
        if (node == null) sb.append("# ");
        else {
            sb.append(node.val);
            sb.append(' ');
            preorderSerialize(node.left, sb);
            preorderSerialize(node.right, sb);
        }
    }
    
    private static String s;

    public static TreeNode preorderDeserialize(String str) {
        s = str.trim();
        return preorderDeserialize();
    }
    
    public static TreeNode preorderDeserialize() {
        if (s == null || s.length() == 0) return null;
        String cur = s.split(" ")[0];
        if (cur.equals("#")) {
            if (s.length() == 1) s = ""; // watch out index bound
            else s = s.substring(2); // plus one space
            return null;
        } else {
            int val = Integer.parseInt(cur);
            TreeNode node = new TreeNode(val);
            
            int valLen = cur.length();
            if (s.length() == valLen) s = "";
            else s = s.substring(valLen+1); // plus one space
            
            node.left = preorderDeserialize();
            node.right = preorderDeserialize();
            return node;
        }
    }
    
    
    public static void main(String[] args) {
        TreeNode root = Generator.createTree();
        //root = null;
        //System.out.println(preorderSerialize(root));
        //System.out.println(preorderSerialize(preorderDeserialize(preorderSerialize(root))));
        System.out.println(levelorderSerialize(root));
        System.out.println(levelorderSerialize(levelorderDeserialize(levelorderSerialize(root))));
    }
}
