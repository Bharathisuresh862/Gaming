package com.gaming.gamingsystem.repository;

import com.gaming.gamingsystem.entities.Game;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface GameRepository extends MongoRepository<Game, String> {
    List<Game> findByNameContainingIgnoreCase(String name);
    List<Game> findByPlayerCount(int playerCount);
}
