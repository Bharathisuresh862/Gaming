package com.gaming.gamingsystem.controllers;

import com.gaming.gamingsystem.entities.Collections;
import com.gaming.gamingsystem.services.CollectionsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collections")
public class CollectionsController {

    private final CollectionsService service;

    public CollectionsController(CollectionsService service) {
        this.service = service;
    }

    @PostMapping
    public Collections create(@RequestBody Collections entry) {
        return service.create(entry);
    }

    @GetMapping
    public List<Collections> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Collections getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Collections update(@PathVariable String id, @RequestBody Collections updated) {
        return service.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id) {
        return service.delete(id);
    }
}
