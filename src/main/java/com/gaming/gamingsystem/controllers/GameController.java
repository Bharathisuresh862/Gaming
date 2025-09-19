package com.gaming.gamingsystem.controllers;

import com.gaming.gamingsystem.entities.Game;
import com.gaming.gamingsystem.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    private final GameService service;
    public GameController(GameService service){ this.service = service; }

    @GetMapping
    public List<Game> all(){ return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Game> get(@PathVariable String id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Game> create(@RequestBody Game g){ return ResponseEntity.ok(service.create(g)); }

    @PutMapping("/{id}")
    public ResponseEntity<Game> update(@PathVariable String id, @RequestBody Game g){ return ResponseEntity.ok(service.update(id,g)); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){ service.delete(id); return ResponseEntity.noContent().build(); }
}
