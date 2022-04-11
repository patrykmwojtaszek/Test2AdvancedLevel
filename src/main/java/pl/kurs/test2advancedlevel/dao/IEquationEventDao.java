package pl.kurs.test2advancedlevel.dao;

import pl.kurs.test2advancedlevel.model.EquationEvent;

public interface IEquationEventDao {

    void save(EquationEvent event);

    EquationEvent get(Long id);

}
