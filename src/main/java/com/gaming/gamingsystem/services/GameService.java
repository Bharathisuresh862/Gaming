package com.gaming.gamingsystem.services;

import com.gaming.gamingsystem.entities.Game;
import com.gaming.gamingsystem.exceptions.ResourceNotFoundException;
import com.gaming.gamingsystem.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private final GameRepository repo;
    public GameService(GameRepository repo){ this.repo = repo; }

    public Game create(Game g){ g.setId(null); return repo.save(g); }
    public List<Game> findAll(){ return repo.findAll(); }
    public Game findById(String id){ return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Game not found: "+id)); }
    public Game update(String id, Game g){
        Game old = findById(id);
        old.setName(g.getName()); old.setDescription(g.getDescription()); old.setPrice(g.getPrice());
        old.setMinCount(g.getMinCount()); old.setMaxCount(g.getMaxCount());
        old.setDuration(g.getDuration()); old.setPlayerCount(g.getPlayerCount());
        return repo.save(old);
    }
    public void delete(String id){ if(!repo.existsById(id)) throw new ResourceNotFoundException("Game not found: "+id); repo.deleteById(id); }
}
