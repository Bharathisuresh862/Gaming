package com.gaming.gamingsystem.controllers;

import com.gaming.gamingsystem.entities.Transactions;
import com.gaming.gamingsystem.services.TransactionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;
import java.util.List;

@RestController
public class TransactionsController {
    private final TransactionsService service;
    public TransactionsController(TransactionsService service){ this.service = service; }

    // POST /play  { "member_id":"...", "game_id":"..." }
    @PostMapping("/play")
    public ResponseEntity<String> play(@RequestBody Map<String,String> body){
        String memberId = body.get("member_id");
        String gameId = body.get("game_id");
        return ResponseEntity.ok(service.playGame(memberId, gameId));
    }

    @GetMapping("/transactions/member/{memberId}")
    public List<Transactions> byMember(@PathVariable String memberId){ return service.findByMember(memberId); }

    @GetMapping("/transactions/range")
    public List<Transactions> range(@RequestParam long fromMillis, @RequestParam long toMillis){
        return service.findByDateRange(new Date(fromMillis), new Date(toMillis));
    }
}
