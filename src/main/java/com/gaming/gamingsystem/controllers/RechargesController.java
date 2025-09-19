package com.gaming.gamingsystem.controllers;

import com.gaming.gamingsystem.entities.Recharges;
import com.gaming.gamingsystem.services.RechargesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/recharges")
public class RechargesController {
    private final RechargesService service;
    public RechargesController(RechargesService service){ this.service = service; }

    @PostMapping
    public ResponseEntity<Recharges> create(@RequestBody Recharges r){ return ResponseEntity.ok(service.create(r)); }

    @GetMapping("/member/{memberId}")
    public List<Recharges> byMember(@PathVariable String memberId){ return service.findByMember(memberId); }

    // for date-range queries client can parse yyyy-MM-dd and convert to start/end in client or call the collections endpoint below
    @GetMapping("/range")
    public List<Recharges> range(@RequestParam long fromMillis, @RequestParam long toMillis){
        return service.findByDateRange(new Date(fromMillis), new Date(toMillis));
    }
}
