package be.technobel.formation.iris.hibernate.repository;

import be.technobel.formation.iris.hibernate.model.entity.Character;

import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class CharacterRepository extends AbstractRepository<Long,Character>{

    public CharacterRepository(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    public List<Character> findAll() {

        TypedQuery<Character> typedQuery = em.createQuery("SELECT c FROM Character c", Character.class);

        return typedQuery.getResultList();
    }

    @Override
    public Character findOneById(Long id) {
        return null;
    }

    @Override
    public void insert(Character obj) {
        if(obj != null) {
            save(obj);
        }
    }

    @Override
    public void update(Long id, Character obj) throws IllegalAccessException {

    }

    @Override
    public void remove(Long id) {

    }
}
