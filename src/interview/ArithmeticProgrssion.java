package interview;

import java.util.Scanner;

/**
 * Find the missing item from a arithmetic progression.
 * 
 * Input: 5 
 * 1 3 5 7 11 
 * Output: 9
 * 
 * 3 <= N <= 2500 
 * -10^6 <= e <= 10^6
 * 
 * Caveat: arithmetic progression could be increasing, decreasing and neither.
 * 
 * @author Dongliang Yu
 * 
 */
public class ArithmeticProgrssion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*int N = */scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int diff = b - a;
        // special equal case
        if (diff == 0) {
            System.out.print(a);
            return;
        }
        int prev = b;
        int now;
        while (scanner.hasNext()) {
            now = scanner.nextInt();
            int d = now - prev;
            if (d == diff) { // put dominate case first to intercept judgements
                prev = now;
            } else if (Math.abs(d) > Math.abs(diff)) {
                System.out.print(prev + diff);
                return;
            } else /*if (Math.abs(d) < Math.abs(diff))*/ {
                System.out.print(prev - d);
                return;
            }
        }
        // seems no missing item, just give next item.
        System.out.print(prev + diff);
    }
}
