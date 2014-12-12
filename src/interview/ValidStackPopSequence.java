package interview;

import java.util.Stack;

/**
 * 
 * @author Dongliang Yu
 *
 */
public class ValidStackPopSequence {
    public static boolean isValid(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) return false;
        if (len1 == 0) return len2 == 0;
        if (len2 == 0) return len1 == 0;
        Stack<Character> stk = new Stack<Character>();
        int i = 0;
        int j = 0;
        while (j < len2) {
            if (stk.isEmpty() || stk.peek() != s2.charAt(j)) {
                if (i >= len1) return false;
                stk.push(s1.charAt(i));
                i++;
            } else {
                stk.pop();
                j++;
            }
        }
        return stk.isEmpty() && i == len1 && j == len2;
    }
    
    public static void main(String[] args) {
        String s1 = "0123456789";
        String s2 = "1023476598"; // true
        //String s2 = "0213469875"; // true
        //String s2 = "3246187950"; // false
        //String s2 = "4321056789"; // true
        //String s2 = "1240356879"; // false
        System.out.println(isValid(s1, s2));
    }
}
