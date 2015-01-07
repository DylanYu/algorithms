package interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Problem: given a list of edges of a tree: [child, parent], construct the 
 * tree. Here's a sample input in Python nested list syntax: 
 * [[0, 2], [3, 0], [1, 4], [2, 4]].
 * 
 * Here's a sample print of a tree data structure:
 * 
 * 4
 *  1
 *  2
 *   0
 *    3
 * 
 * @author Dongliang Yu
 *
 */
public class PrintTreeWithGivenEdge {
    static class Pair {
        int child;
        int parent;
        public Pair(int a, int b) { child = a; parent = b; }
    }
    
    public static void print(Pair[] pairs) {
        if (pairs == null || pairs.length == 0)
            return;
        int root = getRoot(pairs);
        Map<Integer, List<Integer>> tree = createTree(pairs);
        printNode(tree, root, 0);
    }
    
    private static int getRoot(Pair[] pairs) {
        Set<Integer> set = new HashSet<Integer>();
        for (Pair p : pairs)
            set.add(p.parent);
        for (Pair p : pairs)
            if (set.contains(p.child))
                set.remove(p.child);
        //if (set.size() > 1) throw new Exception("more than one root")
        return set.iterator().next();
    }
    
    private static Map<Integer, List<Integer>> createTree(Pair[] pairs) {
        Map<Integer, List<Integer>> tree = new HashMap<Integer, List<Integer>>();
        for (Pair p : pairs) {
            if (!tree.containsKey(p.parent))
                tree.put(p.parent, new LinkedList<Integer>());
            if (!tree.containsKey(p.child))
                tree.put(p.child, new LinkedList<Integer>());
            tree.get(p.parent).add(p.child);
        }
        return tree;
    }
    
    private static void printNode(Map<Integer, List<Integer>> tree, int node, int level) {
        if (!tree.containsKey(node))
            return;
        for (int i = 0; i < level; i++)
            System.out.print("  ");
        System.out.println(node);
        List<Integer> children = tree.get(node);
        for (int child : children)
            printNode(tree, child, level+1);
    }
    
    /*
    0
    1    2    3
    4 5      6 7 
    
    0
     1
       4
       5
     2
     3
       6
       7
    */
     
    public static void main(String[] args) {
        Pair p1 = new Pair(1, 0);
        Pair p2 = new Pair(2, 0);
        Pair p3 = new Pair(3, 0);
        Pair p4 = new Pair(4, 1);
        Pair p5 = new Pair(5, 1);
        Pair p6 = new Pair(6, 3);
        Pair p7 = new Pair(7, 3);
        Pair[] pairs = new Pair[7];
        pairs[0] = p1;
        pairs[1] = p2;
        pairs[2] = p3;
        pairs[3] = p4;
        pairs[4] = p5;
        pairs[5] = p6;
        pairs[6] = p7;
        print(pairs);
    }
}
