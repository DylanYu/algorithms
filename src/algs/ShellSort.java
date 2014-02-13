package algs;

/**
 * 
 * @author Dongliang Yu
 * 
 */
public class ShellSort {

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3)
            h = 3 * h + 1;
        while (h > 0) {
            for (int i = 0; i < N; i += h) {
                for (int j = i; j > 0; j -= h) {
                    if (less(a[j], a[j - h]))
                        exch(a, j, j - h);
                    else
                        break;
                }
            }
            h /= 3;
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

    public static void show(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

}
