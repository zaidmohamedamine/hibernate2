package be.technobel.formation.iris.hibernate.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "iris_author")
@Getter
@Setter
@ToString
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="author_id")
    private Long id;
    @Column
    private String nom;

    public Author() {
    }
}
