package interview;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array containing only 0s and 1s, find the largest subarray which 
 * contain equal no of 0s and 1s. Expected time complexity is O(n). 
 * 
 * Examples: 
 * 
 * Input: arr[] = {1, 0, 1, 1, 1, 0, 0} 
 * Output: 1 to 6 (Starting and Ending indexes of output subarray) 
 * 
 * Input: arr[] = {1, 1, 1, 1} 
 * Output: No such subarray 
 * 
 * Input: arr[] = {0, 0, 1, 1, 0} 
 * Output: 0 to 3 Or 1 to 4
 * 
 * 
 * @author Dongliang Yu
 *
 */
public class LargestSubarrayWithEqualNumberOf0And1 {
    public static int[] solve(int[] arr) {
        int[] ret = new int[2];
        if (arr == null || arr.length <= 1) {
            ret[0] = -1;
            ret[1] = -1;
            return ret;
        }
        int[] A = new int[arr.length];
        Map<Integer, Integer> minIdx = new HashMap<Integer, Integer>();
        minIdx.put(0, -1); // do NOT forget
        Map<Integer, Integer> maxIdx = new HashMap<Integer, Integer>();
        maxIdx.put(0, -1); // do NOT forget
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) A[i] = (i-1 >= 0 ? A[i-1] : 0) + 1;
            else if (arr[i] == 0) A[i] = (i-1 >= 0 ? A[i-1] : 0) - 1;
            if (!minIdx.containsKey(A[i])) minIdx.put(A[i], i);
            else minIdx.put(A[i], Math.min(minIdx.get(A[i]), i));
            if (!maxIdx.containsKey(A[i])) maxIdx.put(A[i], i);
            else maxIdx.put(A[i], Math.max(maxIdx.get(A[i]), i));
        }
        int maxLen = 0;
        for (int e : minIdx.keySet()) {
            int min = minIdx.get(e);
            int max = maxIdx.get(e);
            if (max-min > maxLen) {
                maxLen = max-min;
                ret[0] = min+1; //
                ret[1] = max; //
            }
        }
        if (maxLen == 0) {
            ret[0] = -1;
            ret[1] = -1;
        }
        return ret;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 0, 0, 0};
        //int[] arr = {1, 0, 1, 1, 1, 0, 0};
        //int[] arr = {1, 1, 1, 1};
        //int[] arr = {0, 0, 1, 1, 0};
        int[] ret = solve(arr);
        System.out.println(ret[0] + "," + ret[1]);
    }
}
