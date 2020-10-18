package repository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.io.*;
import java.util.List;
import java.util.UUID;

public class WordRepository {
    private final EntityManager entityManager = Persistence.createEntityManagerFactory("JPADemo").createEntityManager();

    @Transactional
    public void populateDataBase() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\parlo\\IdeaProject\\untitled6\\src\\main\\java\\repository\\words.txt"));
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String line = null;

        this.entityManager.getTransaction().begin();
        while ((line = bufferReader.readLine()) != null) {
            this.entityManager.createNativeQuery("insert into words values (?, ?, ?)")
                    .setParameter(1, UUID.randomUUID())
                    .setParameter(2, "English")
                    .setParameter(3, line)
                    .executeUpdate();
        }
        this.entityManager.getTransaction().commit();
        bufferReader.close();
    }
    public List<String> getSpecificWords(String characters){
        TypedQuery<String> wordTypedQuery = entityManager.createQuery(
                "select distinct w.word from words w where length(trim(both :data from w.word)) = 0", String.class
        );
        return wordTypedQuery.setParameter("data", characters).getResultList();
    }
}
