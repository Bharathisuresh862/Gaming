package com.gaming.gamingsystem.services;

import com.gaming.gamingsystem.entities.Users;
import com.gaming.gamingsystem.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository repo;
    public UsersService(UsersRepository repo){ this.repo = repo; }
    public Optional<Users> findByUsername(String username){ return repo.findByUsername(username); }
}
