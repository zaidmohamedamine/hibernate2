package be.technobel.formation.iris.hibernate;

import be.technobel.formation.iris.hibernate.model.entity.Type;
import be.technobel.formation.iris.hibernate.model.entity.User;
import be.technobel.formation.iris.hibernate.repository.UserRepository;
import org.checkerframework.checker.units.qual.A;

import javax.persistence.*;
import javax.transaction.Transaction;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("be.technobel.formation.iris.hibernate");
//        EntityManager em = emf.createEntityManager();
//        em.setFlushMode(FlushModeType.AUTO);

        UserRepository ur = new UserRepository(emf);
        User user = new User();
        user.setFirstName("Flavian")
                .setLastName("Ovyn")
                .setEmail("flavian3.ovyn@bstorm.be")
                .setPassword("Blop")
                .setType(Type.DICTIONNAIRE);
//        ur.insert(user);

        List<User> users = ur.findAll();

        for(User u: users) {
            if (u.getType() != null) {
                System.out.println(u.getType().action());
            }
            System.out.println(u);
        }
        System.out.println(Type.BLOP.action());
        System.out.println(Type.CATALOGUE.action());
        System.out.println(Type.DICTIONNAIRE.action());
//Permet la création d'une autre référence mémoire
//        String str = "Blop";
//        String str2 = new String("Blop");
    }
}
