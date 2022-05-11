package pl.kurs.test2advancedlevel.operators;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SubtractionTest {

    private Subtraction subtraction;
    private double a;
    private double b;

    @Before
    public void init() {
        subtraction = new Subtraction();
        a = 9;
        b = 6;
    }

    @Test
    public void shouldReturn3forGetResult() {
        double result = subtraction.getResult(a, b);
        Assert.assertEquals(3, result, 0);
    }

}