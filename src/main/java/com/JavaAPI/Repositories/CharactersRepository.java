package com.JavaAPI.Repositories;

import com.JavaAPI.Models.Character;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
@Component("CharRepo")
public interface CharactersRepository extends MongoRepository<Character, String> {

}
