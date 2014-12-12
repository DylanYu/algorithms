package interview;

public class LocalMinimum {
    public static int findLocalMinimum(int[] A) {
        if (A == null || A.length == 0) return 0; // exception
        return find(A, 0, A.length-1);
    }
    
    private static int find(int[] A, int i, int j) {
        if (i == j) return A[i];
        if (i == j-1) {
            if (A[i] < A[j]) return A[i];
            else return A[j];
        }
        int mid = i + (j-i)/2;
        int l = A[mid-1];
        int r = A[mid+1];
        if (A[mid] < l && A[mid] < r) return A[mid];
        if (l < A[mid]) return find(A, i, mid-1);
        else return find(A, mid+1, j);
    }
    
    public static void main(String[] args) {
        //int[] A = {9, 8, 7, 2, 1, 3, 6, 5, 4, 10, 0, -1};
        for (int i = 0; i < 10; i++) {
            int[] A = new int[12];
            for (int j = 0; j < A.length; j++)
                A[j] = (int) (Math.random() * Integer.MAX_VALUE);
            int min = findLocalMinimum(A);
            int j = 0;
            while (j < A.length) {
                if (A[j] == min) break;
                j++;
            }
            if (j == A.length) {
                System.out.println(false);
                continue;
            }
            if (j == 0 && A[0] < A[1] 
                || j == A.length-1 && A[A.length-1] < A[A.length-2]
                || A[j] < A[j+1] && A[j] < A[j-1])
                System.out.println(true);
            else
                System.out.println(false);
        }
    }
}
