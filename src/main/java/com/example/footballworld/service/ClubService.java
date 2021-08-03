package com.example.footballworld.service;

import com.example.footballworld.model.Club;
import com.example.footballworld.repository.ClubRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubService {
    private final ClubRepository clubRepository;

    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public Club save(Club club) {
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
        return save(modifiedClub);
    }

    public void delete(Long id) {
        clubRepository.deleteById(id);
    }
}
