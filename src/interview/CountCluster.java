package interview;

import java.util.LinkedList;
import java.util.Queue;

/**
 * In a matrix full of 0 and 1, count clusters constructed by adjacent 1s.
 * 
 * Implement both DFS and BFS.
 * 
 * @author Dongliang Yu
 *
 */
public class CountCluster {
    public static int count(int[][] matrix) {
        int count = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return count;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    count++;
                    //DFS(matrix, visited, i, j);
                    BFS(matrix, visited, i, j);
                }
            }
        }
        return count;
    }
    
    private static void DFS(int[][] matrix, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length)
            return;
        if (visited[i][j]) return;
        if (matrix[i][j] != 1) return;
        visited[i][j] = true;
        DFS(matrix, visited, i-1, j);
        DFS(matrix, visited, i+1, j);
        DFS(matrix, visited, i, j-1);
        DFS(matrix, visited, i, j+1);
    }
    
    static class Position {
        int x;
        int y;
        public Position(int i, int j) { x = i; y = j; }
    }
    
    private static void BFS(int[][] matrix, boolean[][] visited, int i, int j) {
        Queue<Position> queue = new LinkedList<Position>();
        queue.add(new Position(i, j));
        while (!queue.isEmpty()) {
            Position p = queue.poll();
            int x = p.x;
            int y = p.y;
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length)
                continue;
            if (matrix[x][y] != 1) continue;
            if (visited[x][y]) continue;
            visited[x][y] = true;
            queue.add(new Position(x-1, y));
            queue.add(new Position(x+1, y));
            queue.add(new Position(x, y-1));
            queue.add(new Position(x, y+1));
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 1, 1, 0},
                {0, 1, 1, 0, 1},
                {0, 0, 1, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 0, 1, 1, 0},
        };
        //int[][] matrix = {{0, 1}};
        System.out.println(count(matrix));
    }
}
