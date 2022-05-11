package pl.kurs.test2advancedlevel.service;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.kurs.test2advancedlevel.exceptions.InvalidEquationFormatException;
import pl.kurs.test2advancedlevel.exceptions.UnknownOperatorException;
import pl.kurs.test2advancedlevel.operators.Addition;
import pl.kurs.test2advancedlevel.operators.Division;
import pl.kurs.test2advancedlevel.operators.Multiplication;
import pl.kurs.test2advancedlevel.operators.Subtraction;

import static org.junit.Assert.assertThrows;


public class EquationServiceTest {

//    @Mock private EntityManagerFactory factory;
//    @Mock private EquationEventDao equationEventDao;
    @Mock private EquationEventService equationEventServiceMock;
    private EquationService equationService;
    private String equation;




    @Before
    public void init() {

        MockitoAnnotations.openMocks(this);
//        equationEventDao = new EquationEventDao(factory);
        equationService = new EquationService(equationEventServiceMock, new Addition(), new Division(), new Multiplication(), new Subtraction());
        equation = "3 + 2 * 2 - 4 / 2";
    }

    @Test
    public void shouldReturn5forSolveEquation() throws InvalidEquationFormatException, UnknownOperatorException {
        //given
        String testEquation = equation;
        //when
        double result = equationService.solveEquation(testEquation);
        //then
        Assert.assertEquals(result, 5, 0);
    }

    @Test
    public void shouldThrowInvalidEquationFormatExceptionWhenEquationFormatIsWrong() {
        Exception e = assertThrows(InvalidEquationFormatException.class, () -> equationService.validEquationString("a + b"));
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(e).isExactlyInstanceOf(InvalidEquationFormatException.class);
    }

    @Test
    public void shouldThrowUnknownOperatorExceptionWhenOperatorIsWrong() {
        Exception e = assertThrows(UnknownOperatorException.class, () -> equationService.validEquationString("2 x 2"));
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(e).isExactlyInstanceOf(UnknownOperatorException.class);
    }

}