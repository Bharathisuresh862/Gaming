package com.gaming.gamingsystem.repository;

import com.gaming.gamingsystem.entities.Transactions;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Date;
import java.util.List;

public interface TransactionsRepository extends MongoRepository<Transactions, String> {
    List<Transactions> findByMemberId(String memberId);
    List<Transactions> findByDateTimeBetween(Date from, Date to);
}
