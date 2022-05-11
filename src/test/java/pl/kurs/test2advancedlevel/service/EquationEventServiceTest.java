package pl.kurs.test2advancedlevel.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;
import pl.kurs.test2advancedlevel.dao.EquationEventDao;
import pl.kurs.test2advancedlevel.dao.IEquationEventDao;
import pl.kurs.test2advancedlevel.model.EquationEvent;

import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.Assert.*;

public class EquationEventServiceTest {

    @Test
    public void shouldSaveEventOnlyOnce() {
        IEquationEventDao equationEventDaoMock = Mockito.mock(IEquationEventDao.class);
        EquationEventService equationEventService = new EquationEventService(equationEventDaoMock);
        EquationEvent event = new EquationEvent(Timestamp.from(Instant.now()), "2 + 2 * 2", 6);

        equationEventService.saveEvent(event);

        Mockito.verify(equationEventDaoMock,Mockito.times(1)).save(event);
    }

    @Test
    public void shouldReturnNullWhenEquationEventDaoIsEmpty() {
        IEquationEventDao equationEventDaoMock = Mockito.mock(IEquationEventDao.class);
        EquationEventService equationEventService = new EquationEventService(equationEventDaoMock);

        Assertions
                .assertThat(equationEventService.loadEvent(1L))
                .isEqualTo(null);
    }

}