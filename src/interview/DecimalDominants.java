package interview;

import algs.QuickSort;

/**
 * Decimal dominants.
 * <p>
 * Given an array with N keys, design an algorithm to find all values that 
 * occur MORE than N/10 times. The expected running time of your algorithm 
 * should be linear.
 * <p>
 * Note: You should not use hash table (or, dictionary) to count.
 * <p>
 * Hint: determine the (N/10)th largest key using quickselect and check if 
 * it occurs more than N/10 times.
 * Alternate solution hint: use 9 counters.
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
        if (domiFact <= 0) {
            return a;
        }
        double[] result = new double[9];
        int numOfResult = 0;
        double prevPivot = -1;
        for (int pivotIndex = domiFact; pivotIndex < N; pivotIndex += domiFact) {
            double pivot = (Double) QuickSort.select(A, pivotIndex);;
            if (pivotIndex > domiFact) {
                if (pivot == prevPivot)
                    continue;
            }
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (a[i] == pivot)
                    count++;
            }
            if (count > domiFact)
                result[numOfResult++] = pivot;
            prevPivot = pivot;
        }
        if (numOfResult < 9) {
            double[] realResult = new double[numOfResult];
            for (int i = 0; i < numOfResult; i++)
                realResult[i] = result[i];
            return realResult;
        } else
            return result;
    }

}
