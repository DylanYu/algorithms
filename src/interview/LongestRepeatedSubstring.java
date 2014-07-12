package interview;

import algs.RadixSort;

/**
 * 
 * @author Dongliang Yu
 *
 */
public class LongestRepeatedSubstring {
    public static String lrs(String s) {
        int length = s.length();
        String[] suffix = new String[length];
        for (int i = 0; i < length; i++)
            suffix[i] = s.substring(i);
        RadixSort.quick3Way(suffix);
        int max = 0;
        int max_i = -1;
        for (int i = 0; i < length - 1; i++) {
            int l = lcp(suffix[i], suffix[i + 1]);
            if (l > max) {
                max = l;
                max_i = i;
            }
        }
        if (max_i != -1)
            return suffix[max_i].substring(0, max);
        else
            return "";
    }
    
    private static int lcp(String a, String b) {
        int l1 = a.length();
        int l2 = b.length();
        int l = (l1 < l2) ? l1 : l2;
        for (int i = 0; i < l; i++) {
            if (a.charAt(i) != b.charAt(i)) return i;
        }
        return l;
    }
    
    public static void main(String[] args) {
        String s = "aacaagtttacaagc";
        System.out.println(lrs(s));
    }
}
