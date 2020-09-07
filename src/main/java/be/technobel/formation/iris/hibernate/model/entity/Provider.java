package be.technobel.formation.iris.hibernate.model.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name= "Iris_Provider")
public class Provider implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="provider_id")
    private Long id; // Long car utilisation du type dans le systeme de JPA/Hibernate
    @Column(name="provider_label")
    private String label;

    @OneToOne(targetEntity= Address.class)
    @JoinColumn(name = "address_id")
    private Address address;

//    @OneToMany(targetEntity = Book.class, mappedBy = "provider")
//    private Set<Book> books;

    public Provider() {
    }
    // Deep Copy
    public Provider(Provider toCopy) {
        this.id = toCopy.id;
        this.label = toCopy.label;
        // Shadow copy
//        this.address = toCopy.address;
        this.address = new Address(toCopy.address);
    }

    public Long getId() {
        return id;
    }

    public Provider setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public Provider setLabel(String label) {
        this.label = label;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Provider)) return false;
        Provider provider = (Provider) o;
        return Objects.equal(id, provider.id) &&
                Objects.equal(label, provider.label);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, label);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("label", label)
                .toString();
    }
}
