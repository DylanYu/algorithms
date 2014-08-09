package interview;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Given a 2D board and a dictionary, find all the words exist in both the grid and dictionary.
 * (This question is a upgraded version of LeetCode question WordSearch.))
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" 
 * cells are those horizontally or vertically neighboring. The same letter cell may not be 
 * used more than once.
 *
 * For example,
 * Given board =
 *
 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 * ]
 * 
 * dictionary = ["ABCCED", "SEE", "ABCB"];
 * return ["ABCCED", "SEE"]
 * 
 * @author Dongliang Yu
 *
 */
public class WordSearchII {
    // This solution does not assume the dictionary provide isWordPrefix(string) API, which is extremely
    // important for an efficient search. For more information about efficient solution with a Tire data
    // structure, see http://coursera.cs.princeton.edu/algs4/assignments/boggle.html
    public static List<String> search(char[][] board, Set<String> set) {
        List<String> ret = new LinkedList<String>();
        if (set == null || set.size() == 0) return ret;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(board, i, j, "", set, visited, ret);
            }
        }
        return ret;
    }
    
    private static void search(char[][] board, int i, int j, String last, Set<String> set, boolean[][] visited, List<String> ret) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;
        if (visited[i][j]) return;
        char c = board[i][j];
        String cur = last + c;
        visited[i][j] = true;
        if (set.contains(cur)) ret.add(cur);
        search(board, i-1, j, cur, set, visited, ret);
        search(board, i+1, j, cur, set, visited, ret);
        search(board, i, j-1, cur, set, visited, ret);
        search(board, i, j+1, cur, set, visited, ret);
        visited[i][j] = false;
    }
    
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        char[][] board = {"ABCE".toCharArray(), "SFCS".toCharArray(), "ADEE".toCharArray()};
        set.add("ABCCED"); set.add("SEE"); set.add("ABCB");
        //char[][] board = {"aaaa".toCharArray(),"aaaa".toCharArray(),"aaaa".toCharArray()};
        //set.add("aaaaaaaaaaab");
        List<String> list = search(board, set);
        for (String s : list)
            System.out.println(s);
    }
}
