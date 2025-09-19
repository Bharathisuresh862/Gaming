package com.gaming.gamingsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DynamicCollectionService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Map> getAllDocuments(String collectionName) {
        return mongoTemplate.findAll(Map.class, collectionName);
    }

    public List<Map> findByField(String collectionName, String field, String value) {
        return mongoTemplate.find(
                new org.springframework.data.mongodb.core.query.Query(
                        org.springframework.data.mongodb.core.query.Criteria.where(field).is(value)
                ),
                Map.class,
                collectionName
        );
    }

    public Map addDocument(String collectionName, Map<String, Object> document) {
        return mongoTemplate.save(document, collectionName);
    }

    public void updateDocument(String collectionName, String field, String value, Map<String, Object> updates) {
        var query = new org.springframework.data.mongodb.core.query.Query(
                org.springframework.data.mongodb.core.query.Criteria.where(field).is(value)
        );
        var update = new org.springframework.data.mongodb.core.query.Update();
        updates.forEach(update::set);
        mongoTemplate.updateFirst(query, update, collectionName);
    }

    public void deleteDocument(String collectionName, String field, String value) {
        var query = new org.springframework.data.mongodb.core.query.Query(
                org.springframework.data.mongodb.core.query.Criteria.where(field).is(value)
        );
        mongoTemplate.remove(query, collectionName);
    }
}
