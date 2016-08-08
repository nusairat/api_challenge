package com.disney.studios.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.disney.studios.domain.Dog;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {

    @Query("Select d From Dog d where d.breed.name = :name")
    public List<Dog> findAllByBreed(@Param("name") String name);
}