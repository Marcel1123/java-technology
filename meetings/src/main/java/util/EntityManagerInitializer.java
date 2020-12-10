package util;


import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerInitializer {
    @Produces
    public EntityManager create(){
        return Persistence.createEntityManagerFactory("JPADemo").createEntityManager();
    }
}
