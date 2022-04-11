package pl.kurs.test2advancedlevel.service;

import pl.kurs.test2advancedlevel.model.EquationEvent;

public interface IEquationEventService {

    void saveEvent(EquationEvent event);

    EquationEvent loadEvent(Long id);

}
