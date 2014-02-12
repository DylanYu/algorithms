package test.interview;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import algs.InsersionSort;
import algs.SelectionSort;
import algs.ShellSort;
import algs.Stopwatch;

public class TestSort {
	
	private Double[] a = null;
	
	private Double[] createArray(int N) {
		Random rand = new Random(System.currentTimeMillis());
		Double[] a = new Double[N];
		for (int i = 0; i < N; i++)
			a[i] = (double) rand.nextInt(N * N);
		return a;
	}
	
	private boolean check(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N - 1; i++)
			if (a[i].compareTo(a[i + 1]) > 0)
				return false;
		return true;
	}
	
	@Before
	public void init() {
		a = createArray(10);
	}
	
	@Test
	public void testSelectionSort() {
		SelectionSort.sort(a);
		assertEquals(true, check(a));
	}
	
	@Test
	public void testInsersionSort() {
		InsersionSort.sort(a);
		assertEquals(true, check(a));
	}
	
	@Test
	public void testShellSort() {
		ShellSort.sort(a);
		assertEquals(true, check(a));
	}
	
	@Test
	public void testTime() {
		for (int N = 1000; N <= 100000; N *= 10) {
			System.out.println("N is " + N);
			Double[] a = createArray(N);
			
			Double[] d = a.clone();
			Stopwatch watch = new Stopwatch();
			SelectionSort.sort(d);
			System.out.println("Selection Sort: " + watch.elapsedTime());
			
			d = a.clone();
			watch = new Stopwatch();
			InsersionSort.sort(d);
			System.out.println("Insersion Sort: " + watch.elapsedTime());
			
			d = a.clone();
			watch = new Stopwatch();
			ShellSort.sort(d);
			System.out.println("Shell Sort: " + watch.elapsedTime());
		}
	}

}
