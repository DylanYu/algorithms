package algs;

/**
 * 
 * @author Dongliang Yu
 *
 */
public class QuickSort {
    
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }
    
    public static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int index = partition(a, lo, hi);
        sort(a, lo, index - 1);
        sort(a, index + 1, hi);
    }
    
    private static int partition(Comparable[] a, int lo, int hi) {
        if (hi >= lo)
            return lo;
        int p = selectMedianPivot(a, lo, hi);
        Comparable pivot = a[p];
        exch(a, lo, p);
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (less(a[++i], pivot))
                if (i == hi)
                    break;
            while (less(pivot, a[--j]))
                if (j == lo)
                    break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
    
//    private static int partition(Comparable[] a, int lo, int hi) {
//        int p = selectMedianPivot(a, lo, hi);
//        Comparable pivot = a[p];
//        exch(a, lo, p);
//        int l = lo + 1;
//        int r = hi;
//        while (l <= r) {
//            if (less(a[l], pivot))
//                l++;
//            else
//                exch(a, l, r--);
//        }
//        exch(a, lo, r);
//        return r;
//    }

    private static int selectMedianPivot(Comparable[] a, int lo, int hi) {
        int p = -1;
        int mid = lo + (hi - lo) / 2;
        if (less(a[lo], a[mid])) {
            if (less(a[mid], a[hi]))
                p = mid;
            else if (less(a[lo], a[hi]))
                p = hi;
            else
                p = lo;
        }
        else {
            if (less(a[lo], a[hi]))
                p = lo;
            else if (less(a[mid], a[hi]))
                p = hi;
            else
                p = mid;
        }
        return p;
    }
    
    public static Comparable select(Comparable[] a, int k) {
        int lo = 0;
        int hi = a.length - 1;
        if (k < lo || k > hi)
            return null;
        int i = partition(a, lo, hi);
        while (i != k) {
            if (k < i)
                i = partition(a, lo, i - 1);
            else if (k > i)
                i = partition(a, i + 1, hi);
        }
        return a[i];
    }
    
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    
    private static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    public static void show(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
    
}
