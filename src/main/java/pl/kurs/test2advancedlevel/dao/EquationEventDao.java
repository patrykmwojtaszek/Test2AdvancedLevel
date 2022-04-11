package pl.kurs.test2advancedlevel.dao;

import org.springframework.stereotype.Repository;
import pl.kurs.test2advancedlevel.model.EquationEvent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Repository
public class EquationEventDao implements IEquationEventDao{

    private EntityManagerFactory factory;

    public EquationEventDao(EntityManagerFactory factory) {
        this.factory = factory;
    }


    @Override
    public void save(EquationEvent event) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(event);
        tx.commit();
        entityManager.close();
    }

    @Override
    public EquationEvent get(Long id) {
        EntityManager entityManager = factory.createEntityManager();
        EquationEvent equationEvent = entityManager.find(EquationEvent.class, id);
        entityManager.close();
        return equationEvent;
    }
}
