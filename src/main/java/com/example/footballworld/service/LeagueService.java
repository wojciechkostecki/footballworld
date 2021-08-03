package com.example.footballworld.service;

import com.example.footballworld.model.League;
import com.example.footballworld.repository.LeagueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeagueService {
    private final LeagueRepository leagueRepository;

    public LeagueService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public League save(League league) {
        return leagueRepository.save(league);
    }

    public List<League> getAll() {
        return leagueRepository.findAll();
    }

    public Optional<League> findById(Long id) {
        return leagueRepository.findById(id);
    }

    public League updateLeague(Long id, League league) {
        League modifiedLeague = leagueRepository.getById(id);
        modifiedLeague.setName(league.getName());
        modifiedLeague.setCountry(league.getCountry());
        modifiedLeague.setClubs(league.getClubs());
        return save(modifiedLeague);
    }

    public void delete(Long id) {
        leagueRepository.deleteById(id);
    }
}
