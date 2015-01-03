package interview;

/**
 * Given an array of integers, sort the array into a wave like array, namely 
 * a1 >= a2 <= a3 >= a4 <= a5.....
 * 
 * @author Dongliang Yu
 *
 */
public class WiggleSort {
    // another solution is find the medium by quick select
    public static void wiggleSort(int[] num) {
        if (num[0] < num[1]) swap(num, 0, 1);
        //if (num.length <= 2) return;
        for (int i = 2; i < num.length; i++) {
            if (i % 2 == 0) {
                if (num[i] < num[i-1])
                    swap(num, i, i-1);
            } else {
                if (num[i] > num[i-1])
                    swap(num, i, i-1);
            }
        }
    }
    
    private static void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
    
    public static boolean isWiggle(int[] num) {
        for (int i = 1; i < num.length; i++) {
            if (i % 2 == 0) {
                if (num[i] < num[i-1]) return false;
            } else {
                if (num[i] > num[i-1]) return false; 
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        //int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //int[] num = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] num = new int[100];
        for (int i = 0; i < num.length; i++) {
            num[i] = (int) (Math.random() * 1000);
        }
        wiggleSort(num);
        for (int e : num)
            System.out.print(e + " ");
        System.out.println();
        System.out.println(isWiggle(num));
    }
}
