package repositories;

import entities.Language;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class LanguageRepository {
    private final EntityManager entityManager = Persistence.createEntityManagerFactory("JPADemo").createEntityManager();

    public List<Language> getAll(){
        TypedQuery<Language> languageTypedQuery = this.entityManager.createQuery(
                "select l from languages l", Language.class
        );
        return languageTypedQuery.getResultList();
    }

    public Language getById(UUID id){
        TypedQuery<Language> languageTypedQuery = this.entityManager.createQuery(
                "select distinct l from languages l where l.id = :id ", Language.class
        );
        try {
            return languageTypedQuery.setParameter("id", id).getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }
}
