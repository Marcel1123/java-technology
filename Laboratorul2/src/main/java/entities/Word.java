package entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "word")
@Table(name = "word")
@Data
@NoArgsConstructor
public class Word {
    @Id
    @Column
    private UUID id;

    @Column
    private String content;

    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Language language;

    @Column
    private String definition;
}