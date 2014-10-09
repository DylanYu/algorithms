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
        int[] A = {9, 8, 7, 2, 1, 3, 6, 5, 4, 10, 0, -1};
        System.out.println(findLocalMinimum(A));
    }
}
