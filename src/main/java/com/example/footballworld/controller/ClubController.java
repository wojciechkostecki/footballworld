package com.example.footballworld.controller;

import com.example.footballworld.model.Club;
import com.example.footballworld.model.dto.ClubDTO;
import com.example.footballworld.service.ClubService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clubs")
public class ClubController {
    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @PostMapping
    public ResponseEntity<Club> createClub(@RequestBody ClubDTO club) {
        Club savedClub = clubService.save(club);
        return new ResponseEntity<>(savedClub, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Club>> getAllClubs() {
        return ResponseEntity.ok(clubService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Club> getClub(@PathVariable Long id) {
        return ResponseEntity.ok(clubService.findById(id).get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Club> updateClub(@PathVariable Long id, @RequestBody Club club) {
        return ResponseEntity.ok(clubService.updateClub(id, club));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClub(@PathVariable Long id) {
        clubService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "The average salary of the employees of a given club",
            notes = "Endpoint returns the average salary of players from the club that is searched for after the passed Id." +
                    "An exception is thrown if the club cannot be found after the passed Id")
    @GetMapping("/{id}/players/average-salary")
    public ResponseEntity<Double> getPlayersAverageSalaryInClub(@ApiParam(value = "Unique id of club") @PathVariable Long id) {
        return ResponseEntity.ok(clubService.getPlayersAverageSalaryInClub(id));
    }
}
