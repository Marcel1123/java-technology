package repository;

import entities.Meeting;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

public class MeetingRepository {
    private final EntityManager entityManager = Persistence.createEntityManagerFactory("JPADemo").createEntityManager();

    @Transactional
    public void add(Meeting meeting){
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        this.entityManager.persist(meeting);
        transaction.commit();
    }
}
