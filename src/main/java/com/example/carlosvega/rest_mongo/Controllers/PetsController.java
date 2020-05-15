package com.example.carlosvega.rest_mongo.Controllers;

import com.example.carlosvega.rest_mongo.models.Pet;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.carlosvega.rest_mongo.repositories.PetsRepository;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/v1/pets")
@RestController
public class PetsController {

    @Autowired
    private PetsRepository petsRepository;

    @GetMapping
    public List<Pet> getAllPets() {
        return petsRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Pet getPetsById(@PathVariable("id") ObjectId id) {
        return petsRepository.findBy_id(id);
    }

    @PostMapping
    public Pet modifyPetById(@Valid @RequestBody Pet pet) {
        pet.set_id(ObjectId.get());
        petsRepository.save(pet);
        return pet;
    }

    @PutMapping(value = "/{id}")
    public Pet modifyPetById(@PathVariable("id") ObjectId id, @Valid @RequestBody Pet pet) {
        pet.set_id(id);
        petsRepository.save(pet);
        return pet;
    }

    @DeleteMapping(value = "{id}")
    public String deletePet(@PathVariable("id") ObjectId id) {
        petsRepository.delete(petsRepository.findBy_id(id));
        return "ok";
    }
}
