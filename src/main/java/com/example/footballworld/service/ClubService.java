package com.example.footballworld.service;

import com.example.footballworld.mapper.ClubMapper;
import com.example.footballworld.model.Club;
import com.example.footballworld.model.League;
import com.example.footballworld.model.dto.ClubDTO;
import com.example.footballworld.repository.ClubRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ClubService {
    private final ClubRepository clubRepository;
    private final LeagueService leagueService;
    private final ClubMapper clubMapper;

    public ClubService(ClubRepository clubRepository, LeagueService leagueService, ClubMapper clubMapper) {
        this.clubRepository = clubRepository;
        this.leagueService = leagueService;
        this.clubMapper = clubMapper;
    }

    public Club save(ClubDTO clubDTO) {
        Club club = clubMapper.toEntity(clubDTO);
        League league = leagueService.findById(clubDTO.getLeagueId())
                .orElseThrow(()->new EntityNotFoundException("Couldn't find a League with passed id"));
        club.setLeague(league);
        league.getClubs().add(club);
        return clubRepository.save(club);
    }

    public List<Club> getAll() {
        return clubRepository.findAll();
    }

    public Optional<Club> findById(Long id) {
        return clubRepository.findById(id);
    }

    public Club updateClub(Long id, Club club) {
        Club modifiedClub = clubRepository.getById(id);
        modifiedClub.setName(club.getName());
        modifiedClub.setCity(club.getCity());
        modifiedClub.setAddress(club.getAddress());
        modifiedClub.setYearCreation(club.getYearCreation());
        modifiedClub.setPlayers(club.getPlayers());
        return clubRepository.save(modifiedClub);
    }

    public void delete(Long id) {
        clubRepository.deleteById(id);
    }
}
