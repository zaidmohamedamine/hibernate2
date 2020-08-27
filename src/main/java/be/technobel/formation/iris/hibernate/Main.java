package be.technobel.formation.iris.hibernate;

import be.technobel.formation.iris.hibernate.model.Album;
import be.technobel.formation.iris.hibernate.model.Author;
import org.checkerframework.checker.units.qual.A;

import javax.persistence.*;
import javax.transaction.Transaction;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("be.technobel.formation.iris.hibernate");
        EntityManager em = emf.createEntityManager();
        em.setFlushMode(FlushModeType.AUTO);

        Album album = em.find(Album.class, 1L);

        System.out.println(album);

        Query query = em.createQuery("SELECT a FROM Album a JOIN a.author author WHERE author.nom = :authorName");

        query.setParameter("authorName", "Flavian");

        List<Album> albums = query.getResultList();

        albums.forEach(System.out::println);

        List<Album> albumsList = em.createNamedQuery("Album.FindAll").setParameter("isActive", true).getResultList();

        albumsList.forEach(System.out::println);
    }
}
