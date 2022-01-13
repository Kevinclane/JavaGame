package com.JavaAPI.Repositories;


import com.JavaAPI.Models.Spellbook;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component("SpellbookRepo")
public interface SpellbooksRepository extends MongoRepository<Spellbook, String> {
}
