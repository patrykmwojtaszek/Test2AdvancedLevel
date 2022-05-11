package pl.kurs.test2advancedlevel.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pl.kurs.test2advancedlevel.app.Main;
import pl.kurs.test2advancedlevel.dao.IEquationEventDao;
import pl.kurs.test2advancedlevel.model.EquationEvent;



import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {Main.class},
        loader = AnnotationConfigContextLoader.class)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class InMemoryDbTest {

    @Autowired
    private IEquationEventDao equationEventDao;

    @Test
    public void givenEquationEvent_whenSave_thenGetOk() {
        EquationEvent equationEvent = new EquationEvent(Timestamp.from(Instant.now()), "2 + 2 * 2", 6);
        equationEventDao.save(equationEvent);

        EquationEvent equationEvent2 = equationEventDao.get(1L);
        assertEquals(6, equationEvent2.getResult(), 0);

    }

}
