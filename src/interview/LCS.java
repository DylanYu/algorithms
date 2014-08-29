package interview;

/**
 * Longest common substring
 * 
 * @author Dongliang Yu
 *
 */
public class LCS {
    // DP, O(m*n) space
    public static int LongestCommonSubstring(String s1, String s2) {
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
    public static int LongestCommonSubstring0(String s1, String s2) {
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
    
    public static void main(String[] args) {
        String s1 = "abcdefgggggggg";
        String s2 = "bcdefaaaaabcdefgkkk";
        System.out.println(LongestCommonSubstring0(s1, s2));
    }
}
