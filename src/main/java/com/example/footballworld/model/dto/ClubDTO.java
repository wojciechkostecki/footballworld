package com.example.footballworld.model.dto;

import lombok.Data;

@Data
public class ClubDTO {

    private String name;

    private Long leagueId;

    private String city;

    private String address;

    private int yearCreation;
}
