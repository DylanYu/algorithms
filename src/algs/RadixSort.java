package algs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Dongliang Yu
 *
 */
public class RadixSort {
    /* only ASCII characters */ 
    private static int R = 256;

    public static void countingSort(char[] a) {
        int length = a.length;
        int[] count = new int[R + 1];
        for (int i = 0; i < length; i++)
            count[a[i] + 1]++;
        for (int i = 0; i < R; i++)
            count[i + 1] += count[i];
        char[] aux = new char[length];
        for (int i = 0; i < length; i++)
            aux[count[a[i]]++] = a[i]; // stable
        for (int i = 0; i < length; i++)
            a[i] = aux[i];
    }
    
    public static void LSD(String[] a) {
        int length = a.length;
        int W = 0;
        for (int i = 0; i < length; i++)
            if (a[i].length() > W)
                W = a[i].length();
        int[] count = new int[R + 2]; // extra count for no character situation
        String[] aux = new String[length];
        for (int index = W - 1; index >= 0; index--) {
            for (int i = 0; i < R + 2; i++)
                count[i] = 0;
            for (int i = 0; i < length; i++)
                count[charAt(a[i], index) + 2]++;
            for (int i = 0; i < R + 1; i++)
                count[i + 1] += count[i];
            for (int i = 0; i < length; i++)
                aux[count[charAt(a[i], index) + 1]++] = a[i];
            for (int i = 0; i < length; i++)
                a[i] = aux[i];
        }
    }
    
    public static void MSD(String[] a) {
        int length = a.length;
        String[] aux = new String[length];
        sort(a, aux, 0, length - 1, 0);
    }
    
    private static void sort(String[] a, String[] aux, int start, int end, int index) {
        if (end <= start)
            return;
        int[] count = new int[R + 2];
        for (int i = start; i <= end; i++)
            count[charAt(a[i], index) + 2]++;
        for (int r = 0; r < R + 1; r++)
            count[r + 1] += count[r];
        for (int i = start; i <= end; i++)
            aux[count[charAt(a[i], index) + 1]++] = a[i];
        for (int i = start; i <= end; i++)
            a[i] = aux[i - start];
        for (int r = 0; r < R; r++)
            sort(a, aux, start + count[r], start + count[r + 1] - 1, index + 1);
    }
    
    private static int charAt(String s, int index) {
        try {
            return s.charAt(index);
        } catch (StringIndexOutOfBoundsException e) {
            return -1;
        }
    }
    
    public static void quick3Way(String[] a) {
        sort3Way(a, 0, a.length - 1, 0);
    }
    
    private static void sort3Way(String[] a, int start, int end, int index) {
        if (start >= end || start < 0 || end >= a.length)
            return;
        int m = chooseMiddle(a, start, end, index);
        swap(a, start, m);
        int pivot = charAt(a[start], index);
        int lt = start;
        int gt = end;
        int i = start + 1;
        while (i <= gt) {   // equals test is necessary here
            int t = charAt(a[i], index);
            if (t < pivot)      swap(a, lt++, i++);
            else if (t > pivot) swap(a, i, gt--);
            else i++;
        }
        sort3Way(a, start, lt - 1, index);
        if (pivot >= 0) sort3Way(a, lt, gt, index + 1); // stop further recursion 
        sort3Way(a, gt + 1, end, index);
    }
    
    private static int chooseMiddle(String[] a, int lo, int hi, int index) {
        int left = charAt(a[lo], index);
        int mid_i = lo + (hi - lo) / 2; // do not use (lo + hi) / 2 to avoid integer overflow
        int middle = charAt(a[mid_i], index);
        int right = charAt(a[hi], index);
        if (left < middle) {
            if (middle < right) return mid_i;
            else if (left < right) return hi;
            else return lo;
        } else {
            if (middle > right) return mid_i;
            else if (left > right) return hi;
            else return lo;
        }
    }
    
    private static void swap(String[] s, int a, int b) {
        String tmp = s[a];
        s[a] = s[b];
        s[b] = tmp;
    }
    
    public static void main(String[] args) {
        char[] carr = {'h', 'a', 'i', 'q', 'p', '0', 'g', 'q', 'p', 'a', 'd', 'm', 'e', 'q'};
        countingSort(carr);
        for (char e : carr)
            System.out.print(e + " ");
        System.out.println();
        String[] sarr = {"seashells", "sells", "are", "by", "sea", "seashells", "sells", "she", 
                "she", "shells", "shore", "surely", "the", "the"};
        List<String> list = Arrays.asList(sarr);
        Collections.shuffle(list);
        sarr = (String[]) list.toArray();
        //LSD(sarr);
        //MSD(sarr);
        quick3Way(sarr);
        for (String e : sarr)
            System.out.println(e);
    }
}
