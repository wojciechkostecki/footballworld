package com.example.footballworld.controller;

import com.example.footballworld.model.Player;
import com.example.footballworld.model.dto.PlayerDTO;
import com.example.footballworld.service.PlayerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public String viewPlayers(Model model) {
        model.addAttribute("listPlayers", playerService.getAll());
        return "players";
    }

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody PlayerDTO player) {
        Player savedPlayer = playerService.save(player);
        return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Player>> getAllPlayers() {
        return ResponseEntity.ok(playerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayer(@PathVariable Long id) {
        return ResponseEntity.ok(playerService.findById(id).get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @RequestBody Player player) {
        return ResponseEntity.ok(playerService.updatePlayer(id, player));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        playerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Returns the average salary of all players.")
    @GetMapping("/average-salary")
    public ResponseEntity<Double> getPlayersAverageSalary() {
        return ResponseEntity.ok(playerService.getPlayersAverageSalary());
    }
}
