package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity(name = "languages")
@Table(name = "languages")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Language {
    @Id
    private UUID id;

    @Column
    private String name;

}
