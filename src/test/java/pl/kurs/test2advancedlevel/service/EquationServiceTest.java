package pl.kurs.test2advancedlevel.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.stereotype.Repository;
import pl.kurs.test2advancedlevel.dao.EquationEventDao;
import pl.kurs.test2advancedlevel.exceptions.InvalidEquationFormatException;
import pl.kurs.test2advancedlevel.exceptions.UnknownOperatorException;

import javax.persistence.EntityManagerFactory;


public class EquationServiceTest {

//    @Mock private EntityManagerFactory factory;
//    @Mock private EquationEventDao equationEventDao;
    @Mock private EquationEventService equationEventService;
    private EquationService equationService;
    private String equation;



    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
//        equationEventDao = new EquationEventDao(factory);
//        equationEventService = new EquationEventService(equationEventDao);
        equationService = new EquationService(equationEventService);
        equation = "2 + 2 * 2";
    }

    @Test
    public void shouldReturn6forSolveEquation() throws InvalidEquationFormatException, UnknownOperatorException {
        //given
        String testEquation = equation;
        //when
        double result = equationService.solveEquation(testEquation);
        //then
        Assert.assertEquals(result, 6, 0);
    }

}