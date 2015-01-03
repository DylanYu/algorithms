package interview;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '[', ']', '{' and 
 * '}', find the maximum length of valid parentheses
 * 
 * @author Dongliang Yu
 *
 */
public class LongestValidParenthesesII {
    public static int longestValidParentheses(String s) {
        char[] c = s.toCharArray();
        Stack<Integer> stk = new Stack<Integer>();
        int maxLen = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(' || c[i] == '[' || c[i] == '{')
                stk.push(i);
            else {
                if (stk.isEmpty() || !match(c[stk.peek()], c[i]))
                    stk.push(i);
                else {
                    stk.pop();
                    int lastPos = stk.isEmpty() ? -1 : stk.peek();
                    maxLen = Math.max(maxLen, i - lastPos);
                }
            }
        }
        return maxLen;
    }
    
    private static boolean match(char a, char b) {
        return a == '(' && b == ')'
                || a == '[' && b == ']'
                || a == '{' && b == '}';
    }
    
    public static void main(String[] args) {
        //String s = "([]){}"; // 6
        //String s = "([)]{}"; // 2
        String s = "[](){}"; // 6
        System.out.println(longestValidParentheses(s));
    }
}
