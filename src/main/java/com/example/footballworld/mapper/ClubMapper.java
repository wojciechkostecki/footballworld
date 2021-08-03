package com.example.footballworld.mapper;

import org.mapstruct.Mapper;
import com.example.footballworld.model.Club;
import com.example.footballworld.model.dto.ClubDTO;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClubMapper extends EntityMapper<ClubDTO, Club>{

    @Mapping(target = "id", source = "leagueId")
    Club toEntity(ClubDTO clubDTO);
}
