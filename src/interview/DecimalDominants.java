package interview;

import java.util.ArrayList;

import algs.QuickSort;

/**
 * Decimal dominants.
 * <p>
 * Given an array with N keys, design an algorithm to find all values that 
 * occur MORE than N/10 times. The expected running time of your algorithm 
 * should be linear.
 * 
 * @author Dongliang Yu
 *
 */
public class DecimalDominants {
    
    public static double[] getDominants(double[] a) {
        int N = a.length;
        Double[] A = new Double[N];
        for (int i = 0; i < N; i++)
            A[i] = a[i];
        int domiFact = N / 10;
        if (domiFact == 0) {
            return a;
        }
        ArrayList<Double> result = new ArrayList<Double>();
        Double prev = a[0];
        for (int i = 1; i < 10; i++) {
            Double now = (Double)QuickSort.select(A, i * domiFact);
            System.out.println(now);
            if (now.equals(prev)) {
                if (result.size() == 0 || 
                        !now.equals(result.get(result.size() - 1)))
                    result.add(now);
            }
            prev = now;
        }
        // edge case
        if (N % 10 == 0) {
            prev = (Double)QuickSort.select(A, N - 1 - domiFact);
            Double now = (Double)QuickSort.select(A, N - 1);
            if (now.equals(prev))
                result.add(now);
        }
        double[] re = new double[result.size()];
        for (int i = 0; i < result.size(); i++)
            re[i] = result.get(i);
        return re;
    }

}
