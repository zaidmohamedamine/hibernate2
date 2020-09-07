package be.technobel.formation.iris.hibernate.repository;

import be.technobel.formation.iris.hibernate.model.entity.User;

import javax.persistence.*;
import java.util.List;

public class UserRepository {
    private final EntityManager em;

    public UserRepository(EntityManagerFactory factory) {
        this.em = factory.createEntityManager();
        this.em.setFlushMode(FlushModeType.COMMIT);
    }

    public List<User> findAll() {
        Query query = this.em.createQuery("SELECT u FROM User u", User.class);

        return query.getResultList();
    }

    public User insert(User toInsert) {
        this.em.getTransaction().begin();
        this.em.persist(toInsert);
        this.em.flush();
        this.em.getTransaction().commit();
        return toInsert;
    }

    public void update(Long id, User updatedUser) {
        this.em.getTransaction().begin();

        User user = this.em.find(User.class, id);

        user.setFirstName(updatedUser.getFirstName());

        this.em.flush();
    }
}
