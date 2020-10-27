package repositories;

import entities.Language;
import lombok.NoArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
public class PopulateDataBaseRepository {
    private final EntityManager entityManager = Persistence.createEntityManagerFactory("JPADemo").createEntityManager();
    private List<Language> languages = new LinkedList<Language>();

    @Transactional
    public void populateLanguage() {
        String[] languages = {"English", "Spanish", "Bulgarian", "Francais", "Polish", "Romanian", "Slovenian", "Ukrainian"};
        this.entityManager.getTransaction().begin();
        for (String string : languages) {
            UUID languageId = UUID.randomUUID();
            this.entityManager.createNativeQuery("insert into languages values (?, ?)")
                    .setParameter(1, languageId)
                    .setParameter(2, string)
                    .executeUpdate();
            this.languages.add(new Language(languageId, string));
        }
        this.entityManager.getTransaction().commit();
    }

    @Transactional
    public void populateWords() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\parlo\\IdeaProject\\untitled6\\src\\main\\java\\repository\\words.txt"));
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String line = null;
        Language language = this.languages.stream()
                .filter(p -> p.getName().equals("English"))
                .collect(Collectors.toList())
                .get(0);

        this.entityManager.getTransaction().begin();
        while ((line = bufferReader.readLine()) != null) {
            this.entityManager.createNativeQuery("insert into word values (?, ?, ?)")
                    .setParameter(1, UUID.randomUUID())
                    .setParameter(2, line)
                    .setParameter(3, language.getId())
                    .executeUpdate();
        }
        this.entityManager.getTransaction().commit();
        bufferReader.close();
    }
}
