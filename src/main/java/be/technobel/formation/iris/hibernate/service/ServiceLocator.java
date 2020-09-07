package be.technobel.formation.iris.hibernate.service;

import be.technobel.formation.iris.hibernate.repository.AbstractRepository;
import be.technobel.formation.iris.hibernate.repository.Repository;
import org.reflections.Reflections;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ServiceLocator {
    private static ServiceLocator instance = null;
    public static ServiceLocator getInstance() {
        if (instance == null) instance = new ServiceLocator();
        return instance;
    }
    private static final String ROOT_PATH = "be.technobel.formation.iris.hibernate";
    private static final String REPOSITORY_PATH = ROOT_PATH+ ".repository";

    private final EntityManagerFactory emf;
    private final Map<Class<?>, AbstractRepository> repositories;

    private ServiceLocator() {
        this.repositories = new HashMap<>();
        this.emf = Persistence.createEntityManagerFactory(ROOT_PATH);
    }

    public void initRepositories() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        Reflections reflections = new Reflections(REPOSITORY_PATH);
        Set<Class<?>> repositories = reflections.getTypesAnnotatedWith(Repository.class);

        for(Class<?> clazz: repositories) {
            Class<AbstractRepository> instanceClass = (Class<AbstractRepository>) Class.forName(String.format("%s.%s", REPOSITORY_PATH, clazz.getSimpleName()));
            this.repositories.put(clazz, instanceClass.getConstructor(EntityManagerFactory.class).newInstance(emf));
        }
    }

    public <T> T getRepository(Class<?> clazz) {
        return (T) this.repositories.get(clazz);
    }
}
