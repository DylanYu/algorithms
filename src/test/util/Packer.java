package test.util;

public class Packer {

    public static Double[] pack(double[] a) {
        Double[] result = new Double[a.length];
        for (int i = 0; i < a.length; i++)
            result[i] = a[i];
        return result;
    }
}
