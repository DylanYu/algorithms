package algs;

/**
 * 
 * @author Dongliang Yu
 *
 */
public class Quick3Way {
    
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }
    
    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int p = selectMedianPivot(a, lo, hi);
        Comparable pivot = a[p];
        int lt = lo;
        int gt = hi;
        int i = lo;
        while (i <= gt) {
            int cmp = a[i].compareTo(pivot);
            if (cmp < 0)
                exch(a, lt++, i++);
            else if (cmp > 0)
                exch(a, i, gt--);
            else
                i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

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
    
//    public static Comparable select(Comparable[] a, int k) {
//        int lo = 0;
//        int hi = a.length - 1;
//        if (k < lo || k > hi)
//            return null;
//        int i = partition(a, lo, hi);
//        while (i != k) {
//            if (k < i)
//                i = partition(a, lo, i - 1);
//            else if (k > i)
//                i = partition(a, i + 1, hi);
//        }
//        return a[i];
//    }
    
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    
    private static boolean equal(Comparable v, Comparable w) {
        return v.compareTo(w) == 0;
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
