package be.technobel.formation.iris.hibernate.model;

import javax.persistence.Embeddable;

@Embeddable
public class Edition {

    private String name;
    private String locationPlace;

    public Edition() {
    }

    public Edition(String name, String locationPlace) {
        this.name = name;
        this.locationPlace = locationPlace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocationPlace() {
        return locationPlace;
    }

    public void setLocationPlace(String locationPlace) {
        this.locationPlace = locationPlace;
    }
}
