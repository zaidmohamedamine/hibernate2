package be.technobel.formation.iris.hibernate.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "Iris_Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="author_lastName")
    private String lastName;
    @Column(name="author_firstName")
    private String firstName;
}
