package com.gaming.gamingsystem.controllers;

import com.gaming.gamingsystem.services.DynamicCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/dynamic/collection")
public class DynamicCollectionController {

    @Autowired
    private DynamicCollectionService dynamicCollectionService;

    // ✅ GET all documents or by field
    @GetMapping("/{collectionName}")
    public ResponseEntity<?> getDocuments(
            @PathVariable String collectionName,
            @RequestParam(required = false) String field,
            @RequestParam(required = false) String value) {

        if (field != null && value != null) {
            return ResponseEntity.ok(dynamicCollectionService.findByField(collectionName, field, value));
        } else {
            return ResponseEntity.ok(dynamicCollectionService.getAllDocuments(collectionName));
        }
    }

    // ✅ POST a new document
    @PostMapping("/{collectionName}")
    public ResponseEntity<?> addDocument(
            @PathVariable String collectionName,
            @RequestBody Map<String, Object> document) {

        return ResponseEntity.ok(dynamicCollectionService.addDocument(collectionName, document));
    }

    // ✅ PUT: update document by field
    @PutMapping("/{collectionName}")
    public ResponseEntity<?> updateDocument(
            @PathVariable String collectionName,
            @RequestParam String field,
            @RequestParam String value,
            @RequestBody Map<String, Object> updates) {

        dynamicCollectionService.updateDocument(collectionName, field, value, updates);
        return ResponseEntity.ok("Document updated successfully");
    }

    // ✅ DELETE document by field
    @DeleteMapping("/{collectionName}")
    public ResponseEntity<?> deleteDocument(
            @PathVariable String collectionName,
            @RequestParam String field,
            @RequestParam String value) {

        dynamicCollectionService.deleteDocument(collectionName, field, value);
        return ResponseEntity.ok("Document deleted successfully");
    }
}
