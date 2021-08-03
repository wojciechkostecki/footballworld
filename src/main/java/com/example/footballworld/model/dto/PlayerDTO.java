package com.example.footballworld.model.dto;

import lombok.Data;

@Data
public class PlayerDTO {

    private String firstName;

    private String lastName;

    private Long clubId;

    private int matchesPlayed;

    private int minutesPlayed;

    private double monthlySalary;
}
