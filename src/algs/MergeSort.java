package algs;

/**
 * 
 * @author Dongliang Yu
 *
 */
public class MergeSort{

//    public static void sort(Comparable[] a) {
//        Comparable[] aux = new Comparable[a.length];
//        merge(a, aux, 0, a.length - 1);
//    }
    
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (lo >= hi)
            return;
        int mid = (lo + hi) / 2;
        merge(a, aux, lo, mid);
        merge(a, aux, mid + 1, hi);
        // copy
        for (int i = lo; i <= hi; i++)
            aux[i] = a[i];
        int i = lo;
        int j = lo;
        int k = mid + 1;
        while(j <= mid && k <= hi) {
            if (less(aux[j], aux[k]))
                a[i++] = aux[j++];
            else
                a[i++] = aux[k++];
        }
        if (j > mid) {
            while (k <= hi)
                a[i++] = aux[k++];
        }
        else {
            while(j <= mid)
                a[i++] = aux[j++];
        }
    }
    
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }
    
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (lo >= hi)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
//        merge_(a, aux, lo, mid, hi);
    }
    
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <=hi; k++) {
            if (i > mid)                a[k] = aux[j++];
            else if (j > hi)            a[k] = aux[i++];
            else if (less(aux[j], aux[i]))  a[k] = aux[j++]; // stability
            else                        a[k] = aux[i++];
        }
    }
    
    private static void merge_(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        int i = lo;
        int j = mid + 1;
        int k = lo;
        while (i <= mid && j <= hi) {
            if (less(aux[i], aux[j]))
                a[k++] = aux[i++];
            else
                a[k++] = aux[j++];
        }
        if (i > mid) {
            while (j <= hi)
                a[k++] = aux[j++];
        } else {
            while (i <= mid)
                a[k++] = aux[i++];
        }
    }
    
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    
    private static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++)
            if (a[i].compareTo(a[i + 1]) > 0)
                return false;
        return true;
    }
    
    public static void show(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

}
