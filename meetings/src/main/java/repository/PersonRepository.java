package repository;

import entities.Person;
import org.hibernate.Session;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.tuple.IdentifierProperty;
import org.jboss.weld.annotated.Identifier;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import java.util.List;

@Named
@ApplicationScoped
public class PersonRepository {

    @Inject
    private EntityManager entityManager;

    @Transactional
    public void add(Person person){
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        this.entityManager.persist(person);
        transaction.commit();
    }

    public List<Person> getAll() {
        return entityManager.createQuery("from Person").getResultList();
    }
}


