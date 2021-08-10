package be.technobel.formation.iris.hibernate;


import be.technobel.formation.iris.hibernate.model.Arme;
import be.technobel.formation.iris.hibernate.model.Category;
import be.technobel.formation.iris.hibernate.model.Edition;
import be.technobel.formation.iris.hibernate.model.Role;
import be.technobel.formation.iris.hibernate.model.entity.Character;
import be.technobel.formation.iris.hibernate.model.entity.Manga;
import be.technobel.formation.iris.hibernate.repository.CharacterRepository;
import be.technobel.formation.iris.hibernate.repository.MangaRepository;
import be.technobel.formation.iris.hibernate.service.ServiceLocator;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        ServiceLocator serviceLocator = ServiceLocator.getInstance();
        serviceLocator.initRepositories();

//        MangaRepository mangaRepo = serviceLocator.getRepository(MangaRepository.class);
//        mangaRepo.insert(new Manga("One piece","Takashi" ,  LocalDate.of(2005,6,13),Category.HEROIC, new Edition("toei","japon")));
//
//        mangaRepo.findAll().forEach(System.out::println);
//
//        mangaRepo.findAllByCategory(Category.HEROIC).forEach(System.out::println);
//
//
//        mangaRepo.update(4L,new Manga("Death Note" , "masashi" ,LocalDate.now(),Category.SEINEN,new Edition("iji","japon")));

//        mangaRepo.findAllByEditionName("toei").forEach(System.out::println);

        CharacterRepository characterRepo = serviceLocator.getRepository(CharacterRepository.class);

        characterRepo.insert(new Character("luffy", new Arme("mains","peau",false), Role.PRINCIPAL));

    }
}
