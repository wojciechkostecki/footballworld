package com.example.footballworld.controller;

import com.example.footballworld.model.League;
import com.example.footballworld.service.LeagueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leagues")
public class LeagueController {
    private final LeagueService leagueService;

    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @PostMapping
    public ResponseEntity<League> createLeague(@RequestBody League league) {
        League savedLeague = leagueService.save(league);
        return new ResponseEntity<>(savedLeague, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<League>> getAllLeagues() {
        return ResponseEntity.ok(leagueService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<League> getLeague(@PathVariable Long id) {
        return ResponseEntity.ok(leagueService.findById(id).get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<League> updateLeague(@PathVariable Long id, @RequestBody League league) {
        return ResponseEntity.ok(leagueService.updateLeague(id, league));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeague(@PathVariable Long id) {
        leagueService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
