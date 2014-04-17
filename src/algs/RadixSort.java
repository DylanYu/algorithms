package algs;

public class RadixSort {
    private static int R = 256;

    /**
     * ASCII char 
     */
    public static void countingSort(char[] a) {
        int length = a.length;
        int[] count = new int[R + 1];
        for (int i = 0; i < length; i++)
            count[a[i] + 1]++;
        for (int i = 0; i < R; i++)
            count[i + 1] += count[i];
        char[] aux = new char[length];
        for (int i = 0; i < length; i++)
            aux[count[a[i]]++] = a[i]; // stable
        for (int i = 0; i < length; i++)
            a[i] = aux[i];
    }
    
    public static void LSD(String[] a) {
        int length = a.length;
        int W = 0;
        for (int i = 0; i < length; i++)
            if (a[i].length() > W)
                W = a[i].length();
        int[] count = new int[R + 2]; // extra count for no character situation
        String[] aux = new String[length];
        for (int index = W - 1; index >= 0; index--) {
            for (int i = 0; i < R + 2; i++)
                count[i] = 0;
            for (int i = 0; i < length; i++)
                count[charAt(a[i], index) + 2]++;
            for (int i = 0; i < R + 1; i++)
                count[i + 1] += count[i];
            for (int i = 0; i < length; i++)
                aux[count[charAt(a[i], index) + 1]++] = a[i];
            for (int i = 0; i < length; i++)
                a[i] = aux[i];
        }
    }
    
    private static int charAt(String s, int index) {
        try {
            return s.charAt(index);
        } catch (StringIndexOutOfBoundsException e) {
            return -1;
        }
    }
    
    public static void main(String[] args) {
        char[] carr = {'h', 'a', 'i', 'q', 'p', '0', 'g', 'q', 'p', 'a', 'd', 'm', 'e', 'q'};
        countingSort(carr);
        for (char e : carr)
            System.out.print(e + " ");
        System.out.println();
        String[] sarr = {"fuwr", "1232", "asdrfr12", "amvi", "ghjj", "123", "bois", "asdrf", "askj", "mkjq", "ghje"};
        LSD(sarr);
        for (String e : sarr)
            System.out.println(e);
    }
}
