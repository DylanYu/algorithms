package interview;

/**
 * In mathematics, a combination is a way of selecting members from a grouping, such 
 * that (unlike permutations) the order of selection does not matter.
 * 
 * In this question, we should take care of overflow problem.
 * 
 * @author Dongliang Yu
 *
 */
public class Combination {
    public static int C(int m, int n) {
        if (m < n) return 0;
        if (m-n < n) n = m-n;
        int ret = 1;
        for (int i = 1; i <= n; i++) {
            int mul = m-i+1;
            int div = i;
            int gcd = gcd(mul, div);
            mul /= gcd;
            div /= gcd;
            ret /= div;
            ret *= mul;
        }
        return ret;
    }
    
    private static int gcd(int a, int b) {
        while (b > 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
    
    /*
     * Use double makes life easy.
     *
    public static int C(int m, int n) {
        if (m < n) return 0;
        if (m-n < n) n = m-n;
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= (m-i+1);
            result /= i;
        }
        return (int) result;
    }
    */
    
    public static void main(String[] args) {
        System.out.println(C(4, 2));
        System.out.println(C(30, 20));
    }
}
