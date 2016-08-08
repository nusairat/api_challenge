package com.disney.studios.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * This is a domain for the breed information.
 */
@Entity
public class Breed {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany(mappedBy = "breed", cascade = CascadeType.ALL, targetEntity = Dog.class)
    @OrderBy("votes desc")
    private Set<Dog> dogs;

    public Breed() { }

    public Breed(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public Set<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(Set<Dog> dogs) {
        this.dogs = dogs;
    }

    public String toString() {
        return String.format(
                "Breed[id=%d, breed='%s']",
                id, name);
    }
}