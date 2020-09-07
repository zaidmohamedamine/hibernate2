package be.technobel.formation.iris.hibernate.repository;


import javax.persistence.*;
import javax.transaction.Transaction;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public abstract class AbstractRepository<TKey extends Serializable, TValue> {
    private EntityManagerFactory emf;
    protected EntityManager em;

    public AbstractRepository(EntityManagerFactory emf) {
        this.emf = emf;
        this.open();
    }

    protected void open() {
        this.em = emf.createEntityManager();
        this.em.setFlushMode(FlushModeType.AUTO);
    }

    protected EntityTransaction getTransaction() {
        return this.em.getTransaction();
    }
    protected void save(TValue value) {
        this.getTransaction().begin();
        try {
            this.em.persist(value);
            this.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.getTransaction().rollback();
        }
    }

    protected void merge(TValue value) {
        this.getTransaction().begin();
        this.em.merge(value);
        this.getTransaction().commit();
    }
    protected void merge(TValue src1, TValue src2) throws IllegalAccessException {
        Field[] fields = src1.getClass().getDeclaredFields();

        for(Field field: fields) {
            field.setAccessible(true);
            Object value1 = field.get(src1);
            Object value2 = field.get(src2);

            if (value1 != null && value2 != null && !value1.equals(value2)) {
                field.set(src1, value2);
            } else if (value1 == null && value2 != null) {
                field.set(src1, value2);
            }
        }
        this.merge(src1);
    }

    public abstract List<TValue> findAll();
    public abstract TValue findOneById(TKey id);
    public abstract void insert(TValue obj);
    public abstract void update(TKey id, TValue obj) throws IllegalAccessException;
    public abstract void remove(TKey id);
}
