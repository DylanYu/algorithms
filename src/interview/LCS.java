package interview;

/**
 * Longest common substring and longest common subsequence
 * 
 * @author Dongliang Yu
 *
 */
public class LCS {
    public static String LongestCommonSubstring(String s1, String s2) {
        if (s1 == null || s2 == null) return null;
        int m = s1.length();
        int n = s2.length();
        if (m == 0 || n == 0) return "";
        
        int[][] A = new int[m+1][n+1];
        int maxLen = 0;
        int maxI = -1; // or maxJ will be OK
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    A[i][j] = A[i-1][j-1] + 1;
                //else
                //    A[i][j] = 0;
                if (A[i][j] > maxLen) {
                    maxLen = A[i][j];
                    maxI = i;
                }
            }
        }
        return s1.substring(maxI - maxLen, maxI);
    }
    
    // DP, O(m*n) space
    public static int LongestCommonSubstringLength(String s1, String s2) {
        if (s1 == null || s2 == null) return 0;
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 == 0 || len2 == 0) return 0;
        
        int[][] A = new int[len1+1][len2+1];
        int maxLen = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    A[i][j] = A[i-1][j-1] + 1;
                //else
                //    A[i][j] = 0;
                if (A[i][j] > maxLen) maxLen = A[i][j];
            }
        }
        return maxLen;
    }
    
    // DP, O(n) space
    public static int LongestCommonSubstringLength0(String s1, String s2) {
        if (s1 == null || s2 == null) return 0;
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 == 0 || len2 == 0) return 0;
        
        int[] A = new int[len2+1];
        int[] B = new int[len2+1];
        int maxLen = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    B[j] = A[j-1] + 1;
                else
                    B[j] = 0;
                if (B[j] > maxLen) maxLen = B[j];
            }
            int[] tmp = A;
            A = B;
            B = tmp;
        }
        return maxLen;
    }
    
    public static String LongestCommonSubsequence(String s1, String s2) {
        if (s1 == null || s2 == null) return null;
        int m = s1.length();
        int n = s2.length();
        if (m == 0 || n == 0) return "";
        int[][] A = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    A[i][j] = A[i-1][j-1] + 1;
                else
                    A[i][j] = Math.max(A[i][j-1], A[i-1][j]);
            }
        }
        return getLongestCommonSubsequence(A, s1, s2);
    }
    
    private static String getLongestCommonSubsequence(int[][] A, String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        StringBuffer sb = new StringBuffer();
        int i = m;
        int j = n;
        while (j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                sb.append(s2.charAt(j-1));
                i--;
                j--;
            } else {
                if (A[i][j-1] > A[i-1][j]) j--;
                else i--;
            }
        }
        return sb.reverse().toString();
    }
    
    public static int LongestCommonSubsequenceLength(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) return 0;
        int m = s1.length();
        int n = s2.length();
        int[][] A = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    A[i][j] = A[i-1][j-1] + 1;
                else
                    A[i][j] = Math.max(A[i][j-1], A[i-1][j]);
            }
        }
        return A[m][n];
    }
    
    public static void main(String[] args) {
        String s1 = "abcdefgggggggg";
        String s2 = "bcdefaaaaabcdefgkkk";
        //System.out.println(LongestCommonSubstringLength0(s1, s2));
        System.out.println(LongestCommonSubstring(s1, s2));
        
        s1 = "abcbdab";
        s2 = "bdcaba";
        //System.out.println(LongestCommonSubsequenceLength(s1, s2));
        System.out.println(LongestCommonSubsequence(s1, s2));
    }
}
