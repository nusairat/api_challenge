package com.disney.studios.domain;

import javax.persistence.*;

/**
 * Information for each of our dogs.
 */
@Entity
public class Dog {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String pictureUrl;
    @ManyToOne
    @JoinColumn(name = "breed_id")
    private Breed breed;

    private long votes = 0;

    public Dog() { }

    public Dog(String pictureUrl, Breed breed, long votes) {
        this.pictureUrl = pictureUrl;
        this.breed = breed;
        this.votes = votes;
    }

    public String toString() {
      return String.format(
                "Dog[id=%d, breed='%s', pictureUrl='%s', votes=%d]",
                id, breed, pictureUrl, votes);
    }

    public long getId() {
        return id;
    }

    public long getVotes() {
        return votes;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public long setVotes(long votes) {
        return this.votes = votes;
    }

    public String getBreedName() {
        return breed.getName();
    }

    public void incrementVote() {
        votes++;
    }

    public void decrementVote() {
        votes--;
    }
}