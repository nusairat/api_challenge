package com.disney.studios.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.disney.studios.dao.DogRepository;
import com.disney.studios.domain.Dog;

@Service
public class VotingService {

    @Autowired
    DogRepository dogRepository;

    /**
     * This will allow a client to vote on a picture, however
     * you are only allowed to vote once per client
     *
     * @return true/false whether voting was allowed and completed or not.
     */
    public boolean vote(long id, boolean voteUp, String client) {
        Dog dog = dogRepository.findOne(id);
        if (voteUp) dog.incrementVote();
        else dog.decrementVote();

        dogRepository.save(dog);
        return true;
    }
}