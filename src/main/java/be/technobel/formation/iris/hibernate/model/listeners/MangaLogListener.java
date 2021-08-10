package be.technobel.formation.iris.hibernate.model.listeners;

import be.technobel.formation.iris.hibernate.model.entity.Manga;

import javax.persistence.*;

public class MangaLogListener {

    @PrePersist
    public void logNewMangaAttempt(Manga entity) {
        System.out.println("Tentative d'ajout du " + entity.getClass().getSimpleName() + " : " + entity.getTitle());
    }

    @PostPersist
    public void logNewMangaAdded(Manga entity) {
        System.out.println(entity.getClass().getSimpleName() + " " + entity.getTitle() + " ajouté");
    }

    @PreUpdate
    public void beforeUpdateAction(Manga entity) {
        System.out.println("Tentative de modification du " + entity.getClass().getSimpleName() + " : " + entity.getTitle());
    }

    @PostUpdate
    public void afterUpdateAction(Manga entity) {
        System.out.println(entity.getClass().getSimpleName() + " " + entity.getTitle() + " modifié");
    }

    @PreRemove
    public void beforeRemoveAction(Manga entity) {
        System.out.println("Tentative de suppression du " + entity.getClass().getSimpleName() + " : " + entity.getTitle());
    }

    @PostRemove
    public void afterRemoveAction(Manga entity) {
        System.out.println(entity.getClass().getSimpleName()+ " " + entity.getTitle() + " supprimé");
    }
}
