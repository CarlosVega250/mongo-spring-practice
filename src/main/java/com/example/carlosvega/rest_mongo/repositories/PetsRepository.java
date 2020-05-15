package com.example.carlosvega.rest_mongo.repositories;

import com.example.carlosvega.rest_mongo.models.Pet;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PetsRepository extends MongoRepository<Pet, String> {

    Pet findBy_id(ObjectId _id);
}
