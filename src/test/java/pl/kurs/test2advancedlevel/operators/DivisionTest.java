package pl.kurs.test2advancedlevel.operators;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertThrows;

public class DivisionTest {

    private Division division;
    private double a;
    private double b;
    private double c;

    @Before
    public void init() {
        division = new Division();
        a = 10;
        b = 5;
        c = 0;
    }

    @Test
    public void shouldReturn2forGetResult() {
        double result = division.getResult(a, b);
        Assert.assertEquals(2, result, 0);
    }

    @Test
    public void shouldThrowArithmeticExceptionWhenDividerIs0() {
        Exception e = assertThrows(ArithmeticException.class, () -> division.getResult(a, c));
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(e).isExactlyInstanceOf(ArithmeticException.class);
        sa.assertThat(e).hasMessage("We cannot divide by 0");
    }

}