package be.technobel.formation.iris.hibernate.repository;

import be.technobel.formation.iris.hibernate.model.entity.User;
import org.hibernate.Session;

import javax.persistence.*;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository extends AbstractRepository<Long, User> {

    public UserRepository(EntityManagerFactory factory) {
        super(factory);
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = this.em.createQuery("SELECT u FROM User u", User.class);

        return query.getResultList();
    }

    @Override
    public User findOneById(Long id) {
        TypedQuery<User> query = this.em.createQuery("SELECT u FROM User u WHERE u.id = :id", User.class);
        query.setParameter("id", id);

        return query.getSingleResult();
    }

    public User findOneByEmail(String email) {
        TypedQuery<User> query = this.em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
        query.setParameter("email", email);

        return query.getSingleResult();
    }

    @Override
    public void insert(User obj) {
        try {
            User search = this.findOneByEmail(obj.getEmail());
            this.update(search.getId(), obj);
        } catch (Exception e) {
            this.save(obj);
        }
    }

    @Override
    public void update(Long id, User obj) throws IllegalAccessException {
        User toUpdate = this.findOneById(id);
        if (toUpdate != null) {
            this.merge(toUpdate, obj);
        }
    }

    @Override
    public void remove(Long id) {

    }
}
