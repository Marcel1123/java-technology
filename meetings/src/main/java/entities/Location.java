package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Location implements Serializable {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String name;
}
