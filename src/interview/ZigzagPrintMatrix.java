package interview;

public class ZigzagPrintMatrix {
    public static void zigZagPrintMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return;
        int n = matrix[0].length;
        if (n == 0)
            return;
        System.out.print(matrix[0][0]);
        int x = 0;
        int y = 0;
        while (!(x == m - 1 && y == n - 1)) {
            if (x < m - 1) {
                x++;
            } else {
                y++;
            }
            while (x >= 0 && y < n) {
                System.out.print(matrix[x][y]);
                x--;
                y++;
            }
            if (x < 0 || y >= n) {
                x++;
                y--;
            }
            
            if (x == m-1 && y == n-1) break;
            
            if (y < n-1) {
                y++;
            } else {
                x++;
            }
            while (x < m && y >= 0) {
                System.out.print(matrix[x][y]);
                x++;
                y--;
            }
            if (x >= m || y < 0) {
                x--;
                y++;
            }
        };
    }
    
    public static void main(String[] args) {
        /*
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };*/
        /*int[][] matrix = {
                {1, 2, 3, 0},
                {4, 5, 6, 1},
                {7, 8, 9, 2}
        };*/
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {0, 1, 2}
        };
        zigZagPrintMatrix(matrix);
    }
}
