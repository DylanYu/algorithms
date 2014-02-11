package interview;

/**
 * Search in a bitonic array.
 *
 * An array is bitonic if it is comprised of an increasing sequence of 
 * integers followed immediately by a decreasing sequence of integers. 
 * Write a program that, given a bitonic array of N distinct integer values, 
 * determines whether a given integer is in the array.
 *     Standard version: Use ∼3lgN compares in the worst case.
 *     Signing bonus: Use ∼2lgN compares in the worst case (and prove that no 
 *     algorithm can guarantee to perform fewer than ∼2lgN compares in the 
 *     worst case).
 *
 * @author Dongliang Yu
 *
 */
public class SearchBitonic {
	
	/*
	 * get the largest element's place in a bitonic array (distinct values)
	 */
	public static int max(int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			// deal with edge cases to avoid ArrayIndexOutOfBoundsException
			if (mid == 0) {
				if (a[mid] > a[mid + 1])
					return mid;
				else
					return mid + 1;
			}
			else if (mid == a.length - 1) {
				if (a[mid] > a[mid - 1])
					return mid;
				else
					return mid - 1;
			}
			int now = a[mid];
//			int left = (mid == 0)? a[mid] : a[mid - 1];
//			int right = (mid == a.length-1)? a[mid] : a[mid + 1];
			int left = a[mid - 1];
			int right = a[mid + 1];
			if (left < now && now < right)
				lo = mid + 1;
			else if (left > now && now > right)
				hi = mid - 1;
			else
				return mid;
		}
		return -1;
	}
	
	/**
	 * binary search in a increasing sorted array
	 */
	private static int binarySearchIncreasing(int[] a, int lo, int hi, int key) {
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (a[mid] > key)
				hi = mid - 1;
			else if (a[mid] < key)
				lo = mid + 1;
			else
				return mid;
		}
		return -1;
	}
	
	/**
	 * binary search in a decreasing sorted array
	 */
	private static int binarySearchDecreasing(int[] a, int lo, int hi, int key) {
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (a[mid] > key)
				lo = mid + 1;
			else if (a[mid] < key)
				hi = mid - 1;
			else
				return mid;
		}
		return -1;
	}
	
	/**
	 * search in bitonic array
	 * ~3lgn
	 */
	public static int search_(int[] a, int key) {
		int m = max(a);
		if (a[m] == key)
			return m;
		int leftResult = binarySearchIncreasing(a, 0, m, key);
		int rightResult = binarySearchDecreasing(a, m, a.length - 1, key);
		if (leftResult != -1)
			return leftResult;
		else
			return rightResult;
	}
	
	/**
	 * search in bitonic array
	 * ~2lgn
	 */
	public static int search(int[] a, int key) {
		return search(a, 0, a.length - 1, key);
	}
	
	private static int search(int[] a, int lo, int hi, int key) {
		int mid = (lo + hi) / 2;
		int now = a[mid];
		if (now == key)
			return mid;
		int left = (mid == 0)? a[mid] : a[mid - 1];
		int right = (mid == a.length-1)? a[mid] : a[mid + 1];
		int leftResult, rightResult;
		if (left < now && now < right) {
			leftResult = binarySearchIncreasing(a, lo, mid - 1, key);
			rightResult = search(a, mid + 1, hi, key);
		}
		else if (left > now && now > right) {
			leftResult = search(a, lo, mid - 1, key);
			rightResult = binarySearchDecreasing(a, mid + 1, hi, key);
		}
		else {
			leftResult = binarySearchIncreasing(a, lo, mid - 1, key);
			rightResult = binarySearchDecreasing(a, mid + 1, hi, key);
		}
		if (leftResult != -1)
			return leftResult;
		else
			return rightResult;
	}
	
	public static void main(String[] args) {
	}

}
