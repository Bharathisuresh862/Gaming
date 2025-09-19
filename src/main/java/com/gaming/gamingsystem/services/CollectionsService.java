package com.gaming.gamingsystem.services;

import com.gaming.gamingsystem.entities.Collections;
import com.gaming.gamingsystem.exceptions.ResourceNotFoundException;
import com.gaming.gamingsystem.repository.CollectionsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionsService {
    private final CollectionsRepository repo;

    public CollectionsService(CollectionsRepository repo) {
        this.repo = repo;
    }

    public Collections create(Collections entry) {
        entry.setId(null); // let MongoDB generate ID
        return repo.save(entry);
    }

    public List<Collections> findAll() {
        return repo.findAll();
    }

    public Collections findById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Collection not found: " + id));
    }

    public Collections update(String id, Collections updated) {
        Collections old = findById(id);
        old.setDate(updated.getDate());
        old.setAmount(updated.getAmount());
        return repo.save(old);
    }

    public boolean delete(String id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Collection not found: " + id);
        }
        repo.deleteById(id);
        return true;
    }
}
