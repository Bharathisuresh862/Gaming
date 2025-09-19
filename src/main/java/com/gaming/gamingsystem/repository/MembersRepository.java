package com.gaming.gamingsystem.repository;

import com.gaming.gamingsystem.entities.Members;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface MembersRepository extends MongoRepository<Members, String> {
    Optional<Members> findByPhone(String phone);
    Optional<Members> findByMemberId(String memberId);
}
