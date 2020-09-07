package be.technobel.formation.iris.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Borrowing {
    @EmbeddedId
    private BorrowingId id;
    @Column(name = "borrowing_endAt")
    private LocalDate endAt;

    public Borrowing(BorrowingId id) {
        this.id = id;
    }
    public Borrowing() {

    }
    public Borrowing(User user, Book book) {
        this.id = new BorrowingId(user, book);
    }
    @ManyToOne(targetEntity = User.class)
    @MapsId("userId")
    private User user;
    @ManyToOne(targetEntity = Book.class)
    @MapsId("bookIsbn")
    private Book book;

    @Embeddable
    public static class BorrowingId implements Serializable {
        @Column(name = "borrowing_user_id")
        private Long userId;
        @Column(name= "borrowing_book_isbn")
        private String bookIsbn;
        @Column(name= "borrowing_startAt")
        private LocalDate startAt;

        public BorrowingId() {

        }
        public BorrowingId(User user, Book book) {
            this.userId = user.getId();
            this.bookIsbn = book.getIsbn();
            this.startAt = LocalDate.now();
        }

        public Long getUserId() {
            return userId;
        }

        public BorrowingId setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getBookIsbn() {
            return bookIsbn;
        }

        public BorrowingId setBookIsbn(String bookId) {
            this.bookIsbn = bookId;
            return this;
        }

        public LocalDate getStartAt() {
            return startAt;
        }

        public BorrowingId setStartAt(LocalDate startAt) {
            this.startAt = startAt;
            return this;
        }
    }

    public BorrowingId getId() {
        return id;
    }

    public Borrowing setId(BorrowingId id) {
        this.id = id;
        return this;
    }

    public LocalDate getStartAt() {
        return this.id.startAt;
    }

    public LocalDate getEndAt() {
        return endAt;
    }

    public Borrowing setEndAt(LocalDate endAt) {
        this.endAt = endAt;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Borrowing setUser(User user) {
        this.user = user;
        return this;
    }

    public Book getBook() {
        return book;
    }

    public Borrowing setBook(Book book) {
        this.book = book;
        return this;
    }
}
