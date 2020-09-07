package be.technobel.formation.iris.hibernate;

import be.technobel.formation.iris.hibernate.model.entity.User;
import be.technobel.formation.iris.hibernate.repository.AbstractRepository;
import be.technobel.formation.iris.hibernate.repository.UserRepository;
import be.technobel.formation.iris.hibernate.service.ServiceLocator;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        ServiceLocator serviceLocator = ServiceLocator.getInstance();
        serviceLocator.initRepositories();

        UserRepository ur = serviceLocator.getRepository(UserRepository.class);

        User user = new User();
        user.setFirstName("Blop");
        user.setLastName("Biblop");
        user.setEmail("blop@blop.com");

        ur.insert(user);
        User user1 = ur.findOneByEmail(user.getEmail());

        List<User> users = ur.findAll();
        users.forEach(System.out::println);

        User user2 = new User();
        user2.setEmail("blop@blop.com");
        user2.setFirstName("ppppp")
                .setLastName("mmmmm");
        ur.update(user1.getId(), user2);

        List<User> users2 = ur.findAll();
        users2.forEach(System.out::println);
    }
}
