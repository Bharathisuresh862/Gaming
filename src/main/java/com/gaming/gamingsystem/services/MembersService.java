package com.gaming.gamingsystem.services;

import com.gaming.gamingsystem.dto.GameDTO;
import com.gaming.gamingsystem.dto.MemberProfileDTO;
import com.gaming.gamingsystem.dto.PlayedHistoryDTO;
import com.gaming.gamingsystem.entities.Members;
import com.gaming.gamingsystem.entities.Recharges;
import com.gaming.gamingsystem.entities.Transactions;
import com.gaming.gamingsystem.entities.Game;
import com.gaming.gamingsystem.exceptions.ResourceNotFoundException;
import com.gaming.gamingsystem.repository.MembersRepository;
import com.gaming.gamingsystem.repository.RechargesRepository;
import com.gaming.gamingsystem.repository.TransactionsRepository;
import com.gaming.gamingsystem.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MembersService {
    private final MembersRepository membersRepo;
    private final RechargesRepository rechargesRepo;
    private final TransactionsRepository transactionsRepo;
    private final GameRepository gamesRepo;

    public MembersService(MembersRepository membersRepo, RechargesRepository rechargesRepo,
                          TransactionsRepository transactionsRepo, GameRepository gamesRepo){
        this.membersRepo = membersRepo;
        this.rechargesRepo = rechargesRepo;
        this.transactionsRepo = transactionsRepo;
        this.gamesRepo = gamesRepo;
    }

    public Members create(Members m){ m.setId(null); return membersRepo.save(m); }
    public List<Members> findAll(){ return membersRepo.findAll(); }
    public Members findById(String id){ return membersRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Member not found: "+id)); }
    public Members update(String id, Members m){ Members old = findById(id); old.setName(m.getName()); old.setPhone(m.getPhone()); old.setBalance(m.getBalance()); return membersRepo.save(old); }
    public void delete(String id){ if(!membersRepo.existsById(id)) throw new ResourceNotFoundException("Member not found: "+id); membersRepo.deleteById(id); }

    // searchByPhone builds the profile DTO
    public MemberProfileDTO searchByPhone(String phone){
        Members member = membersRepo.findByPhone(phone).orElseThrow(() -> new ResourceNotFoundException("Member not found with phone: "+phone));
        List<Recharges> rechargeHistory = rechargesRepo.findByMemberId(member.getId());
        List<GameDTO> games = gamesRepo.findAll().stream()
                .map(g -> new GameDTO(g.getId(), g.getName(), g.getDescription(), g.getPrice(),
                        g.getMinCount(), g.getMaxCount(), g.getDuration(), g.getPlayerCount()))
                .collect(Collectors.toList());
        List<PlayedHistoryDTO> playedHistory = transactionsRepo.findByMemberId(member.getId()).stream()
                .map(t -> {
                    Game game = gamesRepo.findById(t.getGameId()).orElse(null);
                    String gameName = (game != null) ? game.getName() : "Unknown";
                    return new PlayedHistoryDTO(gameName, t.getAmount(), t.getDateTime());
                }).collect(Collectors.toList());

        return new MemberProfileDTO(member, rechargeHistory, games, playedHistory);
    }
}
