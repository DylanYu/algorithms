package interview;

import java.util.Arrays;

/**
 * 3-SUM.  Given N distinct integers, how many triples sum to exactly zero?
 * 3-SUM in quadratic time. Design an algorithm for the 3-SUM problem that 
 * takes time proportional to N2 in the worst case. You may assume that you 
 * can sort the N integers in time proportional to N^2 or better.
 * 
 * @author Dongliang Yu
 *
 */
public class ThreeSum {
	
	public static void printAll(int[] a) {
		Arrays.sort(a);
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int target = -a[i];
			// start from i+1, to avoid duplicates
			int min = i + 1;
			int max = N - 1;
			while (min < max) {
				int ab = a[min] + a[max];
				if (ab < target)
					min++;
				else if (ab > target)
					max--;
				else {
					System.out.printf("%d + %d + %d = 0\n", a[min], a[max], a[i]);
					min++;
					max--;
				}
			}
		}
	}
	
	public static int count(int[] a) {
		Arrays.sort(a);
		int count = 0;
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int target = -a[i];
			// start from i+1, to avoid duplicates
			int min = i + 1;
			int max = N - 1;
			while (min < max) {
				int ab = a[min] + a[max];
				if (ab < target)
					min++;
				else if (ab > target)
					max--;
				else {
					count++;
					min++;
					max--;
				}
			}
		}
		return count;
	}
	
	public static void printAllBrute(int[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++)
			for (int j = i+1; j < N; j++)
				for (int k = j+1; k < N; k++)
					if (a[i] + a[j] + a[k] == 0)
						System.out.printf("%d + %d + %d = 0\n", a[i], a[j], a[k]);
	}
	
	public static int countBrute(int[] a) {
		int N = a.length;
		int count = 0;
		for (int i = 0; i < N; i++)
			for (int j = i+1; j < N; j++)
				for (int k = j+1; k < N; k++)
					if (a[i] + a[j] + a[k] == 0)
						count++;
		return count;
	}
	
	public static void main(String[] args) {
		int[] a = {1, -5, 7, 26, -12, -9, 3, 6, -4, 2, 10, -11, -23, 17, -3};
		printAll(a.clone());
		System.out.println(count(a.clone()));
		System.out.println();
		
		printAllBrute(a.clone());
		System.out.println(countBrute(a.clone()));
	}

}
