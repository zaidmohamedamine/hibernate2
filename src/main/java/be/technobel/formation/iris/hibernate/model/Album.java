package be.technobel.formation.iris.hibernate.model;

import lombok.*;
import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "iris_album")
@ToString
@NamedQueries({
        @NamedQuery(name = "Album.FindAll", query = "SELECT DISTINCT a FROM Album a WHERE a.isActive = :isActive")
})
public class Album implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "album_id")
    private Long id;
    @Column
    private String title;
    @Column
    private LocalDate outDate;
    @Column
    private String demo;

    @ManyToOne(targetEntity = Author.class, fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    private Author author;

    public Album() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getOutDate() {
        return outDate;
    }

    public void setOutDate(LocalDate outDate) {
        this.outDate = outDate;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
