package pl.kurs.test2advancedlevel.service;

import org.springframework.stereotype.Service;
import pl.kurs.test2advancedlevel.dao.IEquationEventDao;
import pl.kurs.test2advancedlevel.model.EquationEvent;

@Service
public class EquationEventService implements IEquationEventService{

    private IEquationEventDao equationEventDao;

    public EquationEventService(IEquationEventDao equationEventDao) {
        this.equationEventDao = equationEventDao;
    }


    @Override
    public void saveEvent(EquationEvent event) {
        equationEventDao.save(event);
    }

    @Override
    public EquationEvent loadEvent(Long id) {
        return equationEventDao.get(id);
    }
}
