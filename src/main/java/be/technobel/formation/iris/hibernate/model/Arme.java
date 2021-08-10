package be.technobel.formation.iris.hibernate.model;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Arme {
    private String nom;
    private String matiere;
    private boolean magique;

    public Arme() {
    }

    public Arme(String nom, String matiere, boolean magique) {
        this.nom = nom;
        this.matiere = matiere;
        this.magique = magique;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public boolean isMagique() {
        return magique;
    }

    public void setMagique(boolean magique) {
        this.magique = magique;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Arme)) return false;
        Arme arme = (Arme) o;
        return magique == arme.magique && Objects.equals(nom, arme.nom) && Objects.equals(matiere, arme.matiere);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, matiere, magique);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Arme{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", matiere='").append(matiere).append('\'');
        sb.append(", magique=").append(magique);
        sb.append('}');
        return sb.toString();
    }
}
