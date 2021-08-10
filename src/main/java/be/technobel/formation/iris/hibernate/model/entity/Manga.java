package be.technobel.formation.iris.hibernate.model.entity;

import be.technobel.formation.iris.hibernate.model.Category;
import be.technobel.formation.iris.hibernate.model.Edition;
import be.technobel.formation.iris.hibernate.model.listeners.MangaLogListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "manga")
@EntityListeners({MangaLogListener.class})
@NamedQuery(name = "Manga.findByCategory", query = "SELECT m FROM manga m WHERE m.category like :category")
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Basic()
    private String author;

    @Transient
    private int bookAge;

    @Column(name = "release_date", columnDefinition = "DATE")
//    @Temporal(TemporalType.DATE)
    private LocalDate releaseDate;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Embedded
    private Edition edition;

    public Manga() {
    }

    public Manga(String title, String author, LocalDate releaseDate, Category category, Edition edition) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.category = category;
        this.edition = edition;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getBookAge() {
        return LocalDate.now().getYear() - releaseDate.getYear();
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manga)) return false;
        Manga manga = (Manga) o;
        return Objects.equals(id, manga.id) && Objects.equals(title, manga.title) && Objects.equals(author, manga.author) && Objects.equals(releaseDate, manga.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, releaseDate);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Manga{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", bookAge=").append(bookAge);
        sb.append(", releaseDate=").append(releaseDate);
        sb.append(", category=").append(category);
        sb.append(", edition=").append(edition);
        sb.append('}');
        return sb.toString();
    }
}
