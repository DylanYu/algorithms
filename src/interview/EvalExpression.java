package interview;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Evaluate arithmetic expression including:
 *  1. postfix notation (reverse polish notation)
 *  2. infix notation without parentheses
 *  3. infix notation with parentheses
 * 
 * @author Dongliang Yu
 *
 */
public class EvalExpression {
    // evaluate arithmetic expression with parentheses
    public int evalArithmeticWithParentheses(String[] tokens) {
        String[] postfix = infixToPostfix(tokens);
        return evalRPN(postfix);
    }
    
    // transfer a infix expression (1 + 2) / 3 - 5 to postfix expression 1 2 + 3 / 5 -
    // refer to http://www.cs.wcupa.edu/rkline/DS/deque-stack-algorithms.html
    public String[] infixToPostfix(String[] tokens) {
        List<String> ret = new LinkedList<String>();
        Stack<String> ops = new Stack<String>();
        for (int i = 0; i < tokens.length; i++) {
            String curr = tokens[i];
            if (isNum(curr)) {
                ret.add(curr);
            } else {
                if (curr.equals("(")) {
                    ops.push(curr);
                } else if (curr.equals(")")) {
                    while (!ops.peek().equals("("))
                        ret.add(ops.pop());
                    ops.pop(); // pop (
                } else if (ops.isEmpty() || ops.peek().equals("(")) {
                    ops.push(curr);
                } else if (isMulOrDiv(curr)) { // * or /
                    while (!ops.isEmpty() && isMulOrDiv(ops.peek())) // pop all * and / (higher or equals than * and /)
                        ret.add(ops.pop());
                    ops.push(curr);
                } else if (isAddOrMinus(curr)) { // + or /
                    while (!ops.isEmpty() && isOp(ops.peek())) // pop all ops (higher or equals than + and -)
                        ret.add(ops.pop());
                    ops.push(curr);
                }
            }
        }
        while (!ops.isEmpty())
            ret.add(ops.pop());
        String[] result = new String[ret.size()];
        int i = 0;
        for (String e : ret)
            result[i++] = e; 
        return result;
    }
    
    /*************************************/
    
    // evaluate expressions without parentheses like 1 + 2 / 3 - 5 * 2 / 2 + 3 - 2
    // the Queue here is actually a Stack
    public int evalArithmetic(String[] tokens) {
        LinkedList<String> queue = new LinkedList<String>();
        int i = 0;
        while (i < tokens.length) {
            String curr = tokens[i];
            if (isNum(curr)) {
                queue.offer(curr);
                i++;
            } else {
                if (isAddOrMinus(curr)) {
                    queue.offer(curr);
                    i++;
                } else {
                    if (i+1 >= tokens.length || queue.isEmpty())
                        return Integer.MAX_VALUE; // error
                    String first = queue.removeLast();
                    String second = tokens[i+1]; // may error (not a operand but a operator)
                    queue.offer(evaluateStr(first, curr, second));
                    i += 2;
                }
            }
        }
        while (queue.size() > 1)
            queue.addFirst(evaluateStr(queue.remove(), queue.remove(), queue.remove()));
        return Integer.parseInt(queue.remove());
    }
    
    private String evaluateStr(String first, String op, String second) {
        return evaluate(Integer.parseInt(first), op, Integer.parseInt(second)) + "";
    }
    
    private boolean isNum(String s) {
        return !isOp(s) && !s.equals("(") && !s.equals(")");
    }
    
    private boolean isOp(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
    
    private boolean isAddOrMinus(String s) {
        return s.equals("+") || s.equals("-");
    }
    
    private boolean isMulOrDiv(String s) {
        return !isNum(s) && !isAddOrMinus(s);
    }
    
    
    /***************************************/
    
    // ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
    // Reverse Polish Notation is also called Postfix Notation
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            String curr = tokens[i];
            if (!isNum(curr)) {
                if (stk.isEmpty()) return -1;
                int second = stk.pop();
                if (stk.isEmpty())  return -1;
                int first = stk.pop();
                stk.push(evaluate(first, curr, second));
            } else {
                stk.push(Integer.parseInt(curr));
            }
        }
        if (stk.size() != 1) return -1;
        return stk.pop();
    }
    
    private int evaluate(int first, String op, int second) {
        if (op.equals("+")) return first + second;
        if (op.equals("-")) return first - second;
        if (op.equals("*")) return first * second;
        else {
            if (second == 0) return 0;
            return first / second;
        }
    }
    
    public static void main(String[] args) {
        String[] RPNTokens = {"2", "1", "+", "3", "*"};
        System.out.println(new EvalExpression().evalRPN(RPNTokens));
        // 1 + 2 * 5 / 3 - 4 * 4 / 2 + 3 - 2
        String[] tokens = {"1", "+", "2", "*", "5", "/", "3", "-", "4", "*", "4", "/", "2", "+", "3", "-", "2"};
        System.out.println(new EvalExpression().evalArithmetic(tokens));
        // (3 - 1) + (2 - (13 / 3 - 2) * 2) * 3 - 2
        String[] tokensWithParentheses = {"(", "3", "-", "1", ")", "+", "(", "2", "-", "(", "13", "/", "3", "-", "2", ")", "*", "2", ")", "*", "3", "-", "2"};
        String[] postfix = new EvalExpression().infixToPostfix(tokensWithParentheses);
        for (String e : postfix) System.out.print(e + " ");
        System.out.println();
        System.out.println(new EvalExpression().evalArithmeticWithParentheses(tokensWithParentheses));
    }
}
