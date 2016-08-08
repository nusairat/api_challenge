package com.disney.studios;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.disney.studios.dao.BreedRepository;
import com.disney.studios.dao.DogRepository;
import com.disney.studios.domain.Dog;
import com.disney.studios.domain.Breed;

/**
 * Loads stored objects from the file system and builds up
 * the appropriate objects to add to the data source.
 *
 * Created by fredjean on 9/21/15.
 */
@Component
public class PetLoader implements InitializingBean {
    // Resources to the different files we need to load.
    @Value("classpath:data/labrador.txt")
    private Resource labradors;

    @Value("classpath:data/pug.txt")
    private Resource pugs;

    @Value("classpath:data/retriever.txt")
    private Resource retrievers;

    @Value("classpath:data/yorkie.txt")
    private Resource yorkies;

    @Autowired
    DataSource dataSource;

    @Autowired
    BreedRepository breedRepository;

    @Autowired
    DogRepository dogRepository;

    /**
     * Load the different breeds into the data source after
     * the application is ready.
     *
     * @throws Exception In case something goes wrong while we load the breeds.
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        loadBreed("Labrador", labradors);
        loadBreed("Pug", pugs);
        loadBreed("Retriever", retrievers);
        loadBreed("Yorkie", yorkies);
    }

    /**
     * Reads the list of dogs in a category and (eventually) add
     * them to the data source.
     * @param breed The breed that we are loading.
     * @param source The file holding the breeds.
     * @throws IOException In case things go horribly, horribly wrong.
     */
    private void loadBreed(String breedName, Resource source) throws IOException {
        try ( BufferedReader br = new BufferedReader(new InputStreamReader(source.getInputStream()))) {
            // Save the breed first
            Breed breed = breedRepository.save(new Breed(breedName));
System.out.println("BREED :: " + breed);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                /* TODO: Create appropriate objects and save them to
                 *       the datasource.
                 */
                Dog dog = dogRepository.save(new Dog(line, breed, 0));
System.out.println("DOG :: " + dog);
            }
        }
    }
}
