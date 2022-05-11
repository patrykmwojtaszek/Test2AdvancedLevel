package pl.kurs.test2advancedlevel.operators;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AdditionTest {

    private Addition addition;
    private double a;
    private double b;

    @Before
    public void init() {
        addition = new Addition();
        a = 3;
        b = 7;
    }

    @Test
    public void shouldReturn10forGetResult() {
        double result = addition.getResult(a, b);
        Assert.assertEquals(10, result, 0);
    }

}