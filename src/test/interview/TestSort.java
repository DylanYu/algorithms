package test.interview;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import algs.InsersionSort;
import algs.MergeSort;
import algs.Quick3Way;
import algs.QuickSort;
import algs.SelectionSort;
import algs.ShellSort;
import algs.Stopwatch;

/**
 * Note: Java uses quicksort for primitive types but mergesort for objects.
 * Here's an explanation from stackoverflow:
 * <p>
 * The most likely reason is that quicksort is not stable, i.e. equal entries 
 * can change their relative position during the sort; among other things, 
 * this means that if you sort an already sorted array, it may not stay 
 * unchanged.
 * <p>
 * Since primitive types have no identity (there is no way to distinguish two 
 * ints with the same value), this does not matter for them. But for reference 
 * types, it could cause problems for some applications. Therefore, a stable 
 * merge sort is used for those.
 * <p>
 * On the other head, a reason not to use the (guaranteed n*log(n)) merge sort 
 * for primitive types might be that it requires making a clone of the array. 
 * For reference types, where the referred objects usually take up far more 
 * memory than the array of references, this generally does not matter. But 
 * for primitive types, cloning the array outright doubles the memory usage.
 * 
 * @author Dongliang Yu
 * 
 */
public class TestSort {

    private Double[] a = null;

    private Double[] createArray(int N) {
        Random rand = new Random(System.currentTimeMillis());
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++)
            a[i] = (double) rand.nextInt();
        return a;
    }

    private boolean check(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N - 1; i++)
            if (a[i].compareTo(a[i + 1]) > 0)
                return false;
        return true;
    }

    @Before
    public void init() {
        a = createArray(10);
    }

    @Test
    public void testSelectionSort() {
        SelectionSort.sort(a);
        assertEquals(true, check(a));
    }

    @Test
    public void testInsersionSort() {
        InsersionSort.sort(a);
        assertEquals(true, check(a));
    }

    @Test
    public void testShellSort() {
        ShellSort.sort(a);
        assertEquals(true, check(a));
    }
    
    @Test
    public void testMergeSort() {
        MergeSort.sort(a);
        assertEquals(true, check(a));
    }
    
    @Test
    public void testQuickSort() {
        QuickSort.sort(a);
        assertEquals(true, check(a));
    }

    @Test
    public void testSelect() {
        Comparable[] b = a.clone();
        QuickSort.sort(b);
        assertEquals(QuickSort.select(a.clone(), 1), b[1]);
        assertEquals(QuickSort.select(a.clone(), 2), b[2]);
        assertEquals(QuickSort.select(a.clone(), 4), b[4]);
        assertEquals(QuickSort.select(a.clone(), 6), b[6]);
        assertEquals(QuickSort.select(a.clone(), 9), b[9]);
    }

    @Test
    public void testQuick3WaySort() {
        Quick3Way.sort(a);
        assertEquals(true, check(a));
    }
    
    @Test
    public void testTime() {
        for (int N = 1000; N <= 10000000; N *= 10) {
            System.out.println("N is " + N);
            Double[] a = createArray(N);

            Double[] d = a.clone();
            Stopwatch watch = new Stopwatch();
//            SelectionSort.sort(d);
//            System.out.println("Selection Sort: " + watch.elapsedTime());
//
//            d = a.clone();
//            watch = new Stopwatch();
//            InsersionSort.sort(d);
//            System.out.println("Insersion Sort: " + watch.elapsedTime());
//
//            d = a.clone();
//            watch = new Stopwatch();
//            ShellSort.sort(d);
//            System.out.println("Shell Sort: " + watch.elapsedTime());
//            
            d = a.clone();
            watch = new Stopwatch();
            MergeSort.sort(d);
            System.out.println("Merge Sort: " + watch.elapsedTime());
            
            d = a.clone();
            watch = new Stopwatch();
            QuickSort.sort(d);
            System.out.println("Quick Sort: " + watch.elapsedTime());
            
            d = a.clone();
            watch = new Stopwatch();
            Quick3Way.sort(d);
            System.out.println("Quick3Way Sort: " + watch.elapsedTime());
        }
    }

}
