package com.example.carlosvega.rest_mongo.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Pet {

    @Id
    private ObjectId _id;

    private String name;
    private String species;
    private  String breed;

    public Pet() {
    }

    public Pet(ObjectId _id, String name, String species, String breed) {
        this._id = _id;
        this.name = name;
        this.species = species;
        this.breed = breed;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getBreed() {
        return breed;
    }
}
