package test.util;

public class Displayer {

    public static void show(double[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i < a.length - 1)
                System.out.print(",");
        }
        System.out.println();
    }
}
