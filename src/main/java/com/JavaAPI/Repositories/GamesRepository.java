package com.JavaAPI.Repositories;

import com.JavaAPI.Models.Game;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component("GameRepo")
public interface GamesRepository extends MongoRepository<Game, String> {
}
