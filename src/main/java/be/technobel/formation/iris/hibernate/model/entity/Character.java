package be.technobel.formation.iris.hibernate.model.entity;

import be.technobel.formation.iris.hibernate.model.Arme;
import be.technobel.formation.iris.hibernate.model.Role;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "nom",column = @Column(name = "nom_arme")),
            @AttributeOverride(name = "matiere",column = @Column(name = "matiere_arme"))
    })
    private Arme arme;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Character() {
    }

    public Character(String nom, Arme arme, Role role) {
        this.nom = nom;
        this.arme = arme;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Arme getArme() {
        return arme;
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Character)) return false;
        Character character = (Character) o;
        return Objects.equals(id, character.id) && Objects.equals(nom, character.nom) && Objects.equals(arme, character.arme) && role == character.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, arme, role);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Character{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", arme=").append(arme);
        sb.append(", role=").append(role);
        sb.append('}');
        return sb.toString();
    }
}
