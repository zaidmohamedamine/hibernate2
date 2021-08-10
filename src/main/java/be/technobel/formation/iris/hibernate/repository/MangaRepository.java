package be.technobel.formation.iris.hibernate.repository;

import be.technobel.formation.iris.hibernate.model.Category;
import be.technobel.formation.iris.hibernate.model.entity.Manga;

import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class MangaRepository extends AbstractRepository<Long, Manga> {


    public MangaRepository(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    public List<Manga> findAll() {
        TypedQuery<Manga> typedQuery = em.createQuery("SELECT m FROM manga m", Manga.class);


        return typedQuery.getResultList();
    }

    @Override
    public Manga findOneById(Long id) {

        TypedQuery<Manga> typedQuery = em.createQuery("SELECT m FROM manga m WHERE m.id = :id", Manga.class);

        typedQuery.setParameter("id", id);

        return typedQuery.getSingleResult();
    }

    public List<Manga> findAllByCategory(Category category) {

        TypedQuery<Manga> namedQuery = em.createNamedQuery("Manga.findByCategory",Manga.class);

        namedQuery.setParameter("category", category);

        return namedQuery.getResultList();
    }

    public List<Manga> findAllByEditionName(String editionName) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<Manga> criteriaQuery = criteriaBuilder.createQuery(Manga.class);

        Root<Manga> mangaRoot = criteriaQuery.from(Manga.class);

        List<Manga> result = em.createQuery(
                criteriaQuery
                    .select(mangaRoot)
                    .where(criteriaBuilder.equal(mangaRoot.get("edition"),editionName)))
                .getResultList();

        return result;
    }

    @Override
    public void insert(Manga obj) {
        if(obj != null) {
            save(obj);
        }
    }

    @Override
    public void update(Long id, Manga obj) throws IllegalAccessException {
        Manga toUpdate = findOneById(id);

        if(toUpdate != null) {
            merge(toUpdate, obj);
        }
    }

    @Override
    public void remove(Long id) {
        Manga toRemove = findOneById(id);
        if(toRemove != null) {
            getTransaction().begin();
            em.remove(toRemove);
            getTransaction().commit();
        }
    }
}
