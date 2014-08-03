package interview;

import java.util.ArrayList;
import java.util.List;

public class LastPermutation {
    public static int largestSmaller(int number) {
        List<Integer> digits = new ArrayList<Integer>();
        while (number > 0) {
            int digit = number % 10;
            digits.add(digit);
            number /= 10;
        }
        int[] num = new int[digits.size()];
        for (int i = 0; i < digits.size(); i++)
            num[i] = digits.get(digits.size()-1-i);
        lastPermutation(num);
        int rst = 0;
        for (int i = 0; i < num.length; i++)
           rst =  rst * 10 + num[i];
       return rst;
    }
    
    public static void lastPermutation(int[] digits) {
        int len = digits.length;
        int i = 0;
        for (i = len-2; i >= 0; i--)
            if (digits[i] > digits[i+1]) break;
        if (i == -1) {
            reverse(digits, 0, len-1);
            return;
        }
        int j = i+1;
        for (; j < len; j++)
            if (digits[j] >= digits[i]) break;
        j--;
        swap(digits, i, j);
        reverse(digits, i+1, len-1);
    }
    
    private static void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
    
    // [lo, hi]
    private static void reverse(int[] num, int lo, int hi) {
        if (lo > hi || lo < 0 || hi >= num.length) return;
        int i = lo;
        int j = hi;
        while (i < j)
            swap(num, i++, j--);
    }
    
    public static void main(String[] args) {
        System.out.println(largestSmaller(1234));
        System.out.println(largestSmaller(4));
        System.out.println(largestSmaller(10));
        System.out.println(largestSmaller(1324));
        System.out.println(largestSmaller(54627359));
    }
}
