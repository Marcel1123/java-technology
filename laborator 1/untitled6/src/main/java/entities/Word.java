package entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity(name = "words")
@Table(name = "words")
@Data
@NoArgsConstructor
public class Word {
    @Id
    @Column
    private UUID id;

    @Column
    private String word;

    @Column
    private String language;
}
