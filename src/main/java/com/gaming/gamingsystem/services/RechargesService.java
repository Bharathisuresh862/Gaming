package com.gaming.gamingsystem.services;

import com.gaming.gamingsystem.entities.Recharges;
import com.gaming.gamingsystem.entities.Members;
import com.gaming.gamingsystem.exceptions.ResourceNotFoundException;
import com.gaming.gamingsystem.repository.RechargesRepository;
import com.gaming.gamingsystem.repository.MembersRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RechargesService {
    private final RechargesRepository repo;
    private final MembersRepository membersRepo;
    public RechargesService(RechargesRepository repo, MembersRepository membersRepo){ this.repo = repo; this.membersRepo = membersRepo; }

    public Recharges create(Recharges r){
        r.setId(null);
        if (r.getDateTime() == null) r.setDateTime(new Date());
        Recharges saved = repo.save(r);
        // update member balance
        Members m = membersRepo.findById(r.getMemberId()).orElseThrow(() -> new ResourceNotFoundException("Member not found: " + r.getMemberId()));
        m.setBalance(m.getBalance() + r.getAmount());
        membersRepo.save(m);
        return saved;
    }

    public List<Recharges> findByMember(String memberId){ return repo.findByMemberId(memberId); }
    public List<Recharges> findByDateRange(Date from, Date to){ return repo.findByDateTimeBetween(from, to); }
}
