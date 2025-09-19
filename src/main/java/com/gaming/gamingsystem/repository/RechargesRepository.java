package com.gaming.gamingsystem.repository;

import com.gaming.gamingsystem.entities.Recharges;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Date;
import java.util.List;

public interface RechargesRepository extends MongoRepository<Recharges, String> {
    List<Recharges> findByMemberId(String memberId);
    List<Recharges> findByDateTimeBetween(Date from, Date to);
}
