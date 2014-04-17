package algs;

/**
 * 
 * @author Dongliang Yu
 *
 */
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
    
    public static void main(String[] args) {
        char[] a = {'h', 'a', 'i', 'q', 'p', 'b', 'g', 'q', 'p', 'a', 'd', 'm', 'e', 'q'};
        countingSort(a);
        for (char e : a)
            System.out.print(e + " ");
    }
}
