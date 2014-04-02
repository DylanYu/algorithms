package test.util;

import java.util.Random;

public class Generator {

    public static int[] createIntArray(int n) {
        return createIntArray(n, 1);
    }
    
    public static int[] createIntArray(int n, double factor) {
        Random rand = new Random(System.currentTimeMillis());
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = rand.nextInt((int)(n * factor));
        return a;
    }
    
    public static double[] createDoubleArray(int n) {
        Random rand = new Random(System.currentTimeMillis());
        double[] a = new double[n];
        for (int i = 0; i < n; i++)
            a[i] = rand.nextDouble() * n;
        return a;
    }
    
    public static Double[] createDoubleObjectArray(int n) {
        Random rand = new Random(System.currentTimeMillis());
        Double[] a = new Double[n];
        for (int i = 0; i < n; i++)
            a[i] = rand.nextDouble() * n;
        return a;
    }
}
