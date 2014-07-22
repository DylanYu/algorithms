package algs;

import java.util.ArrayList;

public class WIS {
    public static int maxWIS(int[] v) {
        int[] A = new int[v.length + 1];
        for (int i = 0; i < A.length; i++)
            A[i] = 0;
        return dp(A, v, A.length - 1);
    }

    private static int dp(int[] A, int[] v, int i) {
        if (i == 0 || i == -1) {
            return 0;
        } else if (A[i] == 0) {
            A[i] = Math.max(dp(A, v, i - 2) + v[i - 1], dp(A, v, i - 1));
            return A[i];
        } else {
            return A[i];
        }
    }

    public static int bfMaxWIS(int[] v) {
        return -1;
    }

    public static void main(String[] args) {
        // int[] v = {1, 4, 5, 4};
        int[] v = { 5, 7, 5, 1, 2, 6 };
        // int[] v = {1, 7, 3, 8, 16, 17, 8, 14, 22};
        System.out.println(maxWIS(v) == bfMaxWIS(v));
    }
}
