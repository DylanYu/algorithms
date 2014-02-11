package test.interview;

import static org.junit.Assert.assertEquals;
import interview.SearchBitonic;

import org.junit.Test;

/**
 * 
 * @author Dongliang Yu
 *
 */
public class TestSearchBitonic {
	
	private int[] a = {-9, -3, 1, 7, 9, 8, 6, 2, -2};
	private int[] b = {-9, -3, 1, 7, 9, 8};
	private int[] c = {7, 9, 8, 6, 2, -2};
	private int[] d = {-9, -3, 1, 7, 9};
	private int[] e = {9, 8, 6, 2, -2};
	
	@Test
	public void testSearch() {
		assertEquals(0, SearchBitonic.search(a, -9));
		assertEquals(2, SearchBitonic.search(a, 1));
		assertEquals(3, SearchBitonic.search(a, 7));
		assertEquals(4, SearchBitonic.search(a, 9));
		assertEquals(5, SearchBitonic.search(a, 8));
		assertEquals(7, SearchBitonic.search(a, 2));
		assertEquals(8, SearchBitonic.search(a, -2));
		
		assertEquals(0, SearchBitonic.search(b, -9));
		assertEquals(2, SearchBitonic.search(b, 1));
		assertEquals(3, SearchBitonic.search(b, 7));
		assertEquals(4, SearchBitonic.search(b, 9));
		assertEquals(5, SearchBitonic.search(b, 8));
		
		assertEquals(0, SearchBitonic.search(c, 7));
		assertEquals(1, SearchBitonic.search(c, 9));
		assertEquals(2, SearchBitonic.search(c, 8));
		assertEquals(4, SearchBitonic.search(c, 2));
		assertEquals(5, SearchBitonic.search(c, -2));
		
		assertEquals(0, SearchBitonic.search(d, -9));
		assertEquals(1, SearchBitonic.search(d, -3));
		assertEquals(3, SearchBitonic.search(d, 7));
		assertEquals(4, SearchBitonic.search(d, 9));
		
		assertEquals(0, SearchBitonic.search(e, 9));
		assertEquals(1, SearchBitonic.search(e, 8));
		assertEquals(3, SearchBitonic.search(e, 2));
		assertEquals(4, SearchBitonic.search(e, -2));
	}
	
	@Test
	public void testSearch_() {
		assertEquals(0, SearchBitonic.search_(a, -9));
		assertEquals(2, SearchBitonic.search_(a, 1));
		assertEquals(3, SearchBitonic.search_(a, 7));
		assertEquals(4, SearchBitonic.search_(a, 9));
		assertEquals(5, SearchBitonic.search_(a, 8));
		assertEquals(7, SearchBitonic.search_(a, 2));
		assertEquals(8, SearchBitonic.search_(a, -2));
		
		assertEquals(0, SearchBitonic.search_(b, -9));
		assertEquals(2, SearchBitonic.search_(b, 1));
		assertEquals(3, SearchBitonic.search_(b, 7));
		assertEquals(4, SearchBitonic.search_(b, 9));
		assertEquals(5, SearchBitonic.search_(b, 8));
		
		assertEquals(0, SearchBitonic.search_(c, 7));
		assertEquals(1, SearchBitonic.search_(c, 9));
		assertEquals(2, SearchBitonic.search_(c, 8));
		assertEquals(4, SearchBitonic.search_(c, 2));
		assertEquals(5, SearchBitonic.search_(c, -2));
		
		assertEquals(0, SearchBitonic.search_(d, -9));
		assertEquals(1, SearchBitonic.search_(d, -3));
		assertEquals(3, SearchBitonic.search_(d, 7));
		assertEquals(4, SearchBitonic.search_(d, 9));
		
		assertEquals(0, SearchBitonic.search_(e, 9));
		assertEquals(1, SearchBitonic.search_(e, 8));
		assertEquals(3, SearchBitonic.search_(e, 2));
		assertEquals(4, SearchBitonic.search_(e, -2));
	}
	
	@Test
	public void testMax() {
		assertEquals(4, SearchBitonic.max(a));
		assertEquals(4, SearchBitonic.max(b));
		assertEquals(1, SearchBitonic.max(c));
		assertEquals(4, SearchBitonic.max(d));
		assertEquals(0, SearchBitonic.max(e));
	}

}
