package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Meeting {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String topic;

    @Column
    private Date startingTime;

    @Column
    private Integer duration;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Location location;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Person> persons;
}
