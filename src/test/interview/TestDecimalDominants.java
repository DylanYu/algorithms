package test.interview;

import static org.junit.Assert.assertEquals;
import interview.DecimalDominants;

import org.junit.Test;

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
    
    private double[] c = {
            2, 3, 2, 6, 2, 4, 5, 6, 1, 6, 
            1, 1, 2, 3, 5, 5, 1, 3, 0, 2, 
            6, 2, 1, 0, 4, 0, 4, 6, 1, 5
    };
    
    @Test
    public void testA() {
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
    
    @Test
    public void testC() {
        double[] result = DecimalDominants.getDominants(c);
        double[] correct = {1, 2, 5, 6};
        assertEquals(correct.length, result.length);
        for (int i = 0; i < correct.length; i++)
            assertEquals(correct[i], result[i], 1e-5);
    }

}
