package com.example.footballworld.service;

import com.example.footballworld.mapper.PlayerMapper;
import com.example.footballworld.model.Club;
import com.example.footballworld.model.Player;
import com.example.footballworld.model.dto.PlayerDTO;
import com.example.footballworld.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final ClubService clubService;
    private final PlayerMapper playerMapper;

    public PlayerService(PlayerRepository playerRepository, ClubService clubService, PlayerMapper playerMapper) {
        this.playerRepository = playerRepository;
        this.clubService = clubService;
        this.playerMapper = playerMapper;
    }

    public Player save(PlayerDTO playerDTO) {
        Player player = playerMapper.toEntity(playerDTO);
        Club club = clubService.findById(playerDTO.getClubId())
                .orElseThrow(() -> new EntityNotFoundException("Couldn't find a Club with passed id"));
        player.setClub(club);
        return playerRepository.save(player);
    }

    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    public Optional<Player> findById(Long id) {
        return playerRepository.findById(id);
    }

    public Player updatePlayer(Long id, Player player) {
        Player modifiedPlayer = playerRepository.getById(id);
        modifiedPlayer.setFirstName(player.getFirstName());
        modifiedPlayer.setLastName(player.getLastName());
        modifiedPlayer.setClub(player.getClub());
        modifiedPlayer.setMatchesPlayed(player.getMatchesPlayed());
        modifiedPlayer.setMinutesPlayed(player.getMinutesPlayed());
        modifiedPlayer.setMonthlySalary(player.getMonthlySalary());
        return playerRepository.save(modifiedPlayer);
    }

    public void delete(Long id) {
        playerRepository.deleteById(id);
    }

    public double getPlayersAverageSalary() {
        List<Player> players = playerRepository.findAll();
        return players.stream().collect(Collectors.averagingDouble(Player::getMonthlySalary));
    }
}
