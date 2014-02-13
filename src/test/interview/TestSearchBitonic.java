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

    private int[] a = { -9, -3, 1, 7, 9, 8, 6, 2, -2 };
    private int[] b = { -9, -3, 1, 7, 9, 8 };
    private int[] c = { 7, 9, 8, 6, 2, -2 };
    private int[] d = { -9, -3, 1, 7, 9 };
    private int[] e = { 9, 8, 6, 2, -2 };

    @Test
    public void testSearch() {
        assertEquals(0, SearchBitonic.bitonicSearch(a, -9));
        assertEquals(2, SearchBitonic.bitonicSearch(a, 1));
        assertEquals(3, SearchBitonic.bitonicSearch(a, 7));
        assertEquals(4, SearchBitonic.bitonicSearch(a, 9));
        assertEquals(5, SearchBitonic.bitonicSearch(a, 8));
        assertEquals(7, SearchBitonic.bitonicSearch(a, 2));
        assertEquals(8, SearchBitonic.bitonicSearch(a, -2));

        assertEquals(0, SearchBitonic.bitonicSearch(b, -9));
        assertEquals(2, SearchBitonic.bitonicSearch(b, 1));
        assertEquals(3, SearchBitonic.bitonicSearch(b, 7));
        assertEquals(4, SearchBitonic.bitonicSearch(b, 9));
        assertEquals(5, SearchBitonic.bitonicSearch(b, 8));

        assertEquals(0, SearchBitonic.bitonicSearch(c, 7));
        assertEquals(1, SearchBitonic.bitonicSearch(c, 9));
        assertEquals(2, SearchBitonic.bitonicSearch(c, 8));
        assertEquals(4, SearchBitonic.bitonicSearch(c, 2));
        assertEquals(5, SearchBitonic.bitonicSearch(c, -2));

        assertEquals(0, SearchBitonic.bitonicSearch(d, -9));
        assertEquals(1, SearchBitonic.bitonicSearch(d, -3));
        assertEquals(3, SearchBitonic.bitonicSearch(d, 7));
        assertEquals(4, SearchBitonic.bitonicSearch(d, 9));

        assertEquals(0, SearchBitonic.bitonicSearch(e, 9));
        assertEquals(1, SearchBitonic.bitonicSearch(e, 8));
        assertEquals(3, SearchBitonic.bitonicSearch(e, 2));
        assertEquals(4, SearchBitonic.bitonicSearch(e, -2));
    }

    @Test
    public void testSearch_() {
        assertEquals(0, SearchBitonic.bitonicSearch_(a, -9));
        assertEquals(2, SearchBitonic.bitonicSearch_(a, 1));
        assertEquals(3, SearchBitonic.bitonicSearch_(a, 7));
        assertEquals(4, SearchBitonic.bitonicSearch_(a, 9));
        assertEquals(5, SearchBitonic.bitonicSearch_(a, 8));
        assertEquals(7, SearchBitonic.bitonicSearch_(a, 2));
        assertEquals(8, SearchBitonic.bitonicSearch_(a, -2));

        assertEquals(0, SearchBitonic.bitonicSearch_(b, -9));
        assertEquals(2, SearchBitonic.bitonicSearch_(b, 1));
        assertEquals(3, SearchBitonic.bitonicSearch_(b, 7));
        assertEquals(4, SearchBitonic.bitonicSearch_(b, 9));
        assertEquals(5, SearchBitonic.bitonicSearch_(b, 8));

        assertEquals(0, SearchBitonic.bitonicSearch_(c, 7));
        assertEquals(1, SearchBitonic.bitonicSearch_(c, 9));
        assertEquals(2, SearchBitonic.bitonicSearch_(c, 8));
        assertEquals(4, SearchBitonic.bitonicSearch_(c, 2));
        assertEquals(5, SearchBitonic.bitonicSearch_(c, -2));

        assertEquals(0, SearchBitonic.bitonicSearch_(d, -9));
        assertEquals(1, SearchBitonic.bitonicSearch_(d, -3));
        assertEquals(3, SearchBitonic.bitonicSearch_(d, 7));
        assertEquals(4, SearchBitonic.bitonicSearch_(d, 9));

        assertEquals(0, SearchBitonic.bitonicSearch_(e, 9));
        assertEquals(1, SearchBitonic.bitonicSearch_(e, 8));
        assertEquals(3, SearchBitonic.bitonicSearch_(e, 2));
        assertEquals(4, SearchBitonic.bitonicSearch_(e, -2));
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
