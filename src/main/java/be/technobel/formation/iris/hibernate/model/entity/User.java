package be.technobel.formation.iris.hibernate.model.entity;

import com.google.common.base.MoreObjects;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Iris_User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastName;
    private String firstName;
    @Column(unique = true)
    private String email;
    private String password;

    private LocalDate createAt;
    private LocalDate updateAt;

    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToMany(targetEntity = Borrowing.class, mappedBy = "user")
    private Set<Borrowing> borrowings;

    @PrePersist
    public void hashPassword() {
        this.password = BCrypt.hashpw(this.password, BCrypt.gensalt());
        this.createAt = LocalDate.now();
    }

    @PreUpdate
    public void updateDate() {
        this.updateAt = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public User setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
        return this;
    }

    public LocalDate getUpdateAt() {
        return updateAt;
    }

    public User setUpdateAt(LocalDate updateAt) {
        this.updateAt = updateAt;
        return this;
    }

    public Type getType() {
        return type;
    }

    public User setType(Type type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("lastName", lastName)
                .add("firstName", firstName)
                .add("email", email)
                .add("password", password)
                .add("createAt", createAt)
                .add("updateAt", updateAt)
                .add("type", type)
//                .add("borrowings", borrowings)
                .toString();
    }
}
