package be.technobel.formation.iris.hibernate.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Iris_Book")
public class Book {
    @Id
    @Column(name="book_isbn")
    private String isbn;
    @Column(name="book_title")
    private String title;
    @ElementCollection
    private Set<String> keywords;
    @Column(name="book_numberPage")
    private int numberPage;

    @ManyToOne(targetEntity= Provider.class)
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @ManyToMany(targetEntity = Author.class)
    @JoinTable(name = "Iris_BookAuthors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors;

    public Book() {
        this.keywords = new HashSet<>();
    }

    public String getIsbn() {
        return isbn;
    }

    public Book setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public Set<String> getKeywords() {
        return keywords;
    }

//    public Book setKeywords(Set<String> keywords) {
//        this.keywords = new HashSet<>(keywords);
//        return this;
//    }

    public Book addKeyword(String keyword) {
        this.keywords.add(keyword);
        return this;
    }
    public Book removeKeyword(String keyword) {
        this.keywords.remove(keyword);
        return this;
    }

    public int getNumberPage() {
        return numberPage;
    }

    public Book setNumberPage(int numberPage) {
        this.numberPage = numberPage;
        return this;
    }

    public Provider getProvider() {
        return provider;
    }

    public Book setProvider(Provider provider) {
        this.provider = provider;
        return this;
    }

    public Set<Author> getAuthors() {
        return authors;
    }
    public Book addAuthor(Author author) {
        this.authors.add(author);
        return this;
    }
    public Book removeAuthor(Author author) {
        if (this.authors.contains(author)) {
            this.authors.remove(author);
        }
        return this;
    }
}
