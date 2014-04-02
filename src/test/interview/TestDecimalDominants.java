package test.interview;

import static org.junit.Assert.assertEquals;
import interview.DecimalDominants;

import org.junit.Test;

import algs.QuickSort;
import test.util.Displayer;
import test.util.Packer;

public class TestDecimalDominants {
    
    private double[] a = {
            4, 4, 2, 1, 2, 4, 5, 2, 1, 3, 
            3, 3, 5, 3, 0, 1, 1, 3, 5, 2, 
            0, 5, 4, 0, 4, 5, 4, 4, 1, 1
    };
    
    private double[] b = {
            4, 4, 2, 0, 2, 4, 5, 2, 1, 3, 
            1, 1, 2, 3, 5, 1, 1, 3, 0, 2, 
            1, 2, 4, 0, 4, 0, 4, 5, 1, 1
    };
    
    @Test
    public void testA() {
        Displayer.show(a);
        Double[] tmp = Packer.pack(a);
        QuickSort.sort(tmp);
        QuickSort.show(tmp);
        double[] result = DecimalDominants.getDominants(a);
        double[] correct = {1, 2, 3, 4, 5};
        assertEquals(correct.length, result.length);
        for (int i = 0; i < correct.length; i++)
            assertEquals(correct[i], result[i], 1e-5);
    }
    
    @Test
    public void testB() {
        double[] result = DecimalDominants.getDominants(b);
        double[] correct = {0, 1, 2, 4};
        assertEquals(correct.length, result.length);
        for (int i = 0; i < correct.length; i++)
            assertEquals(correct[i], result[i], 1e-5);
    }

}
