package com.gaming.gamingsystem.services;

import com.gaming.gamingsystem.entities.Game;
import com.gaming.gamingsystem.entities.Members;
import com.gaming.gamingsystem.entities.Transactions;
import com.gaming.gamingsystem.exceptions.BusinessException;
import com.gaming.gamingsystem.exceptions.ResourceNotFoundException;
import com.gaming.gamingsystem.repository.GameRepository;
import com.gaming.gamingsystem.repository.MembersRepository;
import com.gaming.gamingsystem.repository.TransactionsRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionsService {
    private final TransactionsRepository transRepo;
    private final MembersRepository membersRepo;
    private final GameRepository gamesRepo;

    public TransactionsService(TransactionsRepository transRepo, MembersRepository membersRepo, GameRepository gamesRepo){
        this.transRepo = transRepo; this.membersRepo = membersRepo; this.gamesRepo = gamesRepo;
    }

    // Play game: deduct balance, create transaction
    public String playGame(String memberId, String gameId){
        Members member = membersRepo.findById(memberId).orElseThrow(() -> new ResourceNotFoundException("Member not found: "+memberId));
        Game game = gamesRepo.findById(gameId).orElseThrow(() -> new ResourceNotFoundException("Game not found: "+gameId));
        double price = game.getPrice();
        if(member.getBalance() < price) {
            return "Insufficient balance!";
        }
        member.setBalance(member.getBalance() - price);
        membersRepo.save(member);

        Transactions tx = new Transactions();
        tx.setId(null);
        tx.setMemberId(memberId);
        tx.setGameId(gameId);
        tx.setAmount(price);
        tx.setDateTime(new Date());
        transRepo.save(tx);

        return "Game played successfully!";
    }

    public List<Transactions> findByMember(String memberId){ return transRepo.findByMemberId(memberId); }
    public List<Transactions> findByDateRange(Date from, Date to){ return transRepo.findByDateTimeBetween(from,to); }
}
