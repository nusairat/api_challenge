package com.disney.studios.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.disney.studios.dao.BreedRepository;
import com.disney.studios.dao.DogRepository;

import com.disney.studios.service.VotingService;

import com.disney.studios.domain.Breed;
import com.disney.studios.domain.Dog;

import com.disney.studios.util.Logger;
import com.disney.studios.util.JSONMessageObject;

@RestController
public class DogController implements Logger {

    @Autowired
    DogRepository dogRepository;

    @Autowired
    BreedRepository breedRepository;

    @Autowired
    VotingService votingService;

    @RequestMapping("/dogs/list")
    @ResponseBody
    public List<Breed> listOfDogs() {
        info("Retrieve list of Dogs");
        List<Breed> breeds = (List<Breed>) breedRepository.findAllByOrderByNameAsc();

        return breeds;
    }

    @RequestMapping("/dogs/list/{breed}")
    public List<Dog> listOfDogsByBreed(@PathVariable("breed") String breed) {
        info("Retrieve list of dogs by breed " + breed);
        List<Dog> dogs = (List<Dog>) dogRepository.findAllByBreed(breed);

        return dogs;
    }

    @RequestMapping("/dogs/{id}")
    @ResponseBody
    public Dog dogInformation(@PathVariable("id") Long id) {
        info("Retrieve information of a dog for " + id);
        Dog dog = dogRepository.findOne(id);

        return dog;
    }

    @RequestMapping("/dogs/vote/up/{id}/{client}")
    public ResponseEntity voteUp(@PathVariable("id") Long id, @PathVariable("client") String client) {
        info("Vote up a dog : " + id);
        boolean success = votingService.vote(id, true, client);

        if (success) return voteSuccess();
        else return voteFailure();
    }

    @RequestMapping("/dogs/vote/down/{id}/{client}")
    public ResponseEntity voteDown(@PathVariable("id") Long id, @PathVariable("client") String client) {
        info("Vote down a dog : " + id);
        boolean success = votingService.vote(id, false, client);

        if (success) return voteSuccess();
        else return voteFailure();
    }

    private ResponseEntity voteSuccess() {
        return new ResponseEntity<>(new JSONMessageObject("vote successfull", true), HttpStatus.OK);
    }

    private ResponseEntity voteFailure() {
        return new ResponseEntity<>(new JSONMessageObject("client has already tried", false), HttpStatus.NOT_ACCEPTABLE);
    }
}