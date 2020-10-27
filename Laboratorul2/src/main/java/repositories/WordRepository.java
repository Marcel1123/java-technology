package repositories;

import entities.Word;
import exceptions.DuplicateWordException;
import lombok.SneakyThrows;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.UUID;

public class WordRepository {
    private final EntityManager entityManager = Persistence.createEntityManagerFactory("JPADemo").createEntityManager();

    @Transactional
    @SneakyThrows
    public Word addWord(UUID languageId, String word, String definition){
        if(getWordByContent(word) == null){
            UUID id = UUID.randomUUID();
            this.entityManager.getTransaction().begin();
            this.entityManager.createNativeQuery("insert into word values(?, ?, ?, ?)")
                    .setParameter(1, id)
                    .setParameter(2, word)
                    .setParameter(3, definition)
                    .setParameter(4, languageId)
                    .executeUpdate();
            this.entityManager.getTransaction().commit();
            Word word1 = new Word();
            word1.setId(id);
            word1.setContent(word);
            word1.setLanguage(new LanguageRepository().getById(languageId));
            word1.setDefinition(definition);
            return word1;
        } else {
            throw new DuplicateWordException("This word already exist in data base");
        }
    }

    private Word getWordByContent(String word){
        TypedQuery<Word> languageTypedQuery = this.entityManager.createQuery(
                "select distinct w from word w where w.content = :content ", Word.class
        );
        try {
            Word word1 = languageTypedQuery.setParameter("content", word).getSingleResult();
            return word1;
        } catch (NoResultException e){
            return null;
        }
    }
}
