package interview;

public class Fibonacci {
    public static int fibNoRecursion(int n) {
        if (n == 0 || n == 1) return 1;
        int a = 1;
        int b = 1;
        int i = 1;
        while (i < n) {
            int tmp = b;
            b += a;
            a = tmp;
            i++;
        }
        return b;
    }
    
    public static int fibonacci(int n) {
        if (n == 0 || n == 1) return 1;
        else return fibonacci(n-1) + fibonacci(n-2);
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(fibNoRecursion(i) + ", " + fibonacci(i));
        }
    }
}
