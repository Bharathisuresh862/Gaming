package com.gaming.gamingsystem.controllers;

import com.gaming.gamingsystem.dto.MemberProfileDTO;
import com.gaming.gamingsystem.entities.Members;
import com.gaming.gamingsystem.services.MembersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;

@RestController
public class MembersController {
    private final MembersService service;
    public MembersController(MembersService service){ this.service = service; }

    @PostMapping("/members")
    public ResponseEntity<Members> create(@RequestBody Members m) { return ResponseEntity.ok(service.create(m)); }

    @GetMapping("/members")
    public List<Members> all(){ return service.findAll(); }

    @GetMapping("/members/{id}")
    public ResponseEntity<Members> get(@PathVariable String id){ return ResponseEntity.ok(service.findById(id)); }

    @PutMapping("/members/{id}")
    public ResponseEntity<Members> update(@PathVariable String id, @RequestBody Members m){ return ResponseEntity.ok(service.update(id,m)); }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){ service.delete(id); return ResponseEntity.noContent().build(); }

    // POST /members/search  { "phone": "9876543210" }
    @PostMapping("/members/search")
    public ResponseEntity<MemberProfileDTO> searchByPhone(@RequestBody Map<String,String> body){
        String phone = body.get("phone");
        return ResponseEntity.ok(service.searchByPhone(phone));
    }
}
