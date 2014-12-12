package interview;

/**
 * Given n numbers (both +ve and -ve), arranged in a circle, fnd the maximum sum of consecutive number.
 * 
 * Examples:
 * 
 * Input: a[] = {8, -8, 9, -9, 10, -11, 12}
 * Output: 22 (12 + 8 - 8 + 9 - 9 + 10)
 * 
 * Input: a[] = {10, -3, -4, 7, 6, 5, -4, -1} 
 * Output:  23 (7 + 6 + 5 - 4 -1 + 10) 
 * 
 * Input: a[] = {-1, 40, -14, 7, 6, 5, -4, -1}
 * Output: 52 (7 + 6 + 5 - 4 - 1 - 1 + 40)
 * 
 * @author Dongliang Yu
 * @see http://www.geeksforgeeks.org/maximum-contiguous-circular-sum/
 *
 */
public class MaximumCircularSubarraySum {
    public static int maximumCircularSubarray(int[] num) {
        if (num == null || num.length == 0) return Integer.MIN_VALUE;
        int maxNoCircle = maximumSubarray(num);
        int total = 0;
        for (int i = 0; i < num.length; i++) {
            total += num[i];
            //num[i] = -num[i];
        }
        //int minNoCircle = -maximumSubarray(num);
        int minNoCircle = minimumSubarray(num);
        int maxWithCircle = total - minNoCircle;
        return Math.max(maxNoCircle, maxWithCircle);
    }
    
    public static int maximumSubarray(int[] num) {
        if (num == null || num.length == 0) return Integer.MIN_VALUE;
        int maxSoFar = num[0];
        int maxEndingHere = num[0];
        for (int i = 1; i < num.length; i++) {
            maxEndingHere = Math.max(maxEndingHere+num[i], num[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
    
    // same as -maximumSubarray(-num[])
    public static int minimumSubarray(int[] num) {
        if (num == null || num.length == 0) return Integer.MIN_VALUE;
        int min = num[0];
        int minEndingHere = num[0];
        for (int i = 1; i < num.length; i++) {
            minEndingHere = Math.min(minEndingHere+num[i], num[i]);
            min = Math.min(min, minEndingHere);
        }
        return min;
    }
    
    public static void main(String[] args) {
        //int[] num = {-2,1,-3,4,-1,2,1,-5,4}; // 6 / 6
        //int[] num = {8, -8, 9, -9, 10, -11, 12};  // 12 - 22
        int[] num = {10, -3, -4, 7, 6, 5, -4, -1}; // 21 - 23
        //int[] num = {-1, 40, -14, 7, 6, 5, -4, -1}; // 44 - 52
        //int[] num = {1, 2, 3, 4, 5, 6}; // 18 - 18 
        //System.out.println(minimumSubarray(num));
        System.out.println(maximumSubarray(num));
        System.out.println(maximumCircularSubarray(num));
    }
}
