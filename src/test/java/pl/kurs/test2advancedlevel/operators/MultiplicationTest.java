package pl.kurs.test2advancedlevel.operators;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MultiplicationTest {

    private Multiplication multiplication;
    private double a;
    private double b;

    @Before
    public void init() {
        multiplication = new Multiplication();
        a = 3;
        b = 5;
    }

    @Test
    public void shouldReturn15forGetResult() {
        double result = multiplication.getResult(a, b);
        Assert.assertEquals(15, result, 0);
    }

}