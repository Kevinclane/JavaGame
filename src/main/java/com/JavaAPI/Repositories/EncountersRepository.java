package com.JavaAPI.Repositories;

import com.JavaAPI.Models.Encounter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component("EncounterRepo")
public interface EncountersRepository extends MongoRepository<Encounter, String> {
}
