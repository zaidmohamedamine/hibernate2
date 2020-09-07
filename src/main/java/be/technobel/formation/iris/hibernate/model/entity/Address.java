package be.technobel.formation.iris.hibernate.model.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.persistence.*;

@Entity
@Table(name= "Iris_Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    @Column(name = "address_street")
    private String street;
    @Column(name= "address_city")
    private String city;
    @Column(name= "address_number")
    private String number;

//    @OneToOne(targetEntity= Provider.class, mappedBy = "address")
//    private Provider provider;

    public Address() {

    }
    //Deep copie
    public Address(Address toCopy) {
        this.id = toCopy.id;
        this.street = new String(toCopy.street);
        this.city = new String(toCopy.city);
        this.number = new String(toCopy.number);
    }

    public Long getId() {
        return id;
    }

    public Address setId(Long id) {
        this.id = id;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public Address setNumber(String number) {
        this.number = number;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equal(street, address.street) &&
                Objects.equal(city, address.city) &&
                Objects.equal(number, address.number);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(street, city, number);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("street", street)
                .add("city", city)
                .add("number", number)
                .toString();
    }
}
